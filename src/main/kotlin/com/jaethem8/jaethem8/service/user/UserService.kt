package com.jaethem8.jaethem8.service.user

import com.jaethem8.jaethem8.dto.user.UserDTO
import com.jaethem8.jaethem8.model.user.User
import com.jaethem8.jaethem8.repository.user.UserRepository
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
class UserService(
        private val userRepository: UserRepository,
        private val passwordEncoder: BCryptPasswordEncoder
) : UserDetailsService {
    @Transactional
    fun saveUser(userDTO: UserDTO): User? {
        val user = User()
        user.name = "Jaehyeok Choi"
        user.username = userDTO.username
        user.password = passwordEncoder.encode(userDTO.password)
        user.role = userDTO.role
        return userRepository.save(user)
    }

    @Transactional
    fun getUser(username: String?): User? {
        return userRepository.findByUsername(username)
    }

    @Transactional
    fun getUsers(): List<User?>? {
        return userRepository.findAll()
    }

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails? {
        val user = userRepository.findByUsername(username) ?: throw UsernameNotFoundException("User Not Found")
        val authority: MutableCollection<SimpleGrantedAuthority> = ArrayList()
        authority.add(SimpleGrantedAuthority(user.role))
        return org.springframework.security.core.userdetails.User(user.username, user.password, authority)
    }
}