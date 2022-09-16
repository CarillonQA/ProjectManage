package com.pm.service;

import com.pm.entity.task.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto queryTaskListById(Integer taskId);

    List<TaskDto> queryTaskByProjectId(Integer projectId);

    void deleteTaskById(Integer taskId);

}
