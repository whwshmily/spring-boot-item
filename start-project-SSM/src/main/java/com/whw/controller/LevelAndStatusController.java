package com.whw.controller;

import com.whw.domain.TaskLevel;
import com.whw.domain.TaskStatus;
import com.whw.service.IStatusAndLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/task")
public class LevelAndStatusController {
    @Autowired
    private IStatusAndLevelService service;

    @RequestMapping("/level")
    @ResponseBody
    public List<TaskLevel> findAllLevel(){
        return service.findAllTaskLevel();
    }
    @RequestMapping("/status")
    @ResponseBody
    public List<TaskStatus> findAllStatus(){
        return service.findAllTaskStatus();
    }

}
