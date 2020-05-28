package com.whw.dao;

import com.whw.domain.TaskLevel;
import com.whw.domain.TaskStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LevelAndStatusDao {

    @Select("SELECT LEVEL_ID,LEVEL_NAME FROM TASK_LEVEL")
    List<TaskLevel> findAllTaskLevel();
    @Select("SELECT STATUS_ID,STATUS_NAME FROM TASK_STATUS")
    List<TaskStatus> findAllTaskStatus();
}
