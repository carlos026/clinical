package com.carloscelsojr.clinical.rest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author ccondejr
 */
@RestController
@RequestMapping("/")
public class RestControllerIndex {
    @GetMapping
    public RedirectView login(){
        return new RedirectView("view/Login.html");
    }
}
