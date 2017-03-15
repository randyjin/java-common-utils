/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: MockObjectUtils.java
 * Author:   奕超
 * Date:    2017/3/14 下午9:33
 * Description:
 */
package io.github.randyjin.util.mock;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * MockObjectUtils
 *
 * @author 奕超
 * @date 2017/3/14
 */
public class MockObjectUtils {

    public static String mockObjectToJson(Class clazz) throws InstantiationException, IllegalAccessException {
        return JSONObject.toJSONString(mockObject(clazz));
    }

    public static Object mockObject(Class clazz) throws IllegalAccessException, InstantiationException {
        Object object = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        if(fields != null && fields.length > 0) {
            for(Field field : fields) {
                Class fieldType = field.getType();
                if(fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
                    field.setAccessible(true);
                    field.set(object,1);
                }
                if(fieldType.equals(double.class) || fieldType.equals(Double.class)) {
                    field.setAccessible(true);
                    field.set(object,1l);
                }
                if(fieldType.equals(BigDecimal.class)) {
                    field.setAccessible(true);
                    field.set(object,new BigDecimal(1.0));
                }
                if(fieldType.equals(float.class) || fieldType.equals(Float.class)) {
                    field.setAccessible(true);
                    field.set(object,1.0f);
                }
                if(fieldType.equals(String.class)) {
                    field.setAccessible(true);
                    field.set(object,"hello");
                }
                if(fieldType.isAssignableFrom(List.class)) {
                    List list = new ArrayList();
                    ParameterizedType stringListType = (ParameterizedType) field.getGenericType();
                    Class<?> listClass = (Class<?>) stringListType.getActualTypeArguments()[0];
                    if(listClass.equals(clazz)) {
                        list.add(listClass.newInstance());
                    } else {
                        list.add(mockObject(listClass));
                    }
                    field.setAccessible(true);
                    field.set(object, list);
                }
                if(fieldType.equals(clazz)) {
                    field.setAccessible(true);
                    field.set(object, fieldType.newInstance());
                }
            }
        }
        return object;
    }
}
