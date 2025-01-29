/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carloscelsojr.clinical.facade;

import com.carloscelsojr.clinical.exception.RoleException;
import com.carloscelsojr.clinical.model.AppointmentModel;
import com.carloscelsojr.clinical.model.DoctorModel;
import com.carloscelsojr.clinical.model.ClientModel;
import com.carloscelsojr.clinical.repository.AppointmentRepository;
import com.carloscelsojr.clinical.repository.MedicRepository;
import com.carloscelsojr.clinical.repository.ClientRepository;
import com.carloscelsojr.clinical.util.UtilRequestResponse;
import com.carloscelsojt.clinical.dto.AppointmentDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class FacadeAppointment {

    @Autowired
    private MedicRepository medicRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UtilRequestResponse utilRequestResponse;

    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity<?> listAllDoctors() {
        ResponseEntity<?> output = null;
        try {
            HashMap<String, Object> body = new HashMap<>();

            body.put("data", medicRepository.findAll());

            output = ResponseEntity
                    .status(HttpStatus.OK)
                    .body(body);
        } catch (RoleException e) {
            output = utilRequestResponse.getErrorResponse(e);
        }

        return output;
    }

    public ResponseEntity<?> newAppointment(String doctor, String dtAppoint, String email, String desc) throws ParseException {
        ResponseEntity<?> output = null;
        try {
            HashMap<String, Object> body = new HashMap<>();
            Date dtAp = new SimpleDateFormat("dd/MM/yyyy").parse(dtAppoint);

            List<ClientModel> client = clientRepository.findAllByEmail(email);

            if (client.size() == 0) {
                throw new RoleException("Your email was not found!");
            }

            DoctorModel doctorModel = medicRepository.findAllByName(doctor);
            AppointmentModel appointment = new AppointmentModel();
            appointment.setCreationDate(dtAp);
            appointment.setAppDoctor(doctorModel);
            appointment.setDesc(desc);
            appointment.setClient(client.get(0));
            appointmentRepository.save(appointment);

            body.put("data", medicRepository.findAll());
            body.put("message", "Appointment created successfully!");

            output = ResponseEntity
                    .status(HttpStatus.OK)
                    .body(body);
        } catch (RoleException e) {
            output = utilRequestResponse.getErrorResponse(e);
        } catch (ParseException e) {
            HashMap<String, Object> body = new HashMap<>();
            body.put("message", e.getMessage());
            output = ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(body);
        }

        return output;
    }

    public ResponseEntity<?> listAllAppointments() {
        ResponseEntity<?> output = null;
        try {
            HashMap<String, Object> body = new HashMap<>();
            ArrayList<AppointmentDto> itemsApp = new ArrayList<>();
            List<AppointmentModel> appointmentList = appointmentRepository.findAll();
            for (AppointmentModel appointment : appointmentList) {
                AppointmentDto itemApp = new AppointmentDto();
                itemApp.setDoctor(appointment.getAppDoctor().getName());
                itemApp.setCustomer(appointment.getClient().getName());
                itemApp.setDesc(appointment.getDesc());
                itemApp.setDtAppoint(appointment.getCreationDate());
                itemsApp.add(itemApp);
            }
            
            body.put("data", itemsApp);
            output = ResponseEntity
                    .status(HttpStatus.OK)
                    .body(body);
        } catch (RoleException e) {
             output = utilRequestResponse.getErrorResponse(e);
        } catch(Exception e){
            HashMap<String, Object> body = new HashMap<>();
            body.put("message", e.getMessage());
            output = ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(body);
        }

        return output;
    }
}
