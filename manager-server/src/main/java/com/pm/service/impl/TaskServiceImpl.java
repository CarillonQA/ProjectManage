package com.pm.service.impl;

import com.pm.dao.TaskDao;
import com.pm.entity.task.CoreTask;
import com.pm.entity.task.TaskDto;
import com.pm.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDao taskDao;

    /**
     * @Description:
     * @Author: CarillonQA
     * @param: taskId
     * @return: List<TaskDto>
     */
    @Override
    public TaskDto queryTaskListById(Integer taskId) {
        CoreTask coreTask = taskDao.queryTaskById(taskId);
        return queryTaskRecursion(coreTask);
    }

    /**
     * @Description: 递归查询任务列表
     * @Author: CarillonQA
     * @param: coreTask
     * @return: TaskDto
     */
    public TaskDto queryTaskRecursion(CoreTask coreTask) {
        List<CoreTask> sonTaskList = taskDao.querySonTaskByParentId(coreTask.getTaskId());
        List<TaskDto> taskDtoList = new ArrayList<>();
        // 此处返回啥就build啥
        TaskDto taskDtoBuilder = TaskDto.builder().taskId(coreTask.getTaskId()).taskName(coreTask.getTaskName())
                .startDate(coreTask.getStartDate()).endDate(coreTask.getEndDate()).taskState(coreTask.getTaskState())
                .taskPriority(coreTask.getTaskPriority()).taskExecutorId(coreTask.getTaskExecutorId()).build();
        if (sonTaskList != null && sonTaskList.size() != 0) {
            // 开始递归
            for (CoreTask task : sonTaskList) {
                TaskDto taskDto = queryTaskRecursion(task);
                taskDtoList.add(taskDto);
            }
            taskDtoBuilder.setSonTaskList(taskDtoList);
        }
        return taskDtoBuilder;
    }

}
