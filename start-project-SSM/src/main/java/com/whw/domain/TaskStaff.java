package com.whw.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class TaskStaff implements Serializable {
    private int staff_id;
    //员工名字
    private String staff_name;
    //员工密码
    private String staff_password;
    //员工工号
    private String staff_work_code;
    //员工入职时间
    private String staff_create_time;
    //部门的id
    private int dept_id;
    //员工部门信息
    private TaskDept dept;

}
