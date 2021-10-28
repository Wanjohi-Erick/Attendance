package com.example.basic.models;

public class StudentsModel {
    String student_name, reg_no; int attendance;
    public StudentsModel(String student_name, String reg_no, int attendance) {
        this.student_name = student_name;
        this.reg_no = reg_no;
        this.attendance = attendance;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
}
