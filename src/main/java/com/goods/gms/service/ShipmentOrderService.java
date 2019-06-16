package com.goods.gms.service;

import com.goods.gms.pojo.PurchaseOrder;
import com.goods.gms.pojo.ShipmentOrder;

import java.math.BigDecimal;
import java.util.List;

public interface ShipmentOrderService {

    boolean createShipmentOrder(int goodsId, String goodsUnit, BigDecimal goodsQuantity,
                                BigDecimal goodsUnitPrice, BigDecimal goodsTotalPrice, String remarks);

    List<ShipmentOrder> showShipmentOrders();
}
