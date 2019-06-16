package com.goods.gms.controller;


import com.goods.gms.dao.GoodsMapper;
import com.goods.gms.pojo.PurchaseOrder;
import com.goods.gms.service.GoodsService;
import com.goods.gms.service.PurchaseOrderService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * 进货订单管理
 *
 */
@Controller
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 新增进货订单
     *
     */
    @RequestMapping("/createPurchaseOrder")
    public String createPurchaseOrder(int goodsId, String goodsUnit, BigDecimal goodsQuantity,
                                      BigDecimal goodsUnitPrice, BigDecimal goodsTotalPrice,
                                      String remarks, Model model)
    {

        boolean temp=purchaseOrderService.createPurchaseOrder(goodsId,
                goodsUnit,goodsQuantity,goodsUnitPrice,goodsTotalPrice,remarks);
        model.addAttribute("message",temp?"该进货订单添加成功":"该进货订单添加失败") ;
        model.addAttribute("backTarget","/addPurchaseOrder");
        return "feedback";

    }


    /**
     * 获取创建进货订单页面
     *
     */
    @RequestMapping("/addPurchaseOrder")
    public String addPurchaseOrder(Model model){

        model.addAttribute("goods",goodsMapper.selectAllGoods());
        return "addPurchaseOrder";
    }

    /**
     * 查看进货订单
     *
     */
    @RequestMapping("/showPurchaseOrder")
    public String showPurchaseOrder(Model model){
        List<PurchaseOrder> purchaseOrders=purchaseOrderService.showPurchaserOrders();
        model.addAttribute("purchaseOrders",purchaseOrders);
        return "showPurchaseOrder";


    }




}
