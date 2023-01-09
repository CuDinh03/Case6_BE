package com.example.casestudy6.model.DTO;

import com.example.casestudy6.model.Img;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private Long id;
    private String token;
    private String userName;
    private String email;
    private String phoneNumber;
    private Img img;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(Long id, String token, String userName, String email, String phoneNumber,Img img, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.token = token;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }

    public JwtResponse(String token, Long id, String userName, String email, String phoneNumber,Img img, Collection<? extends GrantedAuthority>roles) {
        this.id = id;
        this.token = token;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.img=img;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Img getImg() {
        return img;
    }

    public void setImg(Img img) {
        this.img = img;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
