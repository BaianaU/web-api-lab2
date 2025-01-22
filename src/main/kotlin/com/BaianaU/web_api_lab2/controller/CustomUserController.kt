package com.BaianaU.web_api_lab2.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/user")
class CustomUserController {

    @GetMapping
    fun testString(): String {

        return "Hello world"
    }
}