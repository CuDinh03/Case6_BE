package com.example.casestudy6.repository;

import com.example.casestudy6.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Set;

public interface IRoleRepo extends PagingAndSortingRepository<Role, Integer> {
    Role findByName(String Name);
    Set<Role> findById(int id);
}
