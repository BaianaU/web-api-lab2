package com.BaianaU.web_api_lab2.repository

import com.BaianaU.web_api_lab2.model.CustomUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CustomUserRepository: JpaRepository <CustomUser, Long>{
    @Query("SELECT u FROM CustomUser u WHERE u.username = :username AND u.password = :password")
    fun findByNameAndPassword(@Param("username") username: String,
                              @Param("password") password: String): CustomUser
}