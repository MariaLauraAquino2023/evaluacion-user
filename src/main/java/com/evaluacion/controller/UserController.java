package com.evaluacion.controller;

import com.evaluacion.dto.request.CreateUserRequest;
import com.evaluacion.dto.response.CreateUserResponse;
import com.evaluacion.model.User;
import com.evaluacion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para ABM de Usuario
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Crea un usuario si su email no está registrado.Retorna un JWT dentro de la response
     * entre otros datos.
     * @param CreateUserRequest req
     * @return ResponseEntity<CreateUserResponse> res
     */
    @PostMapping("/register")
    public ResponseEntity<CreateUserResponse> registerUser(@RequestBody CreateUserRequest request) {
        CreateUserResponse response = userService.createUser(request);
        if (!response.getMensaje().isEmpty()){
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /*Endpoint solo para testing*/
    @GetMapping
    public List<User> getAll() {
        return userService.getAllUser();
    }

}
