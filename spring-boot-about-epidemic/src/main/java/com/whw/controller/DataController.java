package com.whw.controller;

import com.whw.bean.ConfirmStatusBean;
import com.whw.bean.DataBean;
import com.whw.bean.GraphBean;
import com.whw.bean.MapBean;
import com.whw.dao.DataMapper;
import com.whw.service.dataServcie.BaseDataService;
import com.whw.until.DataHandle;
import com.whw.until.GraphDataHandle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/data")
@Api(tags="地图展示",description = "查看")
public class DataController {
    @Autowired
    private BaseDataService service;
    @Autowired
    private DataMapper mapper;
    @GetMapping
    @ApiIgnore
    public String getData(Model model) {
        model.addAttribute("list", service.list());
        return "index";
    }

    //    @GetMapping("/{id}")
//    public String getDataById(Model model, @PathVariable int id){
//        model.addAttribute("list",service.findById(id));
//        return "index";
//    }
    @GetMapping("/graph")
    @ApiOperation("查看地图")
    @ApiImplicitParam(name="",value = "")
    public String graph(Model model) {
        handleNowConfirm(model);
        handleInsertSuspectAndConfirm(model);
        List<DataBean> dataBeanList = mapper.findBytipDesc();
        List nameList = new ArrayList();
        List countList = new ArrayList();
        for (int i = 0; i <dataBeanList.size() ; i++) {
            DataBean bean = dataBeanList.get(i);
            nameList.add(bean.getName());
            countList.add(bean.getTip());
        }
        model.addAttribute("nameList",nameList);
        model.addAttribute("countList",countList);
        return "graph";
    }
    @GetMapping("/pie")
    public String pie(Model model){
        List<ConfirmStatusBean> list = GraphDataHandle.handleNowConfirmStatus();
        Collections.sort(list);
        model.addAttribute("list",list);
        return "pie";
    }
    @GetMapping("/map")
    public String chinaMap(Model model){
        List<MapBean> list = new ArrayList<>();
        DataHandle.getHandle(list);
        model.addAttribute("list",list);
        System.out.println(list);
        return "map";
    }

    private void handleNowConfirm(Model model) {
        List dateList = new ArrayList();
        List nowConfirmList = new ArrayList();
        List totalConfirm = new ArrayList();
        List totalDead = new ArrayList();
        List totalHeal = new ArrayList();
        List deadRateList = new ArrayList();
        List healRateList = new ArrayList();
        List importedCaseList = new ArrayList();
        List<GraphBean> beanList = GraphDataHandle.handleOtherAboutGraph();
        for (int i = 0; i < beanList.size(); i++) {
            GraphBean bean = beanList.get(i);
            dateList.add(bean.getDate());
            nowConfirmList.add(bean.getNowConfirm());
            totalConfirm.add(bean.getTotalConfirm());
            totalDead.add(bean.getTotalDead());
            totalHeal.add(bean.getTotalHeal());
            healRateList.add(bean.getHealRate());
            deadRateList.add(bean.getDeadRate());
            importedCaseList.add(bean.getImportCase());
        }
        model.addAttribute("dateList", dateList);
        model.addAttribute("nowConfirmList", nowConfirmList);
        model.addAttribute("totalConfirm", totalConfirm);
        model.addAttribute("totalDead", totalDead);
        model.addAttribute("totalHeal", totalHeal);
        model.addAttribute("deadRateList", deadRateList);
        model.addAttribute("healRateList", healRateList);
        model.addAttribute("importedCaseList", importedCaseList);
    }

    private void handleInsertSuspectAndConfirm(Model model) {
        List suspectList = new ArrayList();
        List confirmList = new ArrayList();
        List importedCaseRateList = new ArrayList();
        List<GraphBean> list = GraphDataHandle.handleInsertSuspectAndConfirm();
        for (int i = 0; i < list.size(); i++) {
            GraphBean bean = list.get(i);
            suspectList.add(bean.getInsertSuspect());
            confirmList.add(bean.getInsertConfirm());
            importedCaseRateList.add(bean.getImportCaseRate());
        }
        model.addAttribute("insertSuspectList", suspectList);
        model.addAttribute("insertConfirmList", confirmList);
        model.addAttribute("importedCaseRateList", importedCaseRateList);
    }
}
