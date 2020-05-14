package com.whw.controller;

import com.whw.bean.ConfirmStatusBean;
import com.whw.bean.DataBean;
import com.whw.bean.GraphBean;
import com.whw.dao.DataMapper;
import com.whw.service.dataServcie.BaseDataService;
import com.whw.until.GraphDataHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    private BaseDataService service;
    @Autowired
    private DataMapper mapper;
    @GetMapping
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
        ConfirmStatusBean bean = GraphDataHandle.handleNowConfirmStatus();
        double gat = bean.getGat();
        double overseas   = bean.getOverseas();
        double province = bean.getProvince();
        model.addAttribute("gat",gat);
        model.addAttribute("overseas",overseas);
        model.addAttribute("province",province);
        model.addAttribute("total",gat+overseas+province);
        return "pie";
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
