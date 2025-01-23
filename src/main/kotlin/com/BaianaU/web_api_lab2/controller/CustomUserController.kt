package com.BaianaU.web_api_lab2.controller

import com.BaianaU.web_api_lab2.model.user.CustomUser
import com.BaianaU.web_api_lab2.repository.CustomUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class CustomUserController @Autowired constructor(
    val customUserRepository: CustomUserRepository,
    val passwordEncoder: PasswordEncoder
) {

    @GetMapping("/password")
    fun getBcryptPassword(): String {

        val testPassword = "123"

        return passwordEncoder.encode(testPassword)

    }

    @GetMapping
    fun getUser(name: String, password: String): ResponseEntity<CustomUser> {
        val user: CustomUser = customUserRepository.findByNameAndPassword(name, password)
        return ResponseEntity.ok(user)
    }

    @PostMapping
    fun saveUser(
        @RequestBody newUser: CustomUser
    ): ResponseEntity<String> {

        val bcryptUser = CustomUser(
            newUser.username,
            passwordEncoder.encode(newUser.password)

        )

        customUserRepository.save(newUser)
        return ResponseEntity.status(201).body("User was successfully created")
    }
}


