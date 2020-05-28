package com.whw.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskInfo implements Serializable {
    private int info_id;
    //任务名字
    private String info_name;
    //任务描述
    private String info_desc;
    //任务创建时间
    private String info_create_time;
    //任务约定完成时间
    private String info_no_end_time;
    //任务完成时间
    private String info_end_time;
    //发布任务人id
    private int sendStaff_id;
    //接收人id
    private int reciveStaff_id;
    //任务状态id
    private int status_id;
    //任务级别id
    private int level_id;
    //任务级别信息
    private TaskLevel level;
    //任务状态
    private TaskStatus status;
    //任务发布人
    private TaskStaff staff;
    //任务领取人
    private TaskStaff staffList;

    public TaskInfo(String info_name, String info_desc, String info_create_time,
                    int sendStaff_id, int status_id, int level_id
    ) {
        this.info_name = info_name;
        this.info_desc = info_desc;
        this.info_create_time = info_create_time;
        this.status_id = status_id;
        this.level_id = level_id;
        this.sendStaff_id = sendStaff_id;
    }
}
