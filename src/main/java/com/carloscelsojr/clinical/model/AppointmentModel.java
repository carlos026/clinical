/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carloscelsojr.clinical.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

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
    @JoinColumn(name = "ID_APPOINTMENT_CLIENT", referencedColumnName = "ID")
    private ClientModel client;
    
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

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
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
