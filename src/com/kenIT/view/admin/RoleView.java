package com.kenIT.view.admin;

import com.kenIT.controller.RoleController;
import com.kenIT.view.Main;


public class RoleView {
    RoleController roleController = new RoleController();
    public RoleView(){
        System.out.println("===============");
        System.out.println(roleController.showListRole());
        new Main();
    }
}
