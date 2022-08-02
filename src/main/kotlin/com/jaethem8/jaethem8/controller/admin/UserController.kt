package com.jaethem8.jaethem8.controller.admin

import com.jaethem8.jaethem8.model.user.User
import com.jaethem8.jaethem8.service.user.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(
    private val userService: UserService
) {
    @GetMapping("/users")
    fun getUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok().body(userService.getUsers())
    }
    @PostMapping("/user/save")
    fun saveUser(@RequestBody user:User):ResponseEntity<User>{
        return ResponseEntity.ok().body(userService.save(user))
    }

}