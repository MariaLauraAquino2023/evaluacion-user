package com.evaluacion.service.impl;

import com.evaluacion.dto.request.CreateUserRequest;
import com.evaluacion.dto.response.CreateUserResponse;
import com.evaluacion.model.User;

import com.evaluacion.repository.UserRepository;
import com.evaluacion.service.UserService;
import com.evaluacion.service.mapper.UserMapper;
import com.evaluacion.util.JWTUtil;
import com.evaluacion.util.UserUtil;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Servicio para ABM de la entidad Usuario
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JWTUtil jwtUtil;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);


    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Realiza validaciones de los datos del usuario que se quiere dar de alta.
     * Lo persiste en la base de datos.
     * @param CreateUserRequest req
     * @return CreateUserResponse res
     */
    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserReq) {
        CreateUserResponse response = new CreateUserResponse();
        try{
            if(!UserUtil.validateEmail(createUserReq.getEmail())){
                response.setMensaje("El email no es valido");
            }
            else if(!UserUtil.validatePassword(createUserReq.getPassword())){
                response.setMensaje("Contrasena no valida");
            }
            else{
                Optional<User> user = userRepository.findByEmailContainingIgnoreCase(createUserReq.getEmail());
                if(user.isPresent()){
                    response.setMensaje("El correo ya esta registrado");
                }
                else{
                    User req = userMapper.userFromCreateUserRequest(createUserReq);
                    req.setIsActive(true);
                    req.setModified(new Date());
                    req.setCreated(new Date());
                    req.setLastLogin(new Date());
                    req.setToken(jwtUtil.generateToken(new HashMap<String,Object>(),createUserReq.getEmail()));
                    User newUser = userRepository.save(req);
                    response = userMapper.createUserResponseFromUser(newUser);
                }
            }

        }catch(Exception e){
            CreateUserResponse errResponse = new CreateUserResponse();
            logger.error(e.getMessage() + "["+createUserReq +"]");
            errResponse.setMensaje("Error inesperado");
            return errResponse;
        }
        return response;
    }

    @Override
    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);

    }
}