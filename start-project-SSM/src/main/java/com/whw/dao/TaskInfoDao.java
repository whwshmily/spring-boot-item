package com.whw.dao;

import com.whw.domain.TaskInfo;
import com.whw.domain.TaskLevel;
import com.whw.domain.TaskStaff;
import com.whw.domain.TaskStatus;
import lombok.Builder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TaskInfoDao {
    @Insert("INSERT INTO TASK_INFO (SENDSTAFF_ID,RECIVESTAFF_ID,STATUS_ID,LEVEL_ID,INFO_NAME,INFO_DESC,INFO_CREATE_TIME) VALUES(#{sendStaff_id},#{reciveStaff_id},#{status_id},#{level_id},#{info_name},#{info_desc},#{info_create_time})")
    int addTaskInfo(TaskInfo taskInfo);

    @Select("SELECT INFO_ID,SENDSTAFF_ID,RECIVESTAFF_ID,STATUS_ID,LEVEL_ID,INFO_NAME,INFO_DESC,INFO_CREATE_TIME,INFO_NO_END_TIME,INFO_END_TIME FROM TASK_INFO  WHERE SENDSTAFF_ID = #{sendStaff_id} AND MONTH(INFO_CREATE_TIME) = #{month} AND YEAR(INFO_CREATE_TIME) = #{year}")
    @Results(id = "taskInfo",
            value = {
                    @Result(property = "info_id", column = "info_id"),
                    @Result(property = "info_name", column = "info_name"),
                    @Result(property = "info_desc", column = "info_desc"),
                    @Result(property = "info_create_time", column = "info_create_time"),
                    @Result(property = "info_no_end_time", column = "info_no_end_time"),
                    @Result(property = "info_end_time", column = "info_end_time"),
                    @Result(property = "level", column = "level_id", one = @One(select = "findTaskLevelById")),
                    @Result(property = "status", column = "status_id", one = @One(select = "findTaskStatusById")),
                    @Result(property = "staff", column = "sendStaff_id", one = @One(select = "findTaskStaffBySendStaffId")),
                    @Result(property = "staffList", column = "reciveStaff_id", one = @One(select = "findTaskStaffByReciveStaffId"))
            }
    )
    List<TaskInfo> findTaskInfoByYearAndMonth(@Param("sendStaff_id") int sendStaff_id, @Param("year") String year, @Param("month") String month);

    @Select("SELECT LEVEL_ID,LEVEL_NAME FROM TASK_LEVEL WHERE LEVEL_ID = #{level_id}")
    TaskLevel findTaskLevelById(int level_id);

    @Select("SELECT STATUS_ID,STATUS_NAME FROM TASK_STATUS WHERE STATUS_ID = #{status_id}")
    TaskStatus findTaskStatusById(int status_id);

    @Select("SELECT STAFF_ID,STAFF_NAME,STAFF_WORK_CODE,DEPT_ID,STAFF_PASSWORD,STAFF_CREATE_TIME FROM TASK_STAFF WHERE STAFF_ID = #{sendStaff_id}")
    @ResultMap("com.whw.dao.IStaffDao.staff")
    TaskStaff findTaskStaffBySendStaffId(int sendStaff_id);

    @Select("SELECT STAFF_ID,STAFF_NAME,STAFF_WORK_CODE,DEPT_ID,STAFF_PASSWORD,STAFF_CREATE_TIME FROM TASK_STAFF WHERE STAFF_ID = #{reciveStaff_id}")
    @ResultMap("com.whw.dao.IStaffDao.staff")
    TaskStaff findTaskStaffByReciveStaffId(int reciveStaff_id);

    @Select("SELECT INFO_ID,SENDSTAFF_ID,RECIVESTAFF_ID,STATUS_ID,LEVEL_ID,INFO_NAME,INFO_DESC,INFO_CREATE_TIME,INFO_NO_END_TIME,INFO_END_TIME FROM TASK_INFO  WHERE SENDSTAFF_ID = #{sendStaff_id} AND STR_TO_DATE(INFO_CREATE_TIME,'%Y-%m-%d') = DATE_FORMAT(NOW(),'%Y-%m-%d')  LIMIT #{page} , #{rows} ")
    @ResultMap("taskInfo")
    List<TaskInfo> currentDayTaskTable(@Param("sendStaff_id") int staff_id, @Param("page") int page, @Param("rows") int rows);

    @Select("SELECT COUNT(*) FROM TASK_INFO WHERE SENDSTAFF_ID = #{sendStaff_id} AND STR_TO_DATE(INFO_CREATE_TIME,'%Y-%m-%d') = DATE_FORMAT(NOW(),'%Y-%m-%d')")
    int showCurrentDayTaskTotal(int staff_id);

    @Select("SELECT INFO_ID,SENDSTAFF_ID,RECIVESTAFF_ID,STATUS_ID,LEVEL_ID,INFO_NAME,INFO_DESC,INFO_CREATE_TIME,INFO_NO_END_TIME,INFO_END_TIME FROM TASK_INFO  WHERE SENDSTAFF_ID = #{sendStaff_id} AND MONTH(INFO_CREATE_TIME) = MONTH(NOW()) AND YEAR(INFO_CREATE_TIME) = YEAR(NOW())  LIMIT #{page} , #{rows} ")
    @ResultMap("taskInfo")
    List<TaskInfo> currentMonthTaskTable(@Param("sendStaff_id") int staff_id, @Param("page") int page, @Param("rows") int rows);

    @Select("SELECT COUNT(*) FROM TASK_INFO WHERE SENDSTAFF_ID = #{sendStaff_id} AND MONTH(INFO_CREATE_TIME) = MONTH(NOW()) AND YEAR(INFO_CREATE_TIME) = YEAR(NOW())")
    int showCurrentMonthTaskTotal(int staff_id);
    @Select("SELECT INFO_ID,SENDSTAFF_ID,RECIVESTAFF_ID,STATUS_ID,LEVEL_ID,INFO_NAME,INFO_DESC,INFO_CREATE_TIME,INFO_NO_END_TIME,INFO_END_TIME FROM TASK_INFO  WHERE SENDSTAFF_ID = #{sendStaff_id}")
    @ResultMap("taskInfo")
    List<TaskInfo> findAllTaskInfoByStaffId(int staff_id);
}
