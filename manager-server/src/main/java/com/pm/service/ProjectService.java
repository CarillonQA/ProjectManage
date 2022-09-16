package com.pm.service;

import com.pm.entity.project.CoreProject;
import com.pm.entity.project.ProjectDto;

public interface ProjectService {

    CoreProject queryProjectByProjectName(ProjectDto projectDto);

    Boolean createProject(ProjectDto projectDto);

    void deleteProjectById(Integer projectId);

    void recoverProjectById(Integer projectId);

}
