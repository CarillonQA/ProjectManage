package com.pm.controller;

import com.pm.entity.task.TaskDto;
import com.pm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    /**
     * @Description:
     * @Author: CarillonQA
     * @param: taskId
     * @return: ResponseEntity<TaskDto>
     */
    @PostMapping("/queryTaskById/{taskId}")
    public ResponseEntity<TaskDto> queryTaskById(@PathVariable Integer taskId) {
        TaskDto taskDto = taskService.queryTaskListById(taskId);
        return ResponseEntity.ok(taskDto);
    }

    /**
     * @Description:
     * @Author: CarillonQA
     * @param: projectId
     * @return: ResponseEntity<List<TaskDto>>
     */
    @PostMapping("/queryTaskByProjectId/{projectId}")
    public ResponseEntity<List<TaskDto>> queryTaskByProjectId(@PathVariable Integer projectId) {
        List<TaskDto> taskDtoList = taskService.queryTaskByProjectId(projectId);
        return ResponseEntity.ok(taskDtoList);
    }

}
