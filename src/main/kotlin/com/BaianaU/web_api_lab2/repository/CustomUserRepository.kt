package com.BaianaU.web_api_lab2.repository

import com.BaianaU.web_api_lab2.model.user.CustomUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface CustomUserRepository: JpaRepository <CustomUser, Long>{
    @Query("SELECT u FROM CustomUser u WHERE u.username = :username")
    fun findByNameAndPassword(@Param("username") username: String): CustomUser
}