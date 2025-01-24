package com.BaianaU.web_api_lab2.controller

import com.BaianaU.web_api_lab2.model.user.CustomUser
import com.BaianaU.web_api_lab2.model.user.UserResponse
import com.BaianaU.web_api_lab2.model.LoginRequest
import com.BaianaU.web_api_lab2.repository.CustomUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam

@RestController
@RequestMapping("/api/v1/user")
class CustomUserController @Autowired constructor(
    val customUserRepository: CustomUserRepository,
    @Qualifier("bcryptPasswordEncoder") val passwordEncoder: PasswordEncoder
) {

    @GetMapping("/password")
    fun getBcryptPassword(): String {

        val testPassword = "123"

        return passwordEncoder.encode(testPassword)

    }

    @PostMapping("/login")
    fun getUser(@RequestBody request: LoginRequest): ResponseEntity<UserResponse> {
        val user: CustomUser = customUserRepository.findByNameAndPassword(request.username)
        passwordEncoder.matches(request.password, user.password)
        val response = UserResponse(user.username, user.id)
        return ResponseEntity.ok(response)
    }

    @PostMapping
    fun saveUser(
        @RequestBody newUser: CustomUser
    ): ResponseEntity<String> {

        val bcryptUser = CustomUser(
            newUser.username,
            passwordEncoder.encode(newUser.password)

        )

        customUserRepository.save(bcryptUser)
        return ResponseEntity.status(201).body("User was successfully created")
    }
}


