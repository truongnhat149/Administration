package views.sort;

import java.util.Scanner;

public class MenuSort {
    public static Scanner scanner = new Scanner(System.in);

    public static void sortMenu() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("|                     LỰA CHỌN HIỂN THỊ                        |");
        System.out.println("---------------------------------------------------------------");
        System.out.println("|  1. Hiển thị sắp xếp theo id                                 |");
        System.out.println("|  2. Hiển thị sắp xếp theo tên                                |");
        System.out.println("|  3. Hiển thị sắp xếp theo số lượng                           |");
        System.out.println("|  4. Hiển thị sắp xếp theo giá                                |");
        System.out.println("|                                                  0. Quay lại |");
        System.out.println("----------------------------------------------------------------");
        System.out.print("=> \t");
    }
    public static void option() {
        try {
            boolean flag = true;
          do {
              int choice = Byte.parseByte(scanner.nextLine());
              switch (choice) {
                  case 1:
                      break;
                  case 2:
                      break;
                  case 3:
                      break;
                  case 4:
                      break;
                  default:
                      System.out.println("Không hợp lệ, mời nhập lại");
                      flag = false;
              }
          } while (!flag);
        } catch (Exception e) {
            System.out.println("Chưa hợp lệ!!! Mời Nhập Lại");
        }
    }
}
