package com.example.basic.models;

public class UnitsModel {
    String unit_name, academic_year, semester;
    int number_of_classes;
    public UnitsModel(String unit_name, String academic_year, String semester, int number_of_classes) {
        this.unit_name = unit_name;
        this.academic_year = academic_year;
        this.semester = semester;
        this.number_of_classes = number_of_classes;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public int getNumber_of_classes() {
        return number_of_classes;
    }

    public void setNumber_of_classes(int number_of_classes) {
        this.number_of_classes = number_of_classes;
    }

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
