package com.vaibhav;

public class StudentModel {
    private int studentid;
    private String name;
    private String dept;

    StudentModel(int studentid,String name,String dept){
        this.studentid=studentid;
        this.name=name;
        this.dept=dept;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
