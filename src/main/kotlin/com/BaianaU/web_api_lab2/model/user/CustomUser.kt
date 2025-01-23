package com.BaianaU.web_api_lab2.model.user

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.Size

@Entity
class CustomUser (

    @NotEmpty
    @Size (min = 2, max = 20)
    val username: String,

    @NotEmpty
    @Size(min = 7, max = 73)
    val password: String,


    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    val id: Long? = null


) {
}