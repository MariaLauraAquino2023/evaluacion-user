package com.evaluacion.controller;

import com.evaluacion.dto.request.CreateUserRequest;
import com.evaluacion.dto.response.CreateUserResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    static final String VALID_EMAIL = "abc@domain.com";
    static final String VALID_PWD = "ValidPwd123";
    static final String INVALID_EMAIL = "abcdomain.com";
    static final String INVALID_PWD = "invalidpwd123";
    static CreateUserRequest createWithInvalidPwdReq;
    static CreateUserRequest createWithInvalidEmailReq;
    static CreateUserRequest createValidReq;
    @BeforeAll
    static void setUp() {
        createValidReq = new CreateUserRequest("name123", VALID_EMAIL,VALID_PWD);
        createWithInvalidEmailReq = new CreateUserRequest("name123", INVALID_EMAIL,VALID_PWD);
        createWithInvalidPwdReq = new CreateUserRequest("name123",VALID_EMAIL,INVALID_PWD);
  }
    @Test
    void registerInvalidPasswordReturnsServerErrorWithMsg() throws Exception {

        ResponseEntity<CreateUserResponse> res = restTemplate
                .postForEntity("/user/register",
                        createWithInvalidPwdReq,
                        CreateUserResponse.class);

        Assertions.assertNotEquals(res.getBody().getMensaje(),"");
        Assertions.assertEquals(res.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    void registerInvalidEmailReturnsServerErrorWithMsg() throws Exception {

        ResponseEntity<CreateUserResponse> res = restTemplate
                .postForEntity("/user/register",
                        createWithInvalidEmailReq,
                        CreateUserResponse.class);

        Assertions.assertNotEquals(res.getBody().getMensaje(),"");
        Assertions.assertEquals(res.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    void registerValidUserReturnsOkAndUserIdIsCreated() throws Exception {

        ResponseEntity<CreateUserResponse> res = restTemplate
                .postForEntity("/user/register",
                        createValidReq,
                        CreateUserResponse.class);

        Assertions.assertEquals(res.getBody().getMensaje(),"");
        Assertions.assertNotNull(res.getBody().getId());
        Assertions.assertEquals(res.getStatusCode(), HttpStatus.CREATED);
    }

}
