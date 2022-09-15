package com.pm.controller;

import com.pm.entity.project.CoreProject;
import com.pm.entity.project.ProjectDto;
import com.pm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/project/name")
    public ResponseEntity<CoreProject> getProjectByName(@RequestBody ProjectDto projectDto) {
        CoreProject coreProject = projectService.queryProjectByProjectName(projectDto);
        return ResponseEntity.ok(coreProject);
    }

    // 创建项目
    @PostMapping("/project/create")
    public Boolean createProject(@RequestBody ProjectDto projectDto) {
        return projectService.createProject(projectDto);
    }

}
