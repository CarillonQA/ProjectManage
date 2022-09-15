package com.pm.controller;

import com.pm.entity.task.TaskDto;
import com.pm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/queryTaskById/{taskId}")
    public ResponseEntity<TaskDto> queryTaskById(@PathVariable Integer taskId) {
        TaskDto taskDto = taskService.queryTaskListById(taskId);
        return ResponseEntity.ok(taskDto);
    }

}
