package com.example.demo.services.reposervices;

import com.example.demo.domain.Role;
import com.example.demo.repositories.RoleRepsoitory;
import com.example.demo.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Profile("springdatajpa")
public class RoleServiceRepoImpl implements RoleService {

    private RoleRepsoitory roleRepsoitory;

    @Autowired
    public void setRoleRepsoitory(RoleRepsoitory roleRepsoitory) {
        this.roleRepsoitory = roleRepsoitory;
    }

    @Override
    public List<?> listAll() {
        List<Role> roles = new ArrayList<>();
        roleRepsoitory.findAll().forEach(roles::add);
        return roles;
    }

    @Override
    public Role getById(Integer id) {
        return roleRepsoitory.findOne(id);
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {
        return roleRepsoitory.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        roleRepsoitory.delete(id);
    }
}
