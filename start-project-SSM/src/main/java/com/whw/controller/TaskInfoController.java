package com.whw.controller;

import com.whw.domain.TaskInfo;
import com.whw.domain.TaskStaff;
import com.whw.service.ITaskInfoService;
import com.whw.util.MailUtil;
import com.whw.util.WorkBookUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/info")
public class TaskInfoController {
    @Autowired
    private ITaskInfoService service;

    @RequestMapping("/add")
    @ResponseBody
    public String addTaskInfo(HttpSession session,
                              @RequestParam("info_name") String info_name,
                              @RequestParam("info_desc") String info_desc,
                              @RequestParam("info_create_time") String info_create_time,
                              @RequestParam("level_id") int level_id,
                              @RequestParam("status_id") int status_id,
                              @RequestParam("staff_id") int staff_id
    ) {
        TaskStaff staff = (TaskStaff) session.getAttribute("user");
        int id = staff.getStaff_id();
        TaskInfo taskInfo = new TaskInfo(info_name, info_desc, info_create_time, id, status_id, level_id);
        if (staff_id == -1) {
            taskInfo.setReciveStaff_id(id);
        } else {
            taskInfo.setReciveStaff_id(staff_id);
            String content = "您有新的任务，详情地址请登录 <a href='http://localhost/login.htm'>任务管理系统</a>";
            try {
                MailUtil.sendMail("whw0505@126.com", content, "您有新的任务，请查收");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int i = service.addTaskInfo(taskInfo);
        if (i == 1) {
            return "success";
        }
        return "error";
    }

    @RequestMapping("/findTaskInfoByYearAndMonth")
    @ResponseBody
    public List<TaskInfo> findTaskInfoByYearAndMonth(HttpSession session,
                                                     @RequestParam("year") String year, @RequestParam("month") String month) {
        TaskStaff staff = (TaskStaff) session.getAttribute("user");
        if (staff != null) {
            List<TaskInfo> list = service.findTaskInfoByYearAndMonth(staff.getStaff_id(), year, month);
            return list;
        }

        return null;
    }

    @RequestMapping("/currentDayTaskInfo")
    @ResponseBody
    public Map<String, Object> currentDayTaskTable(HttpSession session,
                                                   @RequestParam("page") int page,
                                                   @RequestParam("rows") int rows) {
        Map<String, Object> result = new HashMap<>();
        TaskStaff staff = (TaskStaff) session.getAttribute("user");
        if (staff != null) {
            page = (page - 1) * rows;
            List<TaskInfo> list = service.currentDayTaskTable(staff.getStaff_id(), page, rows);
            int total = service.showCurrentDayTaskTotal(staff.getStaff_id());
            result.put("rows", list);
            result.put("total", total);
        }

        return result;
    }

    @RequestMapping("/currentMonthTaskTable")
    @ResponseBody
    public Map<String, Object> currentMonthTaskTable(HttpSession session,
                                                     @RequestParam("page") int page,
                                                     @RequestParam("rows") int rows) {
        Map<String, Object> result = new HashMap<>();
        TaskStaff staff = (TaskStaff) session.getAttribute("user");
        if (staff != null) {
            page = (page - 1) * rows;
            List<TaskInfo> list = service.currentMonthTaskTable(staff.getStaff_id(), page, rows);
            int total = service.showCurrentMonthTaskTotal(staff.getStaff_id());
            result.put("rows", list);
            result.put("total", total);
        }

        return result;
    }

    @RequestMapping("/graph")
    @ResponseBody
    public Map<String, Object> graph(HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        TaskStaff staff = (TaskStaff) session.getAttribute("user");
        List<String> nameList = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        if (staff != null) {
            List<TaskInfo> list = service.findAllTaskInfoByStaffId(staff.getStaff_id());
            handleResult(result, nameList, numberList, list);
        }
        return result;
    }

    private void handleResult(Map<String, Object> result, List<String> nameList, List<Integer> numberList, List<TaskInfo> list) {
        result.put("nameList", nameList);
        result.put("numberList", numberList);
        nameList.add("青铜");
        nameList.add("白银");
        nameList.add("黄金");
        nameList.add("白金");
        nameList.add("钻石");
        nameList.add("王者");
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        for (TaskInfo taskInfo : list) {
            switch (taskInfo.getLevel().getLevel_id()) {
                case 1:
                    one++;
                    break;
                case 2:
                    two++;
                    break;
                case 3:
                    three++;
                    break;
                case 4:
                    four++;
                    break;
                case 5:
                    five++;
                    break;
                case 6:
                    six++;
                    break;
            }
        }
        numberList.add(one);
        numberList.add(two);
        numberList.add(three);
        numberList.add(four);
        numberList.add(five);
        numberList.add(six);

    }

    @RequestMapping("/exportExcel")
    public void exportExcel(HttpSession session, HttpServletResponse response) throws IOException {
        TaskStaff staff = (TaskStaff) session.getAttribute("user");
        if (staff != null) {
            List<TaskInfo> list = service.currentMonthTaskTable(staff.getStaff_id(), 0, 10);
            String sheetName = "个人月任务";
            String[] title = {"任务名字", "任务描述", "任务等级", "任务状态", "任务派发人", "任务接收人", "任务创建时间"};
            String[][] data = new String[list.size()][title.length];
            for (int i = 0; i < data.length; i++) {
                TaskInfo taskInfo = list.get(i);
                data[i][0] = taskInfo.getInfo_name();
                data[i][1] = taskInfo.getInfo_desc();
                data[i][2] = taskInfo.getLevel().getLevel_name();
                data[i][3] = taskInfo.getStatus().getStatus_name();
                data[i][4] = taskInfo.getStaff().getStaff_name();
                data[i][5] = taskInfo.getStaffList().getStaff_name();
                data[i][6] = taskInfo.getInfo_create_time();
            }
            HSSFWorkbook workBook = WorkBookUtil.createWorkBook(sheetName, title, data);
            String fileName = "个人月任务报表.xls";
            setResponseHeader(fileName, response);
            ServletOutputStream out = response.getOutputStream();
            workBook.write(out);
            out.flush();
            out.close();
        }

    }

    private void setResponseHeader(String fileName, HttpServletResponse response) {
        try {
            fileName = new String(fileName.getBytes(), "ISO8859-1");
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.addHeader("Param", "no-cache");
            response.addHeader("Cache-Control", "no=cache");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
