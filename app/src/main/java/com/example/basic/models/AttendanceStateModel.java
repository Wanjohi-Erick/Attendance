package com.example.basic.models;

public class AttendanceStateModel {
    String attendanceState;
    public AttendanceStateModel(String attendanceState){
        this.attendanceState = attendanceState;
    }

    public String getAttendanceState() {
        return attendanceState;
    }

    public void setAttendanceState(String attendanceState) {
        this.attendanceState = attendanceState;
    }
}
