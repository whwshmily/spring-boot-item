package com.whw.service;

import com.whw.dao.TaskInfoDao;
import com.whw.domain.TaskInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("taskInfoServiceImpl")
public class TaskInfoServiceImpl implements ITaskInfoService {
    @Autowired
    private TaskInfoDao dao;

    /**
     * 新增任务信息
     *
     * @param taskInfo 参数信息
     * @return 成功返回1
     */
    @Override
    public int addTaskInfo(TaskInfo taskInfo) {
        return dao.addTaskInfo(taskInfo);
    }

    /**
     * 根据当前年月查询用户任务信息
     *
     * @param year     年
     * @param month    月
     * @param staff_id 用户id
     * @return 信息集合
     */
    @Override
    public List<TaskInfo> findTaskInfoByYearAndMonth(int staff_id, String year, String month) {
        try {
            return dao.findTaskInfoByYearAndMonth(staff_id, year, month);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据员工id 查询当天任务
     *
     * @param staff_id 员工id
     * @param page     查询的页数
     * @param rows     查询的个数
     * @return 返回查询的任务信息
     */
    @Override
    public List<TaskInfo> currentDayTaskTable(int staff_id, int page, int rows) {
        try {
            return dao.currentDayTaskTable(staff_id, page, rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据用户id查询当天任务总数
     *
     * @param staff_id 用户id
     * @return 任务数量
     */
    @Override
    public int showCurrentDayTaskTotal(int staff_id) {

        return dao.showCurrentDayTaskTotal(staff_id);
    }

    /**
     * 根据员工id 查询当月任务
     *
     * @param staff_id 员工id
     * @param page     查询的页数
     * @param rows     查询的个数
     * @return 返回查询的任务信息
     */
    @Override
    public List<TaskInfo> currentMonthTaskTable(int staff_id, int page, int rows) {
        try {
            return dao.currentMonthTaskTable(staff_id,page,rows);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据用户id查询当月任务总数
     *
     * @param staff_id 用户id
     * @return 任务数量
     */
    @Override
    public int showCurrentMonthTaskTotal(int staff_id) {
        return dao.showCurrentMonthTaskTotal(staff_id);
    }

    /**
     * 查出个人所有的的任务信息
     *
     * @param staff_id
     * @return 所有的任务信息
     */
    @Override
    public List<TaskInfo> findAllTaskInfoByStaffId(int staff_id) {
        try {
            return dao.findAllTaskInfoByStaffId(staff_id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
