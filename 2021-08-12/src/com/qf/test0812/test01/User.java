package com.qf.test0812.test01;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String name;
    private String pwd;
    private Integer age;
    private Double score;
    private static final Long serialVersionUID = -10L;

    public User() {
    }

    public User(String id, String name, String pwd, Integer age, Double score) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.age = age;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
