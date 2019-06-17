package com.goods.gms.service.impl;


import com.goods.gms.dao.ShipmentOrderMapper;
import com.goods.gms.dao.WarehouseMapper;
import com.goods.gms.global.GlobalConstant;
import com.goods.gms.pojo.ShipmentOrder;
import com.goods.gms.service.ShipmentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ShipmentOrderServiceImpl implements ShipmentOrderService {

    @Autowired
    private ShipmentOrderMapper shipmentOrderMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;


    @Transactional
    @Override
    public boolean createShipmentOrder(int goodsId, BigDecimal goodsQuantity,
                                       BigDecimal goodsUnitPrice, BigDecimal goodsTotalPrice, String remarks) {

        modifyWarehouse(goodsId,goodsUnitPrice,goodsQuantity);//更新仓库
        Timestamp createTimestamp=new Timestamp(System.currentTimeMillis());
        return shipmentOrderMapper.insert(goodsId,GlobalConstant.USER_ID,goodsQuantity,
                goodsUnitPrice, goodsTotalPrice,createTimestamp,remarks);
    }


    @Override
    public List<ShipmentOrder> showShipmentOrders() {
        List<ShipmentOrder> shipmentOrders= shipmentOrderMapper.selectAllShipmentOrder();
        for(ShipmentOrder shipmentOrder:shipmentOrders){
            shipmentOrder.setDate(shipmentOrder.getCreateTimeStamp().toString().substring(0,16));
        }
        return shipmentOrders;
    }


    /**
     * 根据出货订单更新仓库
     *
     */
    private void modifyWarehouse(int goodsId,BigDecimal goodsUnitPrice,BigDecimal goodsQuantity){

        warehouseMapper.updateByShipmentOrder(goodsId,goodsUnitPrice,goodsQuantity);

    }
}
