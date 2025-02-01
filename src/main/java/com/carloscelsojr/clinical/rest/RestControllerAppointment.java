package com.carloscelsojr.clinical.rest;

import com.carloscelsojr.clinical.facade.FacadeAppointment;
import java.text.ParseException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ccondejr
 */
@RestController
@RequestMapping("/view")
public class RestControllerAppointment {
    
    @Autowired
    private FacadeAppointment facadeAppointment;
    
    @GetMapping("/doctors")
    public ResponseEntity<?> listAllDoctors(){
        return facadeAppointment.listAllDoctors();
    }
    
    @Transactional
    @GetMapping("/Appointment")
    public ResponseEntity<?> newAppointment(
            @RequestParam String doctor,
            @RequestParam String dtAppoint,
            @RequestParam String email,
            @RequestParam String desc
    ) throws ParseException{
        return facadeAppointment.newAppointment(doctor, dtAppoint, email, desc);
    }
    
    @Transactional
    @GetMapping("/grid")
    public ResponseEntity<?> listAllAppointments(){
        return facadeAppointment.listAllAppointments();
    }
}
