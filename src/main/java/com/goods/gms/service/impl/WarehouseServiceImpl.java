package com.goods.gms.service.impl;

import com.goods.gms.dao.WarehouseMapper;
import com.goods.gms.pojo.Warehouse;
import com.goods.gms.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;
    
    @Override
    public List<Warehouse> showWarehouse() {
        return warehouseMapper.selectWarehouse();
    }
}
