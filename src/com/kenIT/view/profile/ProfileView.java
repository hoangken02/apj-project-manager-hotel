package com.kenIT.view.profile;

import com.kenIT.controller.CustomerController;
import com.kenIT.service.customer_current.CustomerCurrentServiceImpl;
import com.kenIT.view.Main;

import java.util.Scanner;

public class ProfileView {
    public ProfileView(){
        Scanner scanner = new Scanner(System.in);
        CustomerController customerController = new CustomerController();
        int choice;
        do {
            System.out.println("Welcome to profile" + CustomerCurrentServiceImpl.customerCurrentsList.get(0).getName());
            System.out.println("1.View profile");
            System.out.println("2.Update profile");
            System.out.println("3.Log out");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    new InformationView();
                    break;
                case 2:
                    new UpdateProfileView();
                    break;
                case 3:
                    customerController.logout();
                    new Main();
                    break;
                default:
                    choice = -1;
                    break;
            }
        }while (choice == -1);
    }
}
