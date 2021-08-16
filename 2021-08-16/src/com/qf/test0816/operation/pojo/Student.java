package com.qf.test0816.operation.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/8/16.
 */
public class Student implements Serializable {

    private Integer studentId;  //学号
    private String studentName; //姓名
    private String gender;      //性别
    private Integer age;        //年龄
    private Double score;       //分数

    /**
     * 更改性别
     * 以防学生性别信息录入错误，方便修改
     * @param gender  输入要正确的性别
     * @return  返回修改之后的性别
     */
    public void changeGender(String gender) {
        this.gender = gender;
    }

    /**
     * 减分
     * @param score 输入要减去的分数
     * @return  返回减掉之后的分数
     */
    private Double minusScore(Double score) {
        return this.score -= score;
    }

    /**
     * 加分
     * @param score 输入要提高多少分
     * @return  返回提高后的分数
     */
    private Double plusScore(Double score) {
        return this.score += score;
    }

    public Student() {
    }

    public Student(Integer studentId, String studentName, String gender, Integer age, Double score) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.age = age;
        this.score = score;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) && Objects.equals(studentName, student.studentName) && Objects.equals(gender, student.gender) && Objects.equals(age, student.age) && Objects.equals(score, student.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName, gender, age, score);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
