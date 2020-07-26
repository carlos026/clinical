/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carloscelsojr.clinical.model;

import java.io.Serializable;
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

/**
 *
 * @author carlos_celso
 */
@Entity
@Table(name = "specialty")
public class SpecialtyModel implements Serializable {
      private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SPECIALTY")
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_SPECIALTY_DOCTOR", referencedColumnName = "ID_DOCTOR")
    private DoctorModel spDoctor;
    
    @Column(name = "SPECIALITY_DESCRIPTION")
    private String spDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DoctorModel getSpDoctor() {
        return spDoctor;
    }

    public void setSpDoctor(DoctorModel spDoctor) {
        this.spDoctor = spDoctor;
    }

    public String getSpDesc() {
        return spDesc;
    }

    public void setSpDesc(String spDesc) {
        this.spDesc = spDesc;
    }
}
