package com.kenIT.controller;

import com.kenIT.dto.SignInDTO;
import com.kenIT.dto.SignUpDTO;
import com.kenIT.model.Customer;
import com.kenIT.model.CustomerCurrent;
import com.kenIT.model.Role;
import com.kenIT.model.RoleName;
import com.kenIT.service.customer.CustomerServiceImpl;
import com.kenIT.service.customer_current.CustomerCurrentServiceImpl;
import com.kenIT.service.role.RoleServiceImpl;

import java.util.HashSet;
import java.util.Set;

public class CustomerController {
    CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
    RoleServiceImpl roleService = new RoleServiceImpl();
    CustomerCurrentServiceImpl customerCurrentService = new CustomerCurrentServiceImpl();

    public void register(SignUpDTO signUpDTO) {
        int id;
        if (CustomerServiceImpl.customerList.size() == 0) {
            id = 1;
        } else {
            id = CustomerServiceImpl.customerList.get(CustomerServiceImpl.customerList.size() - 1).getId() + 1;
        }

        Set<String> strRole = signUpDTO.getStrRole();
        Set<Role> roleSet = new HashSet<>();
        strRole.forEach(role -> {
            switch (role) {
                case "admin":
                    Role admin = roleService.findByName(RoleName.ADMIN);
                    roleSet.add(admin);
                    break;
                case "customer":
                    Role customer = roleService.findByName(RoleName.CUSTOMER);
                    roleSet.add(customer);
                    break;
            }
        });

        Customer customer = new Customer(id, signUpDTO.getName(), signUpDTO.getUserName(), signUpDTO.getPassword(), signUpDTO.getcMND(), roleSet);
        customerServiceImpl.save(customer);
        customerServiceImpl.findAll();
    }

    public boolean login(SignInDTO signInDTO) {
        if (customerServiceImpl.checkLogin(signInDTO.getUsername(), signInDTO.getPassword())
        ) {
            Customer customer = customerServiceImpl.findCustomerByName(signInDTO.getUsername());
            CustomerCurrent customerCurrent = new CustomerCurrent(customer.getId(), customer.getName(), customer.getUserName(), customer.getPassword(), customer.getcMND(), customer.getRoleSet());
            customerCurrentService.save(customerCurrent);
            customerCurrentService.findAll();
            return true;
        } else {
            return false;

        }
    }

    public boolean searchCustomByCMND(String cMND) {
        Customer customer = customerServiceImpl.findCustomerByCMND(cMND);
        if (customer == null) {
            return false;
        } else {
            System.out.println(customer);
            return true;
        }
    }

    public void logout(){
        CustomerCurrentServiceImpl.customerCurrentsList.clear();
        customerCurrentService.findAll();
    }

    public void updateProfile(Customer customer){
        customerServiceImpl.update(customer);
        customerServiceImpl.findAll();
    }

    public Customer showInformationCustomer(CustomerCurrent customerCurrent){
       return customerServiceImpl.findCustomerByName(customerCurrent.getUserName());
    }
}