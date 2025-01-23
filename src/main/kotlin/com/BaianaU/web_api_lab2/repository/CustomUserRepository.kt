package com.BaianaU.web_api_lab2.repository

import com.BaianaU.web_api_lab2.model.CustomUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param

interface CustomUserRepository: JpaRepository <CustomUser, Long>{
    fun findByNameAndPassword(@Param("username") username: String,
                              @Param("password") password: String): CustomUser
}