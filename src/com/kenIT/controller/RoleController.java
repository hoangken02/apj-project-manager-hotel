package com.kenIT.controller;

import com.kenIT.model.Role;
import com.kenIT.service.role.RoleServiceImpl;

import java.util.List;

public class RoleController {
    RoleServiceImpl roleService = new RoleServiceImpl();
    public List<Role> showListRole(){
        return roleService.findAll();
    }
}
