package com.whw.controller;


import com.whw.domain.TaskDept;
import com.whw.domain.TaskStaff;
import com.whw.service.IStaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/staff")
@Controller()
public class StaffController {
    @Autowired
    private IStaffService service;

    @RequestMapping(value = "/login", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TaskStaff checkUser(HttpSession session,
                               @RequestParam("name") String workCode,
                               @RequestParam("password") String password) {
        TaskStaff staff = service.checkUser(workCode, password);
//        if (staff == null) {
//            staff = new TaskStaff(1, "小球", "123", "456", new Date().toString(),
//                    new TaskDept(1, "10", "111"));
//        }
        if (staff != null) {
            session.setAttribute("user", staff);
        }
        return staff;
    }

    @RequestMapping("/findAllDeptStaff")
    @ResponseBody
    public List<Map<String, Object>> findAllDeptStaff() {
        List<Map<String, Object>> result = new ArrayList<>();
        List<TaskDept> list = service.findAllDeptStaff();
        /**
         * $('#cc').combotree('loadData', [{ id: 1, text: 'Languages',
         children: [{id: 11,text: 'Java'
         },{id: 12,text: 'C++'}]
         }]);
         */
        if (list != null) {
            for (TaskDept dept : list) {
                Map<String,Object> map = new HashMap<>();
                map.put("id",dept.getDept_id());
                map.put("text",dept.getDept_name());
                List<Map<String, Object>> childList = new ArrayList<>();
                map.put("children",childList);
                for (TaskStaff staff : dept.getStaffList()){
                    Map<String,Object> childrenMap = new HashMap<>();
                    childrenMap.put("id",staff.getStaff_id());
                    childrenMap.put("text",staff.getStaff_name());
                    childList.add(childrenMap);
                }
                result.add(map);
            }
        }
        return result;
    }


}
