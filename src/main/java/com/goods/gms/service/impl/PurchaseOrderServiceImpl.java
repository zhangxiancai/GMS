package com.goods.gms.service.impl;

import com.goods.gms.dao.GoodsMapper;
import com.goods.gms.dao.PurchaseOrderMapper;
import com.goods.gms.dao.WarehouseMapper;
import com.goods.gms.global.GlobalConstant;
import com.goods.gms.pojo.DaySpending;
import com.goods.gms.pojo.PurchaseOrder;
import com.goods.gms.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;


    @Autowired
    private WarehouseMapper warehouseMapper;


    /**
     *创建进货订单
     *
     */
    @Transactional
    @Override
    public boolean createPurchaseOrder(int goodsId, BigDecimal goodsQuantity,
                                       BigDecimal goodsUnitPrice, BigDecimal goodsTotalPrice, String remarks) {

        modifyWarehouse(goodsId,goodsUnitPrice,goodsQuantity);//更新仓库
        Timestamp createTimestamp=new Timestamp(System.currentTimeMillis());
        return purchaseOrderMapper.insert(goodsId,GlobalConstant.USER_ID,goodsQuantity,goodsUnitPrice,
                goodsTotalPrice,createTimestamp,remarks);
    }


    @Override
    public List<PurchaseOrder> showPurchaserOrders() {
        List<PurchaseOrder> purchaseOrders= purchaseOrderMapper.selectAllPurchaseOrder();
        List<PurchaseOrder> purchaseOrdersTemp= purchaseOrderMapper.selectPurchaseOrderTemp();
        for(int index=0;index<purchaseOrders.size();index++){
            purchaseOrders.get(index).setDate(purchaseOrders.get(index).getCreateTimeStamp().toString().substring(0,16));
            purchaseOrders.get(index).setTemp(purchaseOrdersTemp.get(index).getTemp());
        }
        return purchaseOrders;
    }

    @Override
    public List<DaySpending> showDaySpending() {
        List<DaySpending> daySpendings= purchaseOrderMapper.selectDaySpending();
        for (DaySpending daySpending:daySpendings) {
            daySpending.setStringDate(daySpending.getDate().toString().substring(0,10));
        }

        return daySpendings;
    }

    /**
     * 根据进货订单更新仓库
     *
     */
    private void modifyWarehouse(int goodsId,BigDecimal goodsUnitPrice,BigDecimal goodsQuantity){

        warehouseMapper.updateByPurchaseOrder(goodsId,goodsUnitPrice,goodsQuantity);

    }
}
