/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carloscelsojr.clinical.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author carlos_celso
 */
@Entity
@Table(name = "appointment", schema = "medico")
public class AppointmentModel implements Serializable {
     
    private static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_APPOINTMENT")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_APPOINTMENT_DOCTOR", referencedColumnName = "ID_DOCTOR")
    private DoctorModel appDoctor;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_APPOINTMENT_USER", referencedColumnName = "IDUSER")
    private UserModel appUser;
    
    @Column(name = "DESCRIPTION")
    private String desc;
    
    @Column(name = "CREATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DoctorModel getAppDoctor() {
        return appDoctor;
    }

    public void setAppDoctor(DoctorModel appDoctor) {
        this.appDoctor = appDoctor;
    }

    public UserModel getAppUser() {
        return appUser;
    }

    public void setAppUser(UserModel appUser) {
        this.appUser = appUser;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
