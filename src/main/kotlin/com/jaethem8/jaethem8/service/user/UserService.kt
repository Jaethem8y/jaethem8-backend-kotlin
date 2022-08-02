package com.jaethem8.jaethem8.service.user

import com.jaethem8.jaethem8.model.user.User
import com.jaethem8.jaethem8.repository.user.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
):UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        var user:User = userRepository.findByUsername(username)
        var authority:List<SimpleGrantedAuthority> = mutableListOf();
        authority += SimpleGrantedAuthority(user.role)
        return org.springframework.security.core.userdetails.User(user.username,user.password,authority);
    }
    fun save(user: User): User? {
        user.password = passwordEncoder!!.encode(user.password)
        return userRepository.save(user)
    }

    fun getUsers():List<User>{
        return userRepository.findAll();
    }

    fun getUser(username: String): User {
        return userRepository.findByUsername(username)
    }

    fun findByUsername(username: String): User? {
        return userRepository.findByUsername(username)
    }
}