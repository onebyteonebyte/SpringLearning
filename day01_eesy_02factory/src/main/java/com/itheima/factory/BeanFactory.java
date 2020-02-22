package com.itheima.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 * 注：
 *      Bean：在计算机术语中指可重用组件
 *      JavaBean >> 实体类
 *      JavaBean :用java语言编写的可重用组件
 *
 * 1.需要一个配置文件来配置我们的service和dao
 *    配置的内容：唯一标识 = 全限定类名
 *
 * 2.通过读取配置文件中的配置内容，反射进行创建对象（暂时用 properties）
 */
public class BeanFactory {
    private static Properties props;

    private static Map<String,Object> beans;

    static{
        try {
            props = new Properties();
            //获取流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            beans = new HashMap<String,Object>();
            Enumeration keys = props.keys();
            while(keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanPath = props.getProperty(key);
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key,value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化失败");
        }
    }

    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

//    public static Object getBean(String beanName){
//        Object bean = null;
//        try {
//            String beanPath = props.getProperty(beanName);
//            bean = Class.forName(beanPath).newInstance();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
