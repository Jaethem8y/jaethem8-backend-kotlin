package com.jaethem8.jaethem8.configuration

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import java.io.IOException
import java.util.*
import java.util.stream.Collectors
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class CustomAuthenticationFilter(
    private val authenticationManagerBean: AuthenticationManager,
    bCryptPasswordEncoder: BCryptPasswordEncoder?
) :
    UsernamePasswordAuthenticationFilter() {
    @Throws(AuthenticationException::class)
    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        val username = request.getParameter("username")
        val password = request.getParameter("password")
        val authToken = UsernamePasswordAuthenticationToken(username, password)
        return authenticationManagerBean.authenticate(authToken)
    }

    @Throws(IOException::class, ServletException::class)
    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain,
        authentication: Authentication
    ) {
        val user = authentication.principal as User
        val algorithm = Algorithm.HMAC256("env.getProperty()".toByteArray())
        val access_token =
            JWT.create().withSubject(user.username).withExpiresAt(Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .withIssuer(request.requestURL.toString())
                .withClaim("role", user.authorities.stream().map { obj: GrantedAuthority -> obj.authority }
                    .collect(Collectors.toList())).sign(algorithm)
        val tokens: MutableMap<String, String> = HashMap()
        tokens["access_token"] = access_token
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        ObjectMapper().writeValue(response.outputStream, tokens)
    }
}
