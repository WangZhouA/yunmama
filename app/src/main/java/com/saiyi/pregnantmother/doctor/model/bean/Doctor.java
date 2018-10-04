package com.saiyi.pregnantmother.doctor.model.bean;

public class Doctor {
    private int id;
    private String name;
    private String level;
    private int status;
    private int hospitalId;
    private String hospitalName;
    private String department;
    private String headImg;
    private String profiles;

    public Doctor() {
        super();
    }

    public Doctor(String department) {
        this.department = department;
    }

    public Doctor(String name, String level, int status, String hospitalName, String department, String profiles) {
        this.name = name;
        this.level = level;
        this.status = status;
        this.hospitalName = hospitalName;
        this.department = department;
        this.profiles = profiles;
    }

    public Doctor(int id, String name, String level, int status, int hospitalId, String hospitalName, String department, String headImg, String profiles) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.status = status;
        this.hospitalId = hospitalId;
        this.hospitalName = hospitalName;
        this.department = department;
        this.headImg = headImg;
        this.profiles = profiles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getProfiles() {
        return profiles;
    }

    public void setProfiles(String profiles) {
        this.profiles = profiles;
    }
}
