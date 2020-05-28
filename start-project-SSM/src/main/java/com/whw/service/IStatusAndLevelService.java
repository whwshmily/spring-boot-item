package com.whw.service;

import com.whw.domain.TaskLevel;
import com.whw.domain.TaskStatus;

import java.util.List;

public interface IStatusAndLevelService {
    /**
     * 查询所有的 任务级别
     * @return 返回任务级别对象的集合
     */
    List<TaskLevel> findAllTaskLevel();

    /**
     * 查询所有的 任务状态
     * @return 返回任务状态对象的集合
     */
    List<TaskStatus> findAllTaskStatus();
}
