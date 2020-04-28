package com.company.demojavabatch.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginResult {
    private String username;
    private String token;

    public static LoginResult jsonStringToLoginResult (String jsonString) throws JsonProcessingException {
        LoginResult loginResult = new ObjectMapper().readValue(jsonString,LoginResult.class);
        return loginResult;
    }
}
