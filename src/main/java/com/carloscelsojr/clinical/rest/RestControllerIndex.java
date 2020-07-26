/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carloscelsojr.clinical.rest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author carlos_celso
 */
@RestController
@RequestMapping("/")
public class RestControllerIndex {
    @GetMapping
    public RedirectView login(){
        return new RedirectView("view/Login.html");
    }
}
