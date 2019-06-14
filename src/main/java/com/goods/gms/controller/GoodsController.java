package com.goods.gms.controller;

import com.goods.gms.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 创建货物
     *
     */
    @RequestMapping("/createGoods")
    public String createGoods(String goodsName, int typeId, boolean isReturned, String remarks, HttpServletRequest request, Model model) throws IOException {

        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
        boolean temp=goodsService.createGoods(goodsName,typeId,file,isReturned,remarks);
        model.addAttribute("message",temp?"该货物添加成功":"该货物添加失败") ;
        model.addAttribute("backTarget","/addGoods");
        return "feedback";

    }

    @RequestMapping("/addGoods")
    public String addGoods(){
        return "addGoods";
    }

}
