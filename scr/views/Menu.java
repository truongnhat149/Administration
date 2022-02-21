package views;

import views.manager.ManagerChairView;
import views.manager.ManagerOrderView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    public Menu() {
        start();
    }

    public static void mainMenu() {
        System.out.println("========================================================");
        System.out.println("||                     |MAIN MENU|                    ||");
        System.out.println("========================================================");
        System.out.println("||                                                    ||");
        System.out.println("||                 1. Quản lí sản phẩm                ||");
        System.out.println("||                 2. Quản lí đơn hàng                ||");
        System.out.println("||                                                    ||");
        System.out.println("========================================================");
        System.out.print("Chọn chức năng \n=> \t");
    }

    public static void orderMenu() {
        System.out.println("-------------------------------------------------------");
        System.out.println("||                   QUẢN LÝ ĐƠN HÀNG                ||");
        System.out.println("-------------------------------------------------------");
        System.out.println("||                                                   ||");
        System.out.println("||               1. Tạo danh sách                    ||");
        System.out.println("||               2. Xem danh sách                    ||");
        System.out.println("||                                                   ||");
        System.out.println("-------------------------------------------------------");
    }

    public static void menuChair() {
        System.out.println("******************************************************");
        System.out.println("||                |QUẢN LÝ SẢN PHẨM|                ||");
        System.out.println("******************************************************");
        System.out.println("||        1. Thêm sản phẩm                          ||");
        System.out.println("||        2. Sửa thông tin sản phẩm                 ||");
        System.out.println("||        3. Tìm kiếm sản phẩm                      ||");
        System.out.println("||        4. Hiển thị sản phẩm                      ||");
        System.out.println("||        5. Xóa sản phẩm                           ||");
        System.out.println("||                                                  ||");
        System.out.println("||        9. Quay về menu chính                     ||");
        System.out.println("||                            0. Thoát chương trình ||");
        System.out.println("******************************************************");
        System.out.println();
        System.out.printf("Chọn chức năng  \n=> \t");
    }

    public static void exit() {
        System.out.print("\t\t Bạn vừa thoát khỏi chương trình.....");
        System.exit(0);
    }

    public static void start() {
        try {
            boolean flag = true;
            do {
                mainMenu();
                String num = scanner.nextLine();
                switch (num) {
                    case "1":
                        ManagerChairView.create();
                        break;
                    case "2":
                        ManagerOrderView.start();
                        break;
                    default:
                        System.out.println("Chưa hợp lệ!!! Mời nhập lại!!!");
                        flag = false;
                }
            } while (!flag);
        } catch (InputMismatchException io) {
            io.printStackTrace();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void inputOrder() {
        System.out.println("_________________________________________________");
        System.out.println("|                                               |");
        System.out.println("|           1, Nhấn 'c' để tiếp tục tạo đơn     |");
        System.out.println("|           2, Nhấn 'b' để quay lại             |");
        System.out.println("|           3, Nhấn 'p' để in hóa đơn           |");
        System.out.println("|           4, Nhấn 'e' để thoát                |");
        System.out.println("|                                               |");
        System.out.println("_________________________________________________");
        System.out.print("=> \t");
    }

    public static void inputUpdate() {
        System.out.println("=====================================");
        System.out.println("||    1. Cập nhật giá              ||");
        System.out.println("||    2. Cập nhật số lượng         ||");
        System.out.println("||    3. Cập nhật hãng sản xuất    ||");
        System.out.println("||                  4. Quay lại    ||");
        System.out.println("=====================================");
        System.out.println("Chọn chức năng");
        System.out.printf("=> \t");
    }


    public static void removeConfirm() {
        System.out.println("*******************************************************");
        System.out.println("*               BẠN CÓ CHẮC CHẮN MUỐN XÓA             *");
        System.out.println("*******************************************************");
        System.out.println("*                                                     *");
        System.out.println("*              1. Nhấn y để xác nhận xóa              *");
        System.out.println("*              2. Nhấn b để quay lại                  *");
        System.out.println("*                                                     *");
        System.out.println("*******************************************************");
        System.out.printf("=> \t");
    }
}
