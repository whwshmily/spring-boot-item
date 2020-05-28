

import com.whw.domain.TaskDept;
import com.whw.domain.TaskStaff;
import com.whw.service.IStaffService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        IStaffService service = (IStaffService) context.getBean("staffService");
//        System.out.println(service.checkUser("1010","0505"));
//        System.out.println(service.findTaskInfoByYearAndMonth(1,"1","1"));
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
        System.out.println(result.size());
        for (int i = 0; i <result.size() ; i++) {
            Map map = result.get(i);
            List<Map<String,Object>> list1 = (List<Map<String, Object>>) map.get("children");
           Map map1 =  list1.get(0);

//            System.out.println(map1.get("text"));
        }
//        System.out.println(result.size());
//        System.out.println(result);
//        Gson gson = new Gson();
//        String s = gson.toJson(result);
//        System.out.println(s);
    }

}
