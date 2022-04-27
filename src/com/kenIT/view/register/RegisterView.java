package com.kenIT.view.register;

import com.kenIT.controller.CustomerController;
import com.kenIT.dto.SignUpDTO;
import com.kenIT.service.customer.CustomerServiceImpl;
import com.kenIT.view.login.LoginView;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class RegisterView {
    Scanner scanner = new Scanner(System.in);
    CustomerController controller = new CustomerController();
    CustomerServiceImpl customerService = new CustomerServiceImpl();

    public void registerView() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter username: ");
        String useName;
        boolean checkUsername;
        while (true) {
            useName = scanner.nextLine();
            checkUsername = Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[^@$!%*?&])[A-Za-z\\d^@$!%*?&]{6,10}$",useName);
            if (checkUsername){
                if (customerService.exitedByUsername(useName)){
                    System.out.println("Username is exited!\nPlease input username again:");
                }else {
                    break;
                }
            }else {
                System.out.println("Minimum eight characters and maximum ten characters, at least one uppercase letter, one lowercase letter, one number and one special character\n" + "Ex: Hoang12@");
                System.out.println("Please input username again: ");
            }
        }
        System.out.println("Enter password: ");
        String password;
        boolean checkPassword;
        while (true){
            password = scanner.nextLine();
            checkPassword = Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[^@$!%*?&])[A-Za-z\\d^@$!%*?&]{6,10}$",password);
            if (checkPassword){
                break;
            }else {
                System.out.println("Minimum eight characters and maximum ten characters, at least one uppercase letter, one lowercase letter, one number and one special character\n" + "Ex: Password@1");
                System.out.println("Please input username again: ");
            }
        }
        System.out.println("Enter CMND: ");
        String cMND;
        boolean checkCMND;
        while (true){
            cMND =  scanner.nextLine();
            checkCMND = Pattern.matches("[\\d]{9}",cMND);
            if (checkCMND){
                if (customerService.exitedByCMND(cMND)){
                    System.out.println("CMND is exited!\nPlease input CMND again:");
                }else {
                    break;
                }
            }else {
                System.out.println("Must be 9 numbers\nEx: 123456789");
                System.out.println("Please input CMND again: ");            }
        }
        System.out.println("Enter role: ");
        String role = scanner.nextLine();
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SignUpDTO signUpDTO = new SignUpDTO(name, useName, password, cMND, strRole);
        controller.register(signUpDTO);
        new LoginView();
    }
}
