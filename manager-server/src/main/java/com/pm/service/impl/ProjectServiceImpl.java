package com.pm.service.impl;

import com.pm.dao.ProjectDao;
import com.pm.dao.RelationDao;
import com.pm.dao.TaskDao;
import com.pm.entity.project.CoreProject;
import com.pm.entity.project.ProjectDto;
import com.pm.entity.user.CoreUser;
import com.pm.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDao projectDao;

    @Autowired
    TaskDao taskDao;

    @Autowired
    RelationDao relationDao;

    @Override
    public CoreProject queryProjectByProjectName(ProjectDto projectDto) {
        CoreProject coreProject = projectDao.queryProjectByProjectName(projectDto.getProjectName());
        List<CoreUser> projectManager = coreProject.getProjectManager();
        ArrayList<CoreUser> managers = new ArrayList<>();
        for (CoreUser coreUser : projectManager) {
            // 根据isManager属性判断是否为项目经理
            if (coreUser.getIsManager() == 1) {
                managers.add(coreUser);
            }
        }
        coreProject.setProjectManager(managers);
        return coreProject;
    }

    @Override
    public Boolean createProject(ProjectDto projectDto) {
//        UserInfo user = UserHolder.getUser();
//        if (user != null) {
//            projectDto.setCreatedById(user.getId());
//            return false;
//        }
        Integer code = projectDao.createProject(projectDto);
        if (code == 1) {
            Integer projectId = projectDto.getProjectId();
            // 假数据测试,后期从前端获取
            CoreUser member1 = new CoreUser();
            member1.setId(2);
            CoreUser member2 = new CoreUser();
            member2.setId(4);
            ArrayList<CoreUser> members = new ArrayList<>();
            members.add(member1);
            members.add(member2);
            projectDto.setProjectMember(members);
            // 将项目和用户关系存入数据库
            for (CoreUser member : members) {
                relationDao.insertProjectUser(projectId, member.getId());
            }
        }
        return true;
    }

    /**
     * @Description: 根据项目ID逻辑删除该项目
     * @Author: CarillonQA
     * @param: projectId
     */
    @Override
    public void deleteProjectById(Integer projectId) {
        Integer integer = projectDao.updateProjectFlag(projectId, 1);
        if (integer != 0) {
            taskDao.updateTaskFlagByProjectId(projectId, 1);
        }
    }

    /**
     * @Description: 根据项目ID恢复被删除的项目
     * @Author: CarillonQA
     * @param: projectId
     * @return: void
     */
    @Override
    public void recoverProjectById(Integer projectId) {
        Integer integer = projectDao.updateProjectFlag(projectId, 0);
        if (integer != 0) {
            taskDao.updateTaskFlagByProjectId(projectId, 0);
        }
    }
}
