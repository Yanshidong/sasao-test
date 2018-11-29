package com.wd7.sso;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.text.SimpleDateFormat;

@SpringBootTest
public class TimeDateTest {

    @Test
    public void getCurrent(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }
}
