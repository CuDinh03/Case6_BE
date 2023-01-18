package com.example.casestudy6.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
public class SignUpForm {
    private String userName;
    private String email;
    private String password;
    private String fistName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private Date birthDay;
    private String gender;
}
