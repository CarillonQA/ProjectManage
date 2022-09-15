package com.pm.dao;

import com.pm.entity.task.CoreTask;
import com.pm.entity.task.TaskDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskDao {

    List<CoreTask> getAllTask();

    CoreTask queryTaskById(@Param("taskId") Integer taskId);

    /**
     * @Description: 根据项目ID查询该项目下的一级任务
     * @Author: CarillonQA
     */
    List<CoreTask> queryFatherTaskByProjectId(@Param("projectId") Integer projectId);

    /**
     * @Description: 根据上级任务ID查询子任务列表
     * @Author: CarillonQA
     */
    List<CoreTask> querySonTaskByParentId(@Param("parentId") Integer parentId);

    Integer createTask(@Param("taskDto") TaskDto taskDto);

}
