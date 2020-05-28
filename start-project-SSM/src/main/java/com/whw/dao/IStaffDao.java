package com.whw.dao;


import com.whw.controller.StaffController;
import com.whw.domain.TaskDept;
import com.whw.domain.TaskStaff;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper()
public interface IStaffDao {
    @Select("SELECT STAFF_ID,STAFF_NAME,STAFF_PASSWORD,DEPT_ID,STAFF_WORK_CODE,STAFF_CREATE_TIME,DEPT_ID FROM TASK_STAFF WHERE STAFF_WORK_CODE = #{workCode} AND STAFF_PASSWORD = #{password}")
    @Results(id = "staff",
        value = {
            @Result(property = "staff_id" ,column = "STAFF_ID"),
            @Result(property = "staff_name" ,column = "STAFF_NAME"),
            @Result(property = "staff_password" ,column = "STAFF_PASSWORD"),
            @Result(property = "staff_work_code" ,column = "STAFF_WORK_CODE"),
            @Result(property = "staff_create_time" ,column = "STAFF_CREATE_TIME"),
            @Result(property = "dept_id" ,column = "dept_id"),
            @Result(property = "dept" ,column = "dept_id",one = @One(select = "findDeptById"))
    }
    )
    TaskStaff checkUser(@Param("workCode") String workCode, @Param("password")String password);

    @Select("SELECT DEPT_ID,DEPT_NAME,DEPT_CODE FROM TASK_DEPT WHERE DEPT_ID = #{ID}")
    TaskDept findDeptById(int id);
    @Select("SELECT DEPT_ID,DEPT_NAME,DEPT_CODE FROM TASK_DEPT")
    @Results(id="dept",
            value = {
                    @Result(property = "dept_id",column = "dept_id"),
                    @Result(property = "staffList" ,column = "dept_id",many = @Many(select = "findStaffByDeptId"))
            }
    )
    List<TaskDept> findAllDeptStaff();
    @Select("SELECT STAFF_ID,STAFF_NAME,STAFF_PASSWORD,DEPT_ID,STAFF_WORK_CODE,STAFF_CREATE_TIME,DEPT_ID FROM TASK_STAFF WHERE DEPT_ID = #{dept_id}")
    List<TaskStaff> findStaffByDeptId(int dept_id);
}
