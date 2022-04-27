package com.kenIT.view.login;

import com.kenIT.controller.CustomerController;
import com.kenIT.dto.SignInDTO;
import com.kenIT.model.Customer;
import com.kenIT.service.customer.CustomerServiceImpl;
import com.kenIT.view.Menu;

import java.util.Scanner;

public class LoginView {
    Scanner scanner = new Scanner(System.in);
    CustomerController customerController = new CustomerController();
    public LoginView() {
        System.out.println("==================================");
        for (Customer c:
             CustomerServiceImpl.customerList) {
            System.out.println(c);
        }
        System.out.println("Enter username: ");
        String useName = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        SignInDTO signInDTO = new SignInDTO(useName,password);
        if (customerController.login(signInDTO)){
            new Menu();
        }else {
            System.out.println("Login failed!\nPlease check again: ");
            new LoginView();
        }
    }
}
