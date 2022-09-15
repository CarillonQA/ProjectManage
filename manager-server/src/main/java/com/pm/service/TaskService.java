package com.pm.service;

import com.pm.entity.task.TaskDto;

public interface TaskService {

    TaskDto queryTaskListById(Integer taskId);

}
