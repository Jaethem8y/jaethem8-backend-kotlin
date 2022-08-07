package com.jaethem8.jaethem8.configuration

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class CustomAuthorizationFilter : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        if (request.servletPath == "/login") {
            filterChain.doFilter(request, response)
        } else {
            val authoricationHeader = request.getHeader(HttpHeaders.AUTHORIZATION)
            if (authoricationHeader != null && authoricationHeader.startsWith("Bearer ")) {
                try {
                    val token = authoricationHeader.substring("Bearer ".length)
                    val algorithm = Algorithm.HMAC256("env.getProperty()".toByteArray())
                    val verifier = JWT.require(algorithm).build()
                    val decodedJWT = verifier.verify(token)
                    val username = decodedJWT.subject
                    val role = decodedJWT.getClaim("role").asArray(String::class.java)
                    val authorities: MutableCollection<SimpleGrantedAuthority> = ArrayList()
                    Arrays.stream(role).forEach { roles: String? ->
                        authorities.add(
                            SimpleGrantedAuthority(roles)
                        )
                    }
                    val authenticationToken = UsernamePasswordAuthenticationToken(username, null, authorities)
                    SecurityContextHolder.getContext().authentication = authenticationToken
                    filterChain.doFilter(request, response)
                } catch (exception: Exception) {
//                    log.error("Error Login in: {}", exception.message)
                }
            } else {
                filterChain.doFilter(request, response)
            }
        }
    }
}
