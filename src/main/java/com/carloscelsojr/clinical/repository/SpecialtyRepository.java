package com.carloscelsojr.clinical.repository;

import com.carloscelsojr.clinical.model.SpecialtyModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ccondejr
 */
public interface SpecialtyRepository extends JpaRepository<SpecialtyModel, Long> {
    
}
