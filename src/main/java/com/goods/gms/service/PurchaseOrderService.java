package com.goods.gms.service;

import com.goods.gms.pojo.PurchaseOrder;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface PurchaseOrderService {

    boolean createPurchaseOrder(int goodsId, BigDecimal goodsQuantity,
                                BigDecimal goodsUnitPrice, BigDecimal goodsTotalPrice, String remarks);

    List<PurchaseOrder> showPurchaserOrders();
}
