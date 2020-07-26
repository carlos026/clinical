/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carloscelsojt.clinical.dto;

import java.util.Date;

/**
 *
 * @author carlos_celso
 */
public class AppointmentDto {
    
    private String doctor;
    private String customer;
    private String desc;
    private Date dtAppoint;

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDtAppoint() {
        return dtAppoint;
    }

    public void setDtAppoint(Date dtAppoint) {
        this.dtAppoint = dtAppoint;
    }
    
    
    
}
