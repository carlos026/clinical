package com.carloscelsojr.clinical.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author ccondejr
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
