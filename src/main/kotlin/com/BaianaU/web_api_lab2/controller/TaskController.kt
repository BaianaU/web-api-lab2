package com.BaianaU.web_api_lab2.controller

import com.BaianaU.web_api_lab2.model.task.Task
import com.BaianaU.web_api_lab2.model.user.CustomUser
import com.BaianaU.web_api_lab2.repository.CustomUserRepository
import com.BaianaU.web_api_lab2.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/api/v1/task")
class TaskController @Autowired constructor(
    val taskRepository: TaskRepository
) {

    @GetMapping
    fun getTask(taskId: Long): ResponseEntity<Task> {
        val task: Optional<Task> = taskRepository.findById(taskId)
        if (task.isPresent) {
            return ResponseEntity.ok(task.get())
        }
        return ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @GetMapping("/userid")
    fun getTasksByUserId(userId: Long): ResponseEntity<List<Task>> {
        val tasks: List<Task> = taskRepository.findAllByUserId(userId)
        return ResponseEntity.ok(tasks)
    }

    @PostMapping
    fun createTask(@RequestBody task: Task): ResponseEntity<Task> {
        val savedTask: Task = taskRepository.save(task)
        return ResponseEntity.ok(savedTask)
    }

    @DeleteMapping
    fun deleteTask(taskId: Long) : ResponseEntity<Void> {
        // TODO make validation if entity exist before delete
        taskRepository.deleteById(taskId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}