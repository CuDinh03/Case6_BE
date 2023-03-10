package com.example.casestudy6.model.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
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
