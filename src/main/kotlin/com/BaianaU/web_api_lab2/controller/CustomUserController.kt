package com.BaianaU.web_api_lab2.controller

import com.BaianaU.web_api_lab2.model.user.CustomUser
import com.BaianaU.web_api_lab2.repository.CustomUserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class CustomUserController @Autowired constructor(
    val customUserRepository: CustomUserRepository
) {

    @GetMapping
    fun getUser(name: String, password: String): ResponseEntity<CustomUser> {
        val user: CustomUser = customUserRepository.findByNameAndPassword(name, password)
        return ResponseEntity.ok(user)
    }

    @PostMapping
    fun saveUser(
        @RequestBody newUser: CustomUser
    ): ResponseEntity<String> {

        customUserRepository.save(newUser)
        return ResponseEntity.status(201).body("User was successfully created")
    }
}


