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
     * @Description: 根据任务ID查询该任务及下级子任务
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
     * @Description: 根据项目ID查询该项目下的任务及下级子任务
     * @Author: CarillonQA
     * @param: projectId
     * @return: List<TaskDto>
     */
    @Override
    public List<TaskDto> queryTaskByProjectId(Integer projectId) {
        List<CoreTask> coreTaskList = taskDao.queryFatherTaskByProjectId(projectId);
        List<TaskDto> taskDtoList = new ArrayList<>();
        for (CoreTask fatherTask : coreTaskList) {
            TaskDto taskDto = queryTaskRecursion(fatherTask);
            taskDtoList.add(taskDto);
        }
        return taskDtoList;
    }

    /**
     * @Description: 根据任务ID逻辑删除任务
     * @Author: CarillonQA
     * @param: taskId
     * @return: void
     */
    @Override
    public void deleteTaskById(Integer taskId) {
        deleteTaskRecursion(taskId);
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

    /**
     * @Description: 递归删除任务(逻辑删除)
     * @Author: CarillonQA
     * @param: taskId
     * @return: void
     */
    public void deleteTaskRecursion(Integer taskId) {
        List<CoreTask> taskList = taskDao.querySonTaskByParentId(taskId);
        if (taskList != null && taskList.size() != 0) {
            for (CoreTask task : taskList) {
                deleteTaskRecursion(task.getTaskId());
            }
        }
        taskDao.updateTaskFlagByTaskId(taskId, 0);
    }

}
