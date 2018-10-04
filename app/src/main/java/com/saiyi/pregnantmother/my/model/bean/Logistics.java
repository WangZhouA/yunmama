package com.saiyi.pregnantmother.my.model.bean;

import java.util.List;

/**
 * Created by JingNing on 2018-07-09 11:35
 */
public class Logistics {
    private String company;
    private String code;
    private String phone;
    private List<LogisticsProgress> progresses;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<LogisticsProgress> getProgresses() {
        return progresses;
    }

    public void setProgresses(List<LogisticsProgress> progresses) {
        this.progresses = progresses;
    }
}
