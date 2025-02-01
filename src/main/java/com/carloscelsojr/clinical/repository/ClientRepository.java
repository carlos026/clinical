package com.carloscelsojr.clinical.repository;

import com.carloscelsojr.clinical.model.ClientModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ccondejr
 */
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    public List<ClientModel> findAllByEmail(String email);
    
}
