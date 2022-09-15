package com.pm.dao;

import org.apache.ibatis.annotations.Param;

public interface RelationDao {

    Integer insertProjectUser(@Param("projectId") Integer projectId, @Param("userId") Integer userId);

}
