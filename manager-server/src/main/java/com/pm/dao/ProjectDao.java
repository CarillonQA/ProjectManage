package com.pm.dao;

import com.pm.entity.project.CoreProject;
import com.pm.entity.project.ProjectDto;
import org.apache.ibatis.annotations.Param;

public interface ProjectDao {

    CoreProject queryProjectByProjectName(@Param("projectName") String projectName);

    Integer createProject(@Param("projectDto") ProjectDto projectDto);

}
