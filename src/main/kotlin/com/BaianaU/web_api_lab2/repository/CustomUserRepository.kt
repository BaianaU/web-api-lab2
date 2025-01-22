package com.BaianaU.web_api_lab2.repository

import com.BaianaU.web_api_lab2.model.CustomUser
import org.springframework.data.jpa.repository.JpaRepository

interface CustomUserRepository: JpaRepository <CustomUser, Long>{
}