package com.tsc.iorder.util;

import java.util.UUID;

public class UUID16 {
    public static String getUUID16(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        String s = uuid.substring(0, 16);
        return s;
    }
}
