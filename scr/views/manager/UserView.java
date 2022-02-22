package views.manager;


import model.user.User;
import services.UserService;
import services.thread.Loading;
import views.Menu;

import java.util.List;
import java.util.Scanner;

public class UserView extends Thread {
    static Scanner scanner = new Scanner(System.in);
    private UserService userService;

    public UserView() {
        userService = new UserService();
        loginUser();
    }

    public void loginUser() {
        List<User> userList = userService.getUser();
        System.out.println("====================================================================");
        System.out.println("|                       |ĐĂNG NHẬP HỆ THỐNG|                       |");
        System.out.println("====================================================================");
        try {
            boolean flag = true;
            do {
                System.out.print("\tusername:\t");
                String username = scanner.nextLine();
                System.out.print("\tpassword :\t");
                String password = scanner.nextLine();
                for (User user : userList) {
                    if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                        Loading.loading();
                        System.out.println();
                        Menu.startMenu();
                    } else {
                        System.out.println("Lỗi!!! Mời Nhập Lại");
                        flag = false;
                    }
                }
            } while (!flag);
        } catch (Exception ex) {
            System.out.println("Không hợp lệ, mời nhập lại");
        }
    }
//
//    public static void main(String[] args) {
//        Loading loading = new Loading();
//        Thread t1 = new Thread() {
//            public void run() {
//                loading.loading();
//            }
//        };
//        Thread t2 = new Thread() {
//            public void run() {
//                loading.loading();
//            }
//        };
//        t1.start();
//        t2.start();
//    }
}
