package com.pm.dao;

import com.pm.entity.user.CoreUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /**
     * @Description: 获取用户列表
     * @Author: CarillonQA
     */
    List<CoreUser> getUserList();

    CoreUser queryUserByUserName(@Param("username") String username);

    /**
     * @Description: 根据项目ID查询项目组成员
     * @Author: CarillonQA
     */
    List<CoreUser> queryProjectMemberByProjectId(@Param("projectId") Integer projectId);

    /**
     * @Description: 根据上级任务ID查询任务组成员
     * @Author: CarillonQA
     */
    List<CoreUser> queryTaskMemberByTaskId(@Param("parentId") Integer parentId);

}
