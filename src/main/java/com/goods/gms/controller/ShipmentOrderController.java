package com.goods.gms.controller;

import com.goods.gms.dao.GoodsMapper;
import com.goods.gms.pojo.PurchaseOrder;
import com.goods.gms.pojo.ShipmentOrder;
import com.goods.gms.service.ShipmentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

/**
 * 出货订单管理
 */
@Controller
public class ShipmentOrderController {

    @Autowired
    private ShipmentOrderService shipmentOrderService;

    @Autowired
    private GoodsMapper goodsMapper;


    /**
     *新增出货订单
     */
    @RequestMapping("/createShipmentOrder")
    public String createShipmentOrder(int goodsId, String goodsUnit, BigDecimal goodsQuantity,
                                      BigDecimal goodsUnitPrice, BigDecimal goodsTotalPrice,
                                      String remarks, Model model){
        boolean temp=shipmentOrderService.createShipmentOrder(goodsId,
                goodsUnit,goodsQuantity,goodsUnitPrice,goodsTotalPrice,remarks);
        model.addAttribute("message",temp?"该出货订单添加成功":"该出货订单添加失败") ;
        model.addAttribute("backTarget","/addShipmentOrder");
        return "feedback";
    }


    /**
     * 获取创建出货订单页面
     *
     */
    @RequestMapping("/addShipmentOrder")
    public String addShipmentOrder(Model model){

        model.addAttribute("goods",goodsMapper.selectAllGoods());
        return "addShipmentOrder";
    }

    /**
     * 查看出货订单
     *
     */
    @RequestMapping("/showShipmentOrder")
    public String showShipmentOrder(Model model){
        List<ShipmentOrder> shipmentOrders=shipmentOrderService.showShipmentOrders();
        model.addAttribute("shipmentOrders",shipmentOrders);
        return "showShipmentOrder";


    }
}
