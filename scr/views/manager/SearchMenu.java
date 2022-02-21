package views.manager;

import model.product.Chair;
import services.ChairService;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class SearchMenu {
    static Scanner scanner = new Scanner(System.in);
    static ChairService chairService = new ChairService();
    static DecimalFormat formater = new DecimalFormat("###,###,###" + "vnđ");

    public static void searchMenu() {
        boolean isChoice = true;
        char choice = ' ';
        do {
            System.out.println("------------------------------------------------------------");
            System.out.println("|                 TÌM KIẾM SẢN PHẨM                        |");
            System.out.println("------------------------------------------------------------");
            System.out.println("| 1. Tìm kiếm theo ID                                      |");
            System.out.println("| 2. Tìm kiếm theo tên                                     |");
            System.out.println("| 3. Tìm kiếm theo số lượng                                |");
            System.out.println("| 4. Tìm kiếm theo giá                                     |");
            System.out.println("|                                              0. Quay lại |");
            System.out.println(" -----------------------------------------------------------");
            System.out.println();
            System.out.print("Chọn\t=> ");
            try {
                choice = scanner.nextLine().charAt(0);
            } catch (Exception e) {
                choice = ' ';
            }
            switch (choice) {
                case '1':
                    searchById();
                    break;
                case '2':
                    searchByName();
                    break;
                case '3':
                    searchByQuantity();
                    break;
                case '4':
                    searchByPrice();
                    break;
                case '0':
                    ManagerChairView.create();
                    isChoice = false;
                    break;
                default:
                    System.out.println("Chưa hợp lệ! Mời Nhập Lại!!!");
            }

        } while (isChoice);
    }

    public static void searchByQuantity() {
        List<Chair> chairList = chairService.getItem();
        int count = 0;
        System.out.println();
        System.out.print("Nhập số lượng của sản phẩm cần tìm kiếm : ");
        try {
            int search = Integer.parseInt(scanner.nextLine());
            System.out.println("Kết quả :  '" + search + "' là : ");
            System.out.printf("%-10s %-20s %-18s %-10s %-10s", "Id", "Tên Sản Phẩm", "Giá: ", "Số lượng", "Nhà Sản Xuất\n");
            for (Chair chair : chairList) {
                if (chair.getQuantity() == search) {
                    count++;
                    System.out.printf("%-10s %-20s %-18s %-10s %-10s\n", chair.getProductID(), chair.getName(), formater.format(chair.getPrice()),
                            chair.getQuantity(), chair.getProvideName());
                }
            }
            showReturnSearch(count);
        } catch (Exception e) {
            System.out.println("Chưa hợp lệ... Mời nhập lại");
        }
    }

    public static void searchById() {
        List<Chair> chairList = chairService.getItem();
        int count = 0;
        System.out.println();
        System.out.print("Nhập ID sản phẩm cần tìm kiếm : ");
        try {
            int search = Integer.parseInt(scanner.nextLine());
            System.out.println("Kết quả :  '" + search + "' là : ");
            System.out.printf("%-10s %-30s %-18s %-10s %-10s", "Id", "Tên Sản Phẩm", "Giá: ", "Số lượng", "Nhà Sản Xuất\n");
            for (Chair chair : chairList) {
                if (chair.getQuantity() == search) {
                    count++;
                    System.out.printf("%-10s %-30s %-18s %-10s %-10s\n", chair.getProductID(), chair.getName(), formater.format(chair.getPrice()),
                            chair.getQuantity(), chair.getProvideName());
                }
            }
            showReturnSearch(count);

        } catch (Exception e) {
            System.out.println("Chưa hợp lệ... Mời nhập lại");
        }
    }

    public static void searchByName() {
        List<Chair> chairList = chairService.getItem();
        int count = 0;
        System.out.println();
        System.out.print("Nhập tên sản phẩm cần tìm kiếm : ");
        String search = scanner.nextLine();
        System.out.println("Kết quả tìm kiếm của từ khóa '" + search + "' là : ");
        search = search.toLowerCase();
        System.out.printf("%-8s %-20s %-8s %-20s %-20s \n", "ID", "TÊN SẢN PHẨM", "SỐ LƯỢNG", "GIÁ (VND)", "NHÀ SẢN XUẤT");
        for (Chair chair : chairList) {
            if (chair.getName().toLowerCase().contains(search)) {
                count++;
                System.out.printf("%-8s %-20s %-8s %-20s %-20s \n", chair.getProductID(), chair.getName(),
                        chair.getQuantity(), formater.format(chair.getPrice()), chair.getProvideName());
            }
        }

        showReturnSearch(count);
    }

    public static void searchByPrice() {
        List<Chair> chairList = chairService.getItem();
        int count = 0;
        System.out.println();
        System.out.print("Nhập tên sản phẩm cần tìm kiếm : ");
        double search = Double.parseDouble(scanner.nextLine());
        System.out.println("Kết quả tìm kiếm của từ khóa '" + search + "' là : ");
        System.out.printf("%-8s %-20s %-8s %-20s %-20s \n", "ID", "TÊN SẢN PHẨM", "SỐ LƯỢNG", "GIÁ (VND)", "NHÀ SẢN XUẤT");
        for (Chair chair : chairList) {
            if (chair.getPrice() == search) {
                count++;
                System.out.printf("%-8s %-20s %-8s %-20s %-20s \n", chair.getProductID(), chair.getName(),
                        chair.getQuantity(), formater.format(chair.getPrice()), chair.getProvideName());
            }
        }

        showReturnSearch(count);
    }

    public static void showReturnSearch(int count) {
        System.out.println("Có '" + count + "' sản phẩm được tìm thấy !");
        char press = ' ';
        boolean isChoice;
        System.out.println();
        do {
            System.out.print("Nhấn 'R' để về menu tìm kiếm !");
            try {
                press = scanner.nextLine().charAt(0);
            } catch (Exception e) {
                press = ' ';
            }
            switch (press) {
                case 'r':
                case 'R': {
                    SearchMenu.searchMenu();
                    isChoice = false;
                    break;
                }
                default:
                    isChoice = true;
            }
        } while (isChoice);
    }

}

