package com.own;

import com.mysql.cj.jdbc.Driver;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 类功能说明:
 * 类修改者	创建日期2020/7/26
 * 修改说明
 *
 * @author wzy
 * @version V1.0
 **/
public class ClassLoadTest {

    public static void main(String[] args) {
        ServiceLoader<Driver> serviceLoader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = serviceLoader.iterator();
        while(iterator.hasNext()){
            System.out.println( iterator.next());
        }
        System.out.println(DriverManager.class.getClassLoader());
        System.out.println(System.getProperty("jdbc.drivers"));
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
