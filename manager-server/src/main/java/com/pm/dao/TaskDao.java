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

    /**
     * @Description: 根据上级任务ID查询已被删除的子任务列表
     * @Author: CarillonQA
     */
    List<CoreTask> queryDeletedTaskByParentId(@Param("parentId") Integer parentId);

    Integer createTask(@Param("taskDto") TaskDto taskDto);

    /**
     * @Description: 根据项目ID修改任务标识(0:未删除, 1:已删除)
     * @Author: CarillonQA
     */
    Integer updateTaskFlagByProjectId(@Param("projectId") Integer projectId, @Param("delFlag") Integer delFlag);

    /**
     * @Description: 根据任务ID修改任务标识(0:未删除, 1:已删除)
     * @Author: CarillonQA
     */
    Integer updateTaskFlagByTaskId(@Param("taskId") Integer taskId, @Param("delFlag") Integer delFlag);

}
