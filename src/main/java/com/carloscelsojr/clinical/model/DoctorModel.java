package com.carloscelsojr.clinical.model;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 *
 * @author ccondejr
 */
@Entity
@Table(name="doctor", schema = "medico")
public class DoctorModel implements Serializable{
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOCTOR")
    private int id;
    
    @Column(name = "DOCTOR_NAME")
    private String name;
    
    @Column(name = "DOCTOR_EMAIL")
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
