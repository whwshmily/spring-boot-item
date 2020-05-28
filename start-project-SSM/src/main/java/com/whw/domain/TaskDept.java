package com.whw.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDept implements Serializable{
    private int dept_id;
    //部门名字
    private String dept_name;
    //部门的号码
    private String dept_code;
    //部门下的所有员工
    private List<TaskStaff> staffList;
}
