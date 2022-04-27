package com.kenIT.view.profile;

import com.kenIT.controller.CustomerController;
import com.kenIT.model.Customer;
import com.kenIT.model.CustomerCurrent;
import com.kenIT.service.customer_current.CustomerCurrentServiceImpl;

import java.util.Scanner;

public class UpdateProfileView {
    public UpdateProfileView(){
        Scanner scanner = new Scanner(System.in);
        CustomerController customerController = new CustomerController();
        CustomerCurrent customerCurrent = CustomerCurrentServiceImpl.customerCurrentsList.get(0);
        System.out.println("Input name:");
        String name = scanner.nextLine();
        System.out.println("Input age:");
        String age = scanner.nextLine();
        System.out.println("Input gender:");
        String gender = scanner.nextLine();
        System.out.println("Input country:");
        String country = scanner.nextLine();
        Customer customer = new Customer(customerCurrent.getId(),name,customerCurrent.getUserName(),customerCurrent.getPassword(),age,gender,customerCurrent.getcMND(),country,customerCurrent.getStrRole());
        customerController.updateProfile(customer);
        System.out.println("Success update");
        new ProfileView();
    }
}
