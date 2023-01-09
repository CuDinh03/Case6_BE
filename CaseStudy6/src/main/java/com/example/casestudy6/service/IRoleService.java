package com.example.casestudy6.service;

import com.example.casestudy6.model.Role;

public interface IRoleService {
    Iterable<Role> findAll();


    void save(Role role);

    Role findByName(String name);
}
