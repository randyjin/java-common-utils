/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: Person.java
 * Author:   奕超
 * Date:    2017/2/16 下午2:50
 * Description:
 */
package io.github.randyjin.util.collection;

/**
 * Person
 *
 * @author 奕超
 * @date 2017/2/16
 */
public class Person {

    private String name;

    private Integer age;

    private String idCard;

    public Person() {
    }

    public Person(String name, Integer age, String idCard) {
        this.name = name;
        this.age = age;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
