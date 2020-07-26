/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carloscelsojr.clinical.util;

import com.carloscelsojr.clinical.exception.RoleException;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author carlos_celso
 */
@Component
public class UtilRequestResponse {
    public ResponseEntity<?> getErrorResponse(RoleException e){
        ResponseEntity<?> output = null;
        HashMap<String, Object> body = new HashMap<>();
        body.put("message", e.getLocalizedMessage());
        body.put("success", false);
        body.put("fail", true);

        output = ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(body);
        return output;
    }
}
