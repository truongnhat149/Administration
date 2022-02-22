package views.manager;

import views.Menu;

import java.util.Scanner;

public class ManagerOrderView {
    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        Menu.orderMenu();
        OrderView orderView = new OrderView();
        System.out.print("Chọn chức năng \n => \t");
        try {
            boolean flag = true;
            int choice = Integer.parseInt(scanner.nextLine());
            do {
                switch (choice) {
                    case 1 :
                        orderView.addOrder();
                        break;
                    case 2 :
                        orderView.showAllOrder();
                        break;
                    case 0 :
                        ManagerChairView.create();
                        break;
                    default:
                        System.out.println("Chưa hợp lệ !! Mời nhập lại");
                        flag = false;
                }
            } while (!flag);
        } catch (Exception e) {
            System.out.println("Chưa hợp lệ, mời nhập lại!!!");
        }
    }
}
