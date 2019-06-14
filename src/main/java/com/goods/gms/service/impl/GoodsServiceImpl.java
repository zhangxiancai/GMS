package com.goods.gms.service.impl;

import com.goods.gms.dao.GoodsMapper;
import com.goods.gms.dao.TypeMapper;
import com.goods.gms.global.GlobalConstant;
import com.goods.gms.pojo.Goods;
import com.goods.gms.pojo.Type;
import com.goods.gms.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import util.FileUtil;

import java.beans.Transient;
import java.io.IOException;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {


    @Autowired
    private GoodsMapper goodsMapper;


    @Transactional
    @Override
    public boolean createGoods(String goodsName, int typeId, MultipartFile file,
                               boolean isReturned, String remarks) throws IOException {

        long timestamp=System.currentTimeMillis();
        String imageAddress = GlobalConstant.IMAGE_LOCATION+timestamp + "-"+file.getOriginalFilename();
        FileUtil.writeToLocal(file, imageAddress);

        return goodsMapper.insert(goodsName,typeId,imageAddress,isReturned,remarks,timestamp);
    }

    @Override
    public List<Goods> showAllGoods() {
        return goodsMapper.selectAllGoods();
    }
}
