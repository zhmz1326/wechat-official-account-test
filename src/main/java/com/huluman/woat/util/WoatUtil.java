package com.huluman.woat.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Zhengmingzhi on 2016/4/14.
 */
public class WoatUtil {
    private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    public static String currentDateTime() {
        return formatter.format(new Date());
    }
}
