package com.BaianaU.web_api_lab2.repository

import com.BaianaU.web_api_lab2.model.task.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TaskRepository : JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t WHERE t.userId = :userId")
    fun findAllByUserId(@Param("userId") userId: Long): List<Task>
}