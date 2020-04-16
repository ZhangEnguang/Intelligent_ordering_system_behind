package com.tsc.iorder.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DoubleUtil {
    public static Double formatDouble(Double d){
        BigDecimal b   =   new   BigDecimal(d);
        double   result   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }
}
