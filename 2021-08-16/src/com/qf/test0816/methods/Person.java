package com.qf.test0816.methods;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class Person implements Serializable {

    private Integer personId;
    private String personName;

    public void run(){
        System.out.println("跑步");
    }

    private void eat(String foodName,int nums) {
        System.out.println("吃了" + nums + "份" + foodName);
    }

    public Person() {
    }

    public Person(Integer personId, String psersonName) {
        this.personId = personId;
        this.personName = psersonName;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(personId, person.personId) && Objects.equals(personName, person.personName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, personName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                '}';
    }
}
