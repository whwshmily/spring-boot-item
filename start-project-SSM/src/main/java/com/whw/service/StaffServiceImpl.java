package com.whw.service;

import com.whw.dao.IStaffDao;
import com.whw.domain.TaskDept;
import com.whw.domain.TaskStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("staffService")
public class StaffServiceImpl implements IStaffService {
    @Autowired
    private IStaffDao dao;

    /**
     * 根据员工的 工号和密码查询员工
     *
     * @param workCode 工号
     * @param password 密码
     * @return 成功返回Task_Staff  失败 null；
     */
    @Override
    public TaskStaff checkUser(String workCode, String password) {
        try {
            return dao.checkUser(workCode, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return 查询所有部门 和部门下的所有员工
     */
    @Override
    public List<TaskDept> findAllDeptStaff() {
        try {
            return dao.findAllDeptStaff();
        }catch (Exception e ){
            e.printStackTrace();
        }
        return null;
    }
}
