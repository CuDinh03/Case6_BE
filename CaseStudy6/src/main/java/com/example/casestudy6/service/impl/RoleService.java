package com.example.casestudy6.service.impl;

import com.example.casestudy6.model.Role;
import com.example.casestudy6.repository.IRoleRepo;
import com.example.casestudy6.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepo iRoleRepo;

    public Set<Role> findById(int id){
        return  iRoleRepo.findById(id);
    }

    @Override
    public Iterable<Role> findAll() {
        return iRoleRepo.findAll();
    }

    @Override
    public void save(Role role) {
        iRoleRepo.save(role);
    }

    @Override
    public Role findByName(String name) {
        return iRoleRepo.findByName(name);
    }
}
