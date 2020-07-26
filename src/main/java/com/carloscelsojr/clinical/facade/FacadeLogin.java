/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carloscelsojr.clinical.facade;

import com.carloscelsojr.clinical.util.UtilRequestResponse;
import com.carloscelsojr.clinical.exception.RoleException;
import com.carloscelsojr.clinical.model.UserModel;
import com.carloscelsojr.clinical.repository.UserRepository;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos_celso
 */
@Service
public class FacadeLogin {

    @Autowired
    private UtilRequestResponse utilRequestResponse;
    
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> validUser(String user, String pass) {
        ResponseEntity<?> output = null;
        try {
            HashMap<String, Object> body = new HashMap<>();
            List<UserModel> listUsers = userRepository.findAllByUserEmail(user);
            
            if (listUsers.size() == 0) {
                throw new RoleException("Customer not found!");
            }
            String userPass = listUsers.get(0).getUserPass();
            if (!userPass.equals(pass)) {
                throw new RoleException("Invalid Password!");
            }
            
            body.put("message", "User login success");
            body.put("id", listUsers.get(0).getId());
            output = ResponseEntity
                    .status(HttpStatus.OK)
                    .body(body);
        } catch (RoleException e) {
            output = utilRequestResponse.getErrorResponse(e);
        }
        return output;
    }

    public ResponseEntity<?> newUser(String userName, String userEmail, String userPass) {
        ResponseEntity<?> output = null;
        try {
            HashMap<String, Object> body = new HashMap<>();
            
            if (userEmail.isEmpty() || userName.isEmpty() || userPass.isEmpty()) {
                throw new RoleException("Invalid character or field is empty!");
            }
            
//            if(userEmail.split("@").length > 1){
//                 throw new RoleException("Invalid Email Address!");
//            }
            
            UserModel userModel = new UserModel();
            userModel.setUserName(userName);
            userModel.setUserEmail(userEmail);
            userModel.setUserPass(userPass);
            
            List<UserModel> listUsers = userRepository.findAllByUserEmail(userModel.getUserEmail());
            if (listUsers.size() > 0) {
                throw new RoleException("User already exists!");
            }
            userRepository.save(userModel);
            body.put("message", "User successfully registered!");
            output = ResponseEntity
                    .status(HttpStatus.OK)
                    .body(body);
        } catch (RoleException e) {
            output = utilRequestResponse.getErrorResponse(e);
        }
        return output;
    }
}
