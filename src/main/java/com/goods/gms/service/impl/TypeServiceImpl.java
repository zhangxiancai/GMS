package com.goods.gms.service.impl;

import com.goods.gms.dao.TypeMapper;
import com.goods.gms.pojo.Type;
import com.goods.gms.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public boolean createType(String typeName,String remarks,long createTimestamp) {
        return typeMapper.insert(typeName,remarks,new Timestamp(createTimestamp));
    }

    @Override
    public List<Type> showAllTypes() {
        List<Type> types= typeMapper.selectAllTypes();
        for (Type type:types ) {
            type.setDate(type.getCreateTimestamp().toString().substring(0,16));


        }
        return types;
    }
}
