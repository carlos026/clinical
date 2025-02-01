package com.carloscelsojr.clinical.repository;

import com.carloscelsojr.clinical.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ccondejr
 */
public interface MedicRepository extends JpaRepository<DoctorModel, Long> {

    public DoctorModel findAllByName(String doctor);
    
}
