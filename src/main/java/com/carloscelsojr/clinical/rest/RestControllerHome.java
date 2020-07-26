/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carloscelsojr.clinical.rest;

import javax.annotation.PostConstruct;
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
@RequestMapping("/view")
public class RestControllerHome {

    @GetMapping("/logout")
    public RedirectView logout() {
        return new RedirectView("Login.html");
    }
    
//    @PostMapping("/{id}")
//     public RedirectView signin(
//            @PathVariable Long id
//    ){
//         
//         return new RedirectView("HomePage.html");
////        if(id > 0){
////            return new RedirectView("HomePage.html");
////        }else{
////            return new RedirectView("Login.html");
////        }
//    }
}
