package com.whw.service;

import com.whw.dao.LevelAndStatusDao;
import com.whw.domain.TaskLevel;
import com.whw.domain.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusLevelServiceImp implements IStatusAndLevelService {
    @Autowired
    private LevelAndStatusDao dao;
    /**
     * 查询所有的 任务级别
     *
     * @return 返回任务级别对象的集合
     */
    @Override
    public List<TaskLevel> findAllTaskLevel() {
        return dao.findAllTaskLevel();
    }

    /**
     * 查询所有的 任务状态
     *
     * @return 返回任务状态对象的集合
     */
    @Override
    public List<TaskStatus> findAllTaskStatus() {
        return dao.findAllTaskStatus();
    }
}
