package com.goods.gms.service.impl;

import com.goods.gms.dao.GoodsMapper;
import com.goods.gms.dao.TypeMapper;
import com.goods.gms.dao.WarehouseMapper;
import com.goods.gms.global.GlobalConstant;
import com.goods.gms.pojo.Goods;
import com.goods.gms.service.GoodsService;
import com.goods.gms.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Transactional
    @Override
    public boolean createGoods(String goodsName, int typeId, MultipartFile file, String remarks,String goodsUnit) throws IOException {



        long timestamp=System.currentTimeMillis();
        String imageAddress = GlobalConstant.IMAGE_LOCATION+timestamp + "-"+file.getOriginalFilename();
        FileUtil.writeToLocal(file, imageAddress);
        boolean goodsTemp = goodsMapper.insert(goodsName,typeId,imageAddress,remarks,new Timestamp(timestamp),goodsUnit);

        boolean warehouseTemp=warehouseMapper.insert(goodsMapper.returnLastId(),new BigDecimal(0),
                new BigDecimal(0),new BigDecimal(0)," ");//更新仓库

        return goodsTemp&&warehouseTemp;
    }

    /**
     * 分页条件查询货物
     * @return
     */
    @Override
    public List<Goods> showGoods(Integer pageNumber,Integer pageSize,Integer typeId,String typeName) {
        if (pageNumber==null&&pageSize==null){
            return goodsMapper.selectGoods(0,10);
        }
        if (typeId!=null&&typeName==null) {
            return goodsMapper.selectGoodsByType(typeId, pageNumber, pageSize);
        }
        if (typeName!=null&&typeId==null) {
            return goodsMapper.selectGoodsByName(typeName, pageNumber, pageSize);
        }

        return null;

    }

    @Override
    public List<Goods> showAllGoods() {
        List<Goods> goods= goodsMapper.selectAllGoods();
        if (goods==null)  return null;

        for (Goods good: goods) {
            good.setTypeName(typeMapper.selectNameById(good.getTypeId()));
            good.setDate(good.getCreateTimestamp().toString().substring(0,16));
        }
        return goods;
    }
}
