/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carloscelsojr.clinical.rest;

import com.carloscelsojr.clinical.facade.FacadeLogin;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author carlos_celso
 */
@RestController
@RequestMapping(value = "/view")
public class RestControllerLogin {
    
    @Autowired
    private FacadeLogin facadeLogin;
    
    @Transactional
    @GetMapping("/valid")
    public ResponseEntity<?> validUser(
            @RequestParam String user,
            @RequestParam String pass
    ){
        return facadeLogin.validUser(user, pass);
    }
    
    @Transactional
    @GetMapping("/newUser")
    public ResponseEntity<?> newUser(
            @RequestParam String userName,
            @RequestParam String userEmail,
            @RequestParam String userPass
    ){
        return facadeLogin.newUser(userName, userEmail, userPass);
    }
   
}
