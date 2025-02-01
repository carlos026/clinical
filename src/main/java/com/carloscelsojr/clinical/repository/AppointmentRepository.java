package com.carloscelsojr.clinical.repository;

import com.carloscelsojr.clinical.model.AppointmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ccondejr
 */
public interface AppointmentRepository extends JpaRepository<AppointmentModel, Long> {
    
}
