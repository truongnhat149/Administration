package views.manager;

import views.Menu;

import java.util.Scanner;

public class ManagerOrderView {
    static Scanner scanner = new Scanner(System.in);

    public static void start() {
        Menu.orderMenu();
        OrderView orderView = new OrderView();
        System.out.print("Chọn chức năng \n => \t");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 :
                orderView.addOrder();
                break;
            case 2 :
                orderView.showAllOrder();
                break;
            default:
                System.out.println("Chưa hợp lệ !! Mời nhập lại");
        }
    }
}
