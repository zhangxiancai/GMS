package com.goods.gms.controller;

import com.goods.gms.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;


    /**
     * 查看仓库
     *
     */
    @RequestMapping("/showWarehouse")
    public String showWarehouse(Model model){
        model.addAttribute("warehouses",warehouseService.showWarehouse());
        return "showWarehouse";


    }

}
