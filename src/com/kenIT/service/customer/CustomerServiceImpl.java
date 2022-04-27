package com.kenIT.service.customer;

import com.kenIT.config.ConfigReadAndWriteFile;
import com.kenIT.model.Customer;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    public static final String PATH_CUSTOMER = ConfigReadAndWriteFile.PATH + "\\customer.txt";
    public static List<Customer> customerList = new ConfigReadAndWriteFile().readFromFile(PATH_CUSTOMER);
    @Override
    public List<Customer> findAll() {
        new ConfigReadAndWriteFile<Customer>().writeToFile(PATH_CUSTOMER,customerList);
        return customerList;
    }

    @Override
    public Customer save(Customer customer) {
        customerList.add(customer);
        return customer;
    }

    @Override
    public boolean exitedByUsername(String username) {
        for (int i = 0; i < customerList.size(); i++) {
            if (username.equals(customerList.get(i).getUserName())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getUserName().equals(username) && customerList.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean exitedByCMND(String cMND) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getcMND().equals(cMND)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Customer findCustomerByName(String username) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getUserName().equals(username)){
                return customerList.get(i);
            }
        }
        return null;
    }

    @Override
    public Customer findCustomerByCMND(String cMND) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getcMND().equals(cMND)){
                return customerList.get(i);
            }
        }
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        for (Customer c:
             customerList) {
            if (c.getcMND().equals(customer.getcMND())){
                c.setName(customer.getName());
                c.setAge(customer.getAge());
                c.setGender(customer.getGender());
                c.setCountry(customer.getCountry());
                return c;
            }
        }
        return null;
    }

}
