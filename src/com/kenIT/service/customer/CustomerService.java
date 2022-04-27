package com.kenIT.service.customer;

import com.kenIT.model.Customer;
import com.kenIT.service.IServiceGeneric;

public interface CustomerService extends IServiceGeneric<Customer> {
    boolean exitedByUsername(String username);
    boolean checkLogin(String username,String password);
    boolean exitedByCMND(String cMND);
    Customer findCustomerByName(String username);
    Customer findCustomerByCMND(String cMND);
    Customer update(Customer customer);
}
