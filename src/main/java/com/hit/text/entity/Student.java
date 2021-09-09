package com.hit.text.entity;

/**
 * @author yang
 * @create 2021-09-08 17:38
 */
public class Student {
    private int id;
    private String studentName;
    private String studentId;
    private int chinese;
    private int math;
    private int english;
    private int status;

    public Student() {
    }

    public Student(String studentName, String studentId, int chinese, int math, int english, int status) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentId='" + studentId + '\'' +
                ", chinese=" + chinese +
                ", math=" + math +
                ", english=" + english +
                '}';
    }
}
