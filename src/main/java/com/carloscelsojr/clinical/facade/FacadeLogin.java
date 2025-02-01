package com.carloscelsojr.clinical.facade;

import com.carloscelsojr.clinical.util.UtilRequestResponse;
import com.carloscelsojr.clinical.exception.RoleException;
import com.carloscelsojr.clinical.model.ClientModel;
import com.carloscelsojr.clinical.repository.ClientRepository;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author ccondejr
 */
@Service
public class FacadeLogin {

    @Autowired
    private UtilRequestResponse utilRequestResponse;
    
    @Autowired
    private ClientRepository clientRepository;

    public ResponseEntity<?> validClient(String email, String pass) {
        ResponseEntity<?> output = null;
        try {
            HashMap<String, Object> body = new HashMap<>();
            List<ClientModel> listClients = clientRepository.findAllByEmail(email);
            
            if (listClients.size() == 0) {
                throw new RoleException("Customer not found!");
            }
            String clientPass = listClients.get(0).getPassword();
            if (!clientPass.equals(pass)) {
                throw new RoleException("Invalid Password!");
            }
            
            body.put("message", "User login success");
            body.put("id", listClients.get(0).getId());
            output = ResponseEntity
                    .status(HttpStatus.OK)
                    .body(body);
        } catch (RoleException e) {
            output = utilRequestResponse.getErrorResponse(e);
        }
        return output;
    }

    public ResponseEntity<?> newClient(String name, String email, String password) {
        ResponseEntity<?> output = null;
        try {
            HashMap<String, Object> body = new HashMap<>();
            
            if (email.isEmpty() || name.isEmpty() || password.isEmpty()) {
                throw new RoleException("Invalid character or field is empty!");
            }
            
//            if(email.split("@").length > 1){
//                 throw new RoleException("Invalid Email Address!");
//            }
            
            ClientModel client = new ClientModel();
            client.setName(name);
            client.setEmail(email);
            client.setPassword(password);
            
            List<ClientModel> listClients = clientRepository.findAllByEmail(client.getEmail());
            if (listClients.size() > 0) {
                throw new RoleException("User already exists!");
            }
            clientRepository.save(client);
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
