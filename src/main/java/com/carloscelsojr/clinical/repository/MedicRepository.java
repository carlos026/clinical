/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carloscelsojr.clinical.repository;

import com.carloscelsojr.clinical.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author carlos_celso
 */
public interface MedicRepository extends JpaRepository<DoctorModel, Long> {

    public DoctorModel findAllByName(String doctor);
    
}
