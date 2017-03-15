/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: Person.java
 * Author:   奕超
 * Date:    2017/2/16 下午2:50
 * Description:
 */
package io.github.randyjin.util.collection;

import java.util.List;

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

    private Person person;

    private List<Person> personList;

    public Person() {
    }

    public Person(String name, Integer age, String idCard) {
        this.name = name;
        this.age = age;
        this.idCard = idCard;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
