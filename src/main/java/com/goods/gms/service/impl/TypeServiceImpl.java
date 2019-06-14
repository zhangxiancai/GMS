package com.goods.gms.service.impl;

import com.goods.gms.dao.TypeMapper;
import com.goods.gms.pojo.Type;
import com.goods.gms.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public boolean createType(String typeName) {
        return typeMapper.insert(typeName);
    }

    @Override
    public List<Type> showAllTypes() {
        return typeMapper.selectAllTypes();
    }
}
