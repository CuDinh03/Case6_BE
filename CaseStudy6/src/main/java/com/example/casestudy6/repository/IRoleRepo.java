package com.example.casestudy6.repository;

import com.example.casestudy6.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IRoleRepo extends PagingAndSortingRepository<Role,Long> {
    Role findByName(String roleName);
}
