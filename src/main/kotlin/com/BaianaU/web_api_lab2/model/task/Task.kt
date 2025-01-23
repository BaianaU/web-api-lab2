package com.BaianaU.web_api_lab2.model.task

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

@Entity
class Task(

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    val id: Long? = null,

    @NotEmpty
    val subject: String,

    @NotEmpty
    val description: String,

    @NotNull
    val userId: Long
) {
}