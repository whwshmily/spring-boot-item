package com.whw.service;

import com.whw.domain.TaskDept;
import com.whw.domain.TaskStaff;

import java.util.List;


public interface IStaffService {
    /**
     * 根据员工的 工号和密码查询员工
     * @param workCode  工号
     * @param password  密码
     * @return  成功返回Task_Staff  失败 null；
     */
    TaskStaff checkUser(String workCode, String password);

    /**
     *
     * @return 查询所有部门 和部门下的所有员工
     */
    List<TaskDept> findAllDeptStaff();

}
