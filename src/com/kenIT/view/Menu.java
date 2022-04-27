package com.kenIT.view;

import com.kenIT.model.Role;
import com.kenIT.model.RoleName;
import com.kenIT.service.customer_current.CustomerCurrentServiceImpl;
import com.kenIT.view.admin.room.AdminBookRoomView;
import com.kenIT.view.admin.room.AdminCheckoutRoomView;
import com.kenIT.view.profile.ProfileView;
import com.kenIT.view.admin.SearchCustomerByCMNDView;
import com.kenIT.view.customer.CustomerBookRoomView;
import com.kenIT.view.customer.CustomerCheckoutRoomView;
import com.kenIT.view.admin.room.CreateRoomView;
import com.kenIT.view.admin.room.UpdateRoomView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Menu {
    Set<Role> set = CustomerCurrentServiceImpl.customerCurrentsList.get(0).getStrRole();
    List<Role> list = new ArrayList<>(set);

    public Menu() {
        boolean checkAdmin = list.get(0).getName().equals(RoleName.ADMIN);
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss  dd-MM-20yy");
        String formatterDate = localDateTime.format(formatter);
        int choice;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("--------------------------------------------------------------");
            System.out.println("Hà Nội: " + formatterDate);
            System.out.println("Chào mừng " + CustomerCurrentServiceImpl.customerCurrentsList.get(0).getName() + " đến với chức năng quản lý quán trọ của chúng tôi");
            System.out.println("1.Khách đặt phòng");
            System.out.println("2.Khách trả phòng");
            System.out.println("3.View profile");
            if (checkAdmin) {
                System.out.println("4.Sửa thông tin phòng: ");
                System.out.println("5.Tìm kiếm khách hàng theo CMND: ");
                System.out.println("6.Create a new room");
            }
            System.out.println("--------------------------------------------------------------");
            System.out.println("Chọn chức năng: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (checkAdmin) {
                        new AdminBookRoomView();
                    } else {
                        new CustomerBookRoomView();
                    }
                    break;
                case 2:
                    if (checkAdmin) {
                        new AdminCheckoutRoomView();
                    } else {
                        new CustomerCheckoutRoomView();
                    }
                    break;
                case 3:
                    new ProfileView();
                    break;
                case 4:
                    if (checkAdmin) {
                        new UpdateRoomView();
                    }
                    break;
                case 5:
                    if (checkAdmin) {
                        new SearchCustomerByCMNDView();
                    }
                    break;

                case 6:
                    if (checkAdmin) {
                        new CreateRoomView();
                    }
                    break;
                default:
                    System.out.println("No find");
                    choice = -1;
            }

        } while (choice == -1);
    }
}
