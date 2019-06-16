package com.goods.gms.service.impl;

import com.goods.gms.dao.GoodsMapper;
import com.goods.gms.dao.TypeMapper;
import com.goods.gms.global.GlobalConstant;
import com.goods.gms.pojo.Goods;
import com.goods.gms.service.GoodsService;
import com.goods.gms.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private TypeMapper typeMapper;


    @Transactional
    @Override
    public boolean createGoods(String goodsName, int typeId, MultipartFile file, String remarks) throws IOException {

        long timestamp=System.currentTimeMillis();
        String imageAddress = GlobalConstant.IMAGE_LOCATION+timestamp + "-"+file.getOriginalFilename();
        FileUtil.writeToLocal(file, imageAddress);

        return goodsMapper.insert(goodsName,typeId,imageAddress,remarks,new Timestamp(timestamp));
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
