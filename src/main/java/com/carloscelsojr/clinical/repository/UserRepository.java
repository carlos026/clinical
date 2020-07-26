/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carloscelsojr.clinical.repository;

import com.carloscelsojr.clinical.model.UserModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author carlos_celso
 */
public interface UserRepository extends JpaRepository<UserModel, Long> {

    public List<UserModel> findAllByUserEmail(String email);
    
}
