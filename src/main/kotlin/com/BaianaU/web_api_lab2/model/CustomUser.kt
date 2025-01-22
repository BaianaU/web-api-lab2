package com.BaianaU.web_api_lab2.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class CustomUser (

    val username: String,
    val password: String,

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    val id: Long? = null


) {
}