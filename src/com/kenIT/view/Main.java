package com.kenIT.view;

import com.kenIT.view.admin.RoleView;
import com.kenIT.view.login.LoginView;
import com.kenIT.view.register.RegisterView;

import java.util.Scanner;

public class Main {
public Main(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("========================================");
    System.out.println("1.Register");
    System.out.println("2 Login");
    System.out.println("0 Exit");
    System.out.println("========================================");
    String choice = scanner.nextLine();
    switch (choice){
        case "1":
            new RegisterView().registerView();
            break;
        case "2":
            new LoginView();
            break;
        case "3":
            new RoleView();
            break;
        case "0":
            System.out.println("Thanks you! See you again <3");
            System.exit(0);
            break;
        default:
            System.out.println("Please input again");
            new Main();
    }
}
    public static void main(String[] args) {
        new Main();

    }


}
