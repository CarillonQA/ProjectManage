package com.pm.dao;

import com.pm.entity.project.CoreProject;
import com.pm.entity.project.ProjectDto;
import org.apache.ibatis.annotations.Param;

public interface ProjectDao {

    CoreProject queryProjectByProjectName(@Param("projectName") String projectName);

    Integer createProject(@Param("projectDto") ProjectDto projectDto);

    /**
     * @Description: 修改项目标识(0:删除,1:正常)
     * @Author: CarillonQA
     */
    Integer updateProjectFlag(@Param("projectId") Integer projectId, @Param("delFlag") Integer delFlag);

}
