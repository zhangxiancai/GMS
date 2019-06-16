package com.goods.gms.controller;

import com.goods.gms.pojo.Type;
import com.goods.gms.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**
     * 新增类别
     */
    @RequestMapping("/createType")
    public String createType(String typeName,  String remarks,Model model) throws UnsupportedEncodingException {

        boolean temp=typeService.createType(typeName,remarks,System.currentTimeMillis());

        model.addAttribute("message",temp?"类别创建成功":"类别创建失败") ;
        model.addAttribute("backTarget","/addType");
        return "feedback";
    }


    @RequestMapping("/addType")
    public String addType(){
        return "addType";
    }

    /**
     * 查看类别
     * @param model
     * @return
     */
    @RequestMapping("/showTypes")
    public String showTypes(Model model){

        List<Type> types =typeService.showAllTypes();


        model.addAttribute("types",types);
        return "showTypes";
    }
}
