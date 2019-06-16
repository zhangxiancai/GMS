package com.goods.gms.controller;

import com.goods.gms.pojo.Goods;
import com.goods.gms.service.GoodsService;
import com.goods.gms.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * 货物管理
 */
@Controller
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TypeService typeService;


    /**
     * 创建货物
     *
     */
    @RequestMapping("/createGoods")
    public String createGoods(String goodsName, int typeId,  String remarks, HttpServletRequest request, Model model) throws IOException {

        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("file");
        boolean temp=goodsService.createGoods(goodsName,typeId,file,remarks);
        model.addAttribute("message",temp?"该货物添加成功":"该货物添加失败") ;
        model.addAttribute("backTarget","/addGoods");
        return "feedback";

    }

    /**
     * 获取创建货物页面
     *
     */
    @RequestMapping("/addGoods")
    public String addGoods(Model model){

        model.addAttribute("types",typeService.showAllTypes());
        return "addGoods";
    }

//    @RequestMapping("/showGoods")
//    public String showGoods(Model model,Integer pageNumber,Integer pageSize,Integer typeId,String typeName){
//
//        List<Goods> goods=goodsService.showGoods(pageNumber,pageSize,typeId,typeName);
//        model.addAttribute("goods",goods);
//        return "showGoods";
//    }

    @RequestMapping("/showGoods")
    public String showGoods(Model model){

        List<Goods> goods=goodsService.showAllGoods();
        model.addAttribute("goods",goods);
        return "showGoods";
    }
}
