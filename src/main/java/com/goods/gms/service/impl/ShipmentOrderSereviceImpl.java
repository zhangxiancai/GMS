package com.goods.gms.service.impl;


import com.goods.gms.dao.ShipmentOrderMapper;
import com.goods.gms.global.GlobalConstant;
import com.goods.gms.pojo.ShipmentOrder;
import com.goods.gms.service.ShipmentOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ShipmentOrderSereviceImpl implements ShipmentOrderService {

    @Autowired
    private ShipmentOrderMapper shipmentOrderMapper;


    @Override
    public boolean createShipmentOrder(int goodsId, String goodsUnit, BigDecimal goodsQuantity, BigDecimal goodsUnitPrice, BigDecimal goodsTotalPrice, String remarks) {
        Timestamp createTimestamp=new Timestamp(System.currentTimeMillis());
        return shipmentOrderMapper.insert(goodsId,GlobalConstant.USER_ID,goodsUnit,goodsQuantity,goodsUnitPrice,
                goodsTotalPrice,createTimestamp,remarks);
    }

    @Override
    public List<ShipmentOrder> showShipmentOrders() {
        List<ShipmentOrder> shipmentOrders= shipmentOrderMapper.selectAllshipmentOrder();
        for(ShipmentOrder shipmentOrder:shipmentOrders){
            shipmentOrder.setDate(shipmentOrder.getCreateTimeStamp().toString().substring(0,16));
        }
        return shipmentOrders;
    }
}
