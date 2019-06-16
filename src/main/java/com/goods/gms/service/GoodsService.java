package com.goods.gms.service;

import com.goods.gms.pojo.Goods;
import com.goods.gms.pojo.Type;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface GoodsService {

    boolean createGoods(String goodsName, int typeId, MultipartFile file, String remarks) throws IOException;

    List<Goods> showGoods(Integer pageNumber,Integer pageSize,Integer typeId,String typeName);
    List<Goods> showAllGoods();

}
