package com.goods.gms.service;

import com.goods.gms.pojo.DayEarning;

import java.math.BigDecimal;
import java.util.List;

public interface DayEarningService {

    boolean createDayEarning(BigDecimal dayEarning, String remarks);

    List<DayEarning> showDayEarning();
}
