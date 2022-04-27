package com.kenIT.view.profile;

import com.kenIT.controller.CustomerController;
import com.kenIT.model.Customer;
import com.kenIT.service.customer_current.CustomerCurrentServiceImpl;

public class InformationView {
    public InformationView() {
        CustomerController customerController = new CustomerController();
        Customer customer = customerController.showInformationCustomer(CustomerCurrentServiceImpl.customerCurrentsList.get(0));
        System.out.println("===========================================");
        System.out.println("Name: " + customer.getName());
        System.out.println("Age: " + customer.getAge());
        System.out.println("Gender: " + customer.getGender());
        System.out.println("CMND: " + customer.getcMND());
        System.out.println("Country: " + customer.getCountry());
        System.out.println("===========================================");
        new ProfileView();
    }
}
