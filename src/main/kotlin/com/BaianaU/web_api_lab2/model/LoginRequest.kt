package com.BaianaU.web_api_lab2.model

import jakarta.validation.constraints.NotEmpty

class LoginRequest (

    @NotEmpty
    val username: String,

    @NotEmpty
    val password: String,

) {
}