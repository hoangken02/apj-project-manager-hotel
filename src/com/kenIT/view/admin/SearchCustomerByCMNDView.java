package com.kenIT.view.admin;

import com.kenIT.controller.CustomerController;
import com.kenIT.view.Menu;

import java.util.Scanner;

public class SearchCustomerByCMNDView {
    CustomerController customerController = new CustomerController();
    Scanner scanner = new Scanner(System.in);

    public SearchCustomerByCMNDView() {
        System.out.println("======================================");
        System.out.println("Input customer you want search: ");
        String cMND;
        boolean stopLoop = false;
        while (stopLoop == false) {
            cMND = scanner.nextLine();
            boolean checkCMND = customerController.searchCustomByCMND(cMND);
            if (checkCMND == false) {
                stopLoop = false;
                System.out.println("No find this customer!\nPlease input again:");
            } else {
                stopLoop = true;
            }
        }
        new Menu();
    }
}
