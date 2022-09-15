package com.pm.dao;

import com.pm.entity.task.CoreTask;
import com.pm.entity.task.TaskDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskDao {

    List<CoreTask> getAllTask();

    List<CoreTask> querySonTaskByParentId(@Param("parentId") Integer parentId);

    Integer createTask(@Param("taskDto") TaskDto taskDto);

}
