package com.goods.gms.service;

import com.goods.gms.pojo.Type;
import com.goods.gms.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TypeService {

    boolean createType(String typeName,String remarks,long createTimestamp);

    List<Type> showAllTypes();

}
