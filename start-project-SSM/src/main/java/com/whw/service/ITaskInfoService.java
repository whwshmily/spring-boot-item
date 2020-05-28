package com.whw.service;


import com.whw.domain.TaskInfo;

import java.util.List;

public interface ITaskInfoService {
    /**
     * 新增任务信息
     *
     * @param taskInfo 参数信息
     * @return 成功返回1
     */
    int addTaskInfo(TaskInfo taskInfo);

    /**
     * 根据当前年月查询用户任务信息
     *
     * @param year 年
     * @param month 月
     * @param staff_id 用户id
     * @return 信息集合
     */
    List<TaskInfo> findTaskInfoByYearAndMonth(int staff_id, String year, String month);

    /**
     * 根据员工id 查询当天任务
     * @param staff_id  员工id
     * @param page  查询的页数
     * @param rows   查询的个数
     * @return  返回查询的任务信息
     */
    List<TaskInfo> currentDayTaskTable(int staff_id, int page, int rows);

    /**
     * 根据用户id查询当天任务总数
     * @param staff_id  用户id
     * @return  任务数量
     */
    int showCurrentDayTaskTotal(int staff_id);

    /**
     * 根据员工id 查询当月任务
     * @param staff_id  员工id
     * @param page  查询的页数
     * @param rows   查询的个数
     * @return  返回查询的任务信息
     */
    List<TaskInfo> currentMonthTaskTable(int staff_id, int page, int rows);

    /**
     * 根据用户id查询当月任务总数
     * @param staff_id  用户id
     * @return  任务数量
     */
    int showCurrentMonthTaskTotal(int staff_id);

    /**
     * 查出个人所有的的任务信息
     * @return  所有的任务信息
     */
    List<TaskInfo> findAllTaskInfoByStaffId(int  staff_id);
}
