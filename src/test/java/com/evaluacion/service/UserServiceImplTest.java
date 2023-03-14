package com.evaluacion.service;

import com.evaluacion.dto.request.CreateUserRequest;
import com.evaluacion.model.User;
import com.evaluacion.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.mockito.Mockito;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceImplTest {

    static final String EXISTING_EMAIL = "abc@domain.com";
    static final String VALID_PWD = "ValidPwd123";

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @BeforeEach
    void setUp() {
        Optional<User> existingUser = Optional.of(new User());
        Mockito.when(userRepository.findByEmailContainingIgnoreCase(EXISTING_EMAIL)).thenReturn(existingUser);
    }

    @Test
    void insertUserWithSameEmailTwiceGetErrMsgNotEmpty() {
        CreateUserRequest req = new CreateUserRequest();
        req.setEmail(EXISTING_EMAIL);
        req.setPassword(VALID_PWD);
        Assertions.assertNotEquals(userService.createUser(req).getMensaje(),"");
    }

}