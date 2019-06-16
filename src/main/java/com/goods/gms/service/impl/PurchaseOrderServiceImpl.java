package com.goods.gms.service.impl;

import com.goods.gms.dao.GoodsMapper;
import com.goods.gms.dao.PurchaseOrderMapper;
import com.goods.gms.global.GlobalConstant;
import com.goods.gms.pojo.PurchaseOrder;
import com.goods.gms.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private GoodsMapper goodsMapper;




    @Override
    public boolean createPurchaseOrder(int goodsId, String goodsUnit, BigDecimal goodsQuantity,
                                       BigDecimal goodsUnitPrice, BigDecimal goodsTotalPrice, String remarks) {

        Timestamp createTimestamp=new Timestamp(System.currentTimeMillis());
        return purchaseOrderMapper.insert(goodsId,GlobalConstant.USER_ID,goodsUnit,goodsQuantity,goodsUnitPrice,
                goodsTotalPrice,createTimestamp,remarks);
    }

    @Override
    public List<PurchaseOrder> showPurchaserOrders() {
        List<PurchaseOrder> purchaseOrders= purchaseOrderMapper.selectAllpurchaseOrder();
        for(PurchaseOrder purchaseOrder:purchaseOrders){
            purchaseOrder.setDate(purchaseOrder.getCreateTimeStamp().toString().substring(0,16));
        }
        return purchaseOrders;
    }
}
