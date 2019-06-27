package com.goods.gms.service.impl;

import com.goods.gms.dao.DayEarningMapper;
import com.goods.gms.pojo.DayEarning;
import com.goods.gms.service.DayEarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class DayEarningServiceImpl implements DayEarningService {


    @Autowired
    private DayEarningMapper dayEarningMapper;


    @Override
    public boolean createDayEarning(BigDecimal dayEarning, String remarks) {

        Timestamp createTimestamp=new Timestamp(System.currentTimeMillis());
        return dayEarningMapper.insert(dayEarning,remarks,createTimestamp);
    }

    @Override
    public List<DayEarning> showDayEarning() {
        List<DayEarning> dayEarnings=dayEarningMapper.selectDayEarning();
        for (DayEarning dayEarning:dayEarnings){

            dayEarning.setDate(dayEarning.getCreateTimestamp().toString().substring(0,10));
        }
        return  dayEarnings;
    }
}
