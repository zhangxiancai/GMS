package com.goods.gms.controller;


import com.goods.gms.pojo.DayEarning;
import com.goods.gms.service.DayEarningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;


/**
 * 日收入管理
 */
@Controller
public class DayEarningController {

    @Autowired
    private DayEarningService dayEarningService;


    /**
     * 新增日收入
     *
     */
    @RequestMapping("/createDayEarning")
    public String createDayEarning( BigDecimal dayEarning, String remarks, Model model) {

        boolean temp=dayEarningService.createDayEarning(dayEarning,remarks);
        model.addAttribute("message",temp?"该笔日收入添加成功":"该笔日收入添加失败") ;
        model.addAttribute("backTarget","/addDayEarning");
        return "feedback";
    }

    /**
     * 获取创建日收入页面
     *
     */
    @RequestMapping("/addDayEarning")
    public String addDayEarning(){
        return "addDayEarning";
    }

    /**
     * 查看日收入
     *
     */
    @RequestMapping("/showDayEarning")
    public String showDayEarning(Model model){
        List<DayEarning> dayEarnings=dayEarningService.showDayEarning();
        model.addAttribute("dayEarnings",dayEarnings);
        return "showDayEarning";

    }
}
