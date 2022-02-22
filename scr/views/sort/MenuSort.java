package views.sort;

import model.product.Chair;
import services.ChairService;
import services.sort.*;
import utils.file.TextFileUtil;
import utils.json.JacksonParser;
import views.manager.ChairView;
import views.manager.ManagerChairView;

import java.util.List;
import java.util.Scanner;
public class MenuSort {
    private static Scanner scanner = new Scanner(System.in);
    static ChairView chairView = new ChairView();
    static String path = "data/chair.json";
    static ChairService chairService = new ChairService();
    static List<Chair> chairsList;

    public MenuSort() {
        chairsList = chairService.getItem();
    }

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
        boolean flag = true;
        int choice;
        do {
            sortMenu();
            choice = Byte.parseByte(scanner.nextLine());
            switch (choice) {
                case 1:
                    showSortById();
                    break;
                case 2:
                    showSortByName();
                    break;
                case 3:
                    showSortByQuantity();
                    break;
                case 4:
                    showSortByPrice();
                    break;
                case 0:
                    ManagerChairView.create();
                    break;
                default:
                    System.out.println("Không hợp lệ, mời nhập lại");
                    flag = false;
            }
        } while (!flag);
    }

    public static void showSortByQuantity() {
        boolean flag = true;
        char choice = ' ';
        do {
            System.out.println("--------------------------------------------------------");
            System.out.println("|           SẮP XẾP THEO SỐ LƯỢNG SẢN PHẨM             |");
            System.out.println("--------------------------------------------------------");
            System.out.println("| 1. Theo thứ tự từ TĂNG DẦN                           |");
            System.out.println("| 2. Theo thứ tự từ GIẢM DẦN                           |");
            System.out.println("|                                         0. Quay lại  |");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            System.out.print("Chọn chức năng :");
            try {
                choice = scanner.nextLine().charAt(0);
            } catch (Exception e) {
                choice = ' ';
            }
            switch (choice) {
                case '1':
                    List<Chair> chairList = chairService.getItem();
                    System.out.println("Sắp xếp theo SỐ LƯỢNG TĂNG DẦN");
                    SortByQuantityASC sortByQuantityASC = new SortByQuantityASC();
                    chairList.sort(sortByQuantityASC);
                    String json = JacksonParser.INSTANCE.toJson(chairList);
                    TextFileUtil.writeFile(json, path);
                    chairView.show();
                    option();
                    break;
                case '2':
                    List<Chair> chairsList = chairService.getItem();
                    System.out.println("Sắp xếp theo SỐ LƯỢNG GIẢM DẦN");
                    SortByQuantityDESC sortByQuantityDESC = new SortByQuantityDESC();
                    chairsList.sort(sortByQuantityDESC);
                    String jsonX = JacksonParser.INSTANCE.toJson(chairsList);
                    TextFileUtil.writeFile(jsonX, path);
                    chairView.show();
                    option();
                    break;
                case '0':
                    ManagerChairView.create();
                    break;
                default:
                    System.out.println("Chọn lại !");
                    flag = false;
            }
        } while (!flag);
    }

    public static void showSortByPrice() {
        boolean flag = true;
        char choice = ' ';
        do {
            System.out.println("--------------------------------------------------------");
            System.out.println("|           SẮP XẾP THEO GIÁ SẢN PHẨM                  |");
            System.out.println("--------------------------------------------------------");
            System.out.println("| 1. Theo thứ tự từ TĂNG DẦN                           |");
            System.out.println("| 2. Theo thứ tự từ GIẢM DẦN                           |");
            System.out.println("|                                         0. Quay lại  |");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            System.out.print("Chọn chức năng :");
            try {
                choice = scanner.nextLine().charAt(0);
            } catch (Exception e) {
                choice = ' ';
            }
            switch (choice) {
                case '1':
                    List<Chair> chairList = chairService.getItem();
                    System.out.println("Sắp xếp theo GIÁ TĂNG DẦN");
                    SortByPriceASC sortByPriceASC = new SortByPriceASC();
                    chairList.sort(sortByPriceASC);
                    String json = JacksonParser.INSTANCE.toJson(chairList);
                    TextFileUtil.writeFile(json, path);
                    chairView.show();
                    option();
                    break;
                case '2':
                    List<Chair> chairsList = chairService.getItem();
                    System.out.println("Sắp xếp theo GIÁ GIẢM DẦN");
                    SortByPriceDESC sortByPriceDESC = new SortByPriceDESC();
                    chairsList.sort(sortByPriceDESC);
                    String jsonX = JacksonParser.INSTANCE.toJson(chairsList);
                    TextFileUtil.writeFile(jsonX, path);
                    chairView.show();
                    option();
                    break;
                case '0':
                    ManagerChairView.create();
                    break;
                default:
                    System.out.println("Chọn lại !");
                    flag = false;
            }
        } while (!flag);
    }

    public static void showSortByName() {
        boolean flag = true;
        char choice = ' ';
        do {
            System.out.println("--------------------------------------------------------");
            System.out.println("|           SẮP XẾP THEO TÊN SẢN PHẨM                  |");
            System.out.println("--------------------------------------------------------");
            System.out.println("| 1. Theo thứ tự tên TĂNG DẦN                          |");
            System.out.println("| 2. Theo thứ tự tên GIẢM DẦN                          |");
            System.out.println("|                                         0. Quay lại  |");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            System.out.print("Chọn chức năng :");
            try {
                choice = scanner.nextLine().charAt(0);
            } catch (Exception e) {
                choice = ' ';
            }
                switch (choice) {
                    case '1':
                        List<Chair> chairList = chairService.getItem();
                        System.out.println("Sắp xếp theo tên TĂNG DẦN");
                        SortByNameASC sortByNameASC = new SortByNameASC();
                        chairList.sort(sortByNameASC);
                        String json = JacksonParser.INSTANCE.toJson(chairList);
                        TextFileUtil.writeFile(json, path);
                        chairView.show();
                        option();
                        break;
                    case '2':
                        List<Chair> chairsList = chairService.getItem();
                        System.out.println("Sắp xếp theo tên GIẢM DẦN");
                        SortByNameDESC sortByNameDESC = new SortByNameDESC();
                        chairsList.sort(sortByNameDESC);
                        String jsonX = JacksonParser.INSTANCE.toJson(chairsList);
                        TextFileUtil.writeFile(jsonX, path);
                        chairView.show();
                        option();
                        break;
                    case '0':
                        ManagerChairView.create();
                        break;
                    default:
                        System.out.println("Chọn lại !");
                        flag = false;
                }
            }while (!flag);
        }

    public static void showSortById() {
        boolean flag = true;
        char choice = ' ';
        do {
            System.out.println("--------------------------------------------------------");
            System.out.println("|           SẮP XẾP THEO ID SẢN PHẨM                    |");
            System.out.println("--------------------------------------------------------");
            System.out.println("| 1. Theo thứ tự từ TĂNG DẦN                           |");
            System.out.println("| 2. Theo thứ tự từ GIẢM DẦN                           |");
            System.out.println("|                                         0. Quay lại  |");
            System.out.println("--------------------------------------------------------");
            System.out.println();
            System.out.print("Chọn chức năng :");
            try {
                choice = scanner.nextLine().charAt(0);
            } catch (Exception e) {
                choice = ' ';
            }
            switch (choice) {
                case '1':
                    List<Chair> chairList = chairService.getItem();
                    System.out.println("Sắp xếp theo ID TĂNG DẦN");
                    SortByIDASC sortByIDASC = new SortByIDASC();
                    chairList.sort(sortByIDASC);
                    String json = JacksonParser.INSTANCE.toJson(chairList);
                    TextFileUtil.writeFile(json, path);
                    chairView.show();
                    option();
                    break;
                case '2':
                    List<Chair> chairsList = chairService.getItem();
                    System.out.println("Sắp xếp theo ID GIẢM DẦN");
                    SortByIDDESC sortByIDDESC = new SortByIDDESC();
                    chairsList.sort(sortByIDDESC);
                    String jsonX = JacksonParser.INSTANCE.toJson(chairsList);
                    TextFileUtil.writeFile(jsonX, path);
                    chairView.show();
                    option();
                    break;
                case '0':
                    ManagerChairView.create();
                    break;
                default:
                    System.out.println("Chọn lại !");
                    flag = false;
            }
        } while (!flag);
        option();
    }
}
