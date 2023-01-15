package com.example.casestudy6.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChangePassword {
        private String oldPassword;
        private String newPassword;
        private String confirmNewPassword;
}
