package views.manager;

import model.product.Chair;
import services.ChairService;
import utils.Validation;
import views.Menu;
import views.manager.ManagerChairView;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class ChairView {
    private ChairService chairService = new ChairService();
    private Scanner scanner = new Scanner(System.in);
    private DecimalFormat decimalFormat = new DecimalFormat("###,###,###" + " vnđ");

    public void add() {
        chairService.getItem();
        System.out.println("Nhập id sản phẩm");
        System.out.printf("=> \t ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (chairService.exists(id)) {
            System.out.println("ID tồn tại, mời nhập lại");
            add();
        } else {
            System.out.print("Nhập tên sản phẩm\n=> \t");
            String nameProduct = scanner.nextLine();
            while (!Validation.isNameProductValid(nameProduct)) {
                System.out.println("Tên sản phẩm phải bắt đầu bằng ghế (vd: Ghe Massage)");
                nameProduct = scanner.nextLine();
            }
            System.out.println("Nhập giá sản phẩm");
            System.out.printf("=> \t ");
            double price;
            do {
                price  = Double.parseDouble(scanner.nextLine());
                if (!(price > 10000000 && price < 1000000000)) {
                    System.out.print("Lỗi Nhập Giá!!! Mời nhập lại \n Giá tiền phải nằm trong khoảng từ 10tr đến 1 tỷ\n => \t");
                    price = Double.parseDouble(scanner.nextLine());
                }
            } while (!(price > 10000000 && price < 1000000000));

            System.out.print("Nhập số lượng (Giới hạn không quá 100)\n=> \t");
            int quantity;
            do {
                quantity = scanner.nextInt();
                if (!(quantity > 0 && quantity <= 99)) {
                    System.out.println("Số lượng không được quá 99");
                    System.out.print("=> \t ");
                }
            } while (!(quantity > 0 && quantity <= 99));
            System.out.print("Nhập thông tin nhà sản xuất \n=> \t ");
            scanner.nextLine();
            String provider = scanner.nextLine();
            Chair chair = new Chair(id, nameProduct, price, quantity, provider);
            chairService.addItem(chair);
            System.out.println("Thêm thành công!!!");
        }
        boolean flag = true;
        do {
            System.out.printf(" Nhấn 'a' để thêm sản phẩm \n Nhấn 'b' để quay lại \n Nhấn 'e' để thoát \n");
            System.out.print("=> \t ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "a":
                    add();
                    break;
                case "b":
                    ManagerChairView.create();
                    break;
                case "e":
                    Menu.exit();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    flag = false;
            }
        } while (!flag);
    }

    public void update() {
        show();
        System.out.print("Nhập ID cần sửa\n=> \t ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (chairService.exists(id)) {
                Menu.inputUpdate();
                boolean is = true;
                do {
                    try {
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                inputPrice(id);
                                break;
                            case 2:
                                inputQuantity(id);
                                break;
                            case 3:
                                inputProvider(id);
                                break;
                            case 4:
                                ManagerChairView.create();
                                break;
                            default:
                                System.out.print("Chưa hợp lệ!! Mời Nhập Lại\n");
                                is = false;
                        }
                    } catch (Exception e) {
                        // Nếu gặp lỗi! Cho nhập lại
                        update();
                    }
                } while (!is);
                boolean flag = true;
                do {
                    System.out.print("Nhấn 'c' để tiếp tục cập nhật \nNhấn 'b' để quay lại \nNhấn 'e' để thoát... \n=> \t");
                    String chon = scanner.nextLine();
                    switch (chon) {
                        case "c":
                            update();
                            break;
                        case "b":
                            ManagerChairView.create();
                            break;
                        case "e":
                            Menu.exit();
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Mời Nhập Lại");
                            flag = false;
                    }
                } while (!flag);
            } else {
                System.out.println("Mời Nhập Lại");
                update();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show() {
        List<Chair> chairList = chairService.getItem();
        System.out.println("-----------------------------------------" +
                "DANH SÁCH SẢN PHẨM----------------------" +
                "---------------------");
        System.out.printf("%-10s %-30s %-20s %-10s %-20s", "Id", "Tên Sản Phẩm", "Giá: ", "Số lượng", "Nhà Sản Xuất");
        System.out.println(" ");
        for (Chair chair : chairList) {
            System.out.printf("%-10s %-30s %-20s %-10s %-20s\n", chair.getProductID(), chair.getName(), decimalFormat.format(chair.getPrice()),
                    chair.getQuantity(), chair.getProvideName());
        }
        System.out.println("------------------------------------------------------------------------------------------------------\n");
    }

    public void showProduct() {
        show();
        boolean flag = true;
        do {
            System.out.println("=========================================================");
            System.out.println("|            Nhấn 'b' để trở lại                        |");
            System.out.println("|            Nhấn 'e| để thoát chương trình             |");
            System.out.println("=========================================================");
            System.out.printf(" => \t");
            String choice = scanner.nextLine();
            try {
                switch (choice) {
                    case "b":
                        ManagerChairView.create();
                        break;
                    case "e":
                        Menu.exit();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Mời Nhập Lại");
                        flag = false;
                }
            } catch (Exception e) {
                System.out.println("Chưa Hợp Lệ!!! Mời Nhập Lại");
            }
        } while (!flag);
    }

    public void inputPrice(int id) {
        Chair chair = chairService.getChairByID(id);
        System.out.printf("Nhập giá \n=> \t");
        double price = Double.parseDouble(scanner.nextLine());
        chair.setPrice(price);
        chairService.update(chair);
        System.out.println("Cập nhật thành công!!!");
    }

    public void inputQuantity(int id) {
        Chair chair = chairService.getChairByID(id);
        System.out.print("Nhập số lượng \n=> \t");
        int quantity = Integer.parseInt(scanner.nextLine());
        chair.setQuantity(quantity);
        chairService.update(chair);
        System.out.println("Cập nhật thành công!!!");
    }

    public void inputProvider(int id) {
        Chair chair = chairService.getChairByID(id);
        System.out.print("Nhập tên nhà sản xuất \n=> \t");
        String provide = scanner.nextLine();
        chair.setProvideName(provide);
        chairService.update(chair);
        System.out.println("Cập nhật thành công!!!");
    }

    public void remove() {
        show();
        chairService.getItem();
        System.out.printf("Nhập id sản phẩm \n=> \t");
        int id = Integer.parseInt(scanner.nextLine());
        Chair chair = chairService.getChairByID(id);
        if (chair != null) {
            boolean check = true;
            Menu.removeConfirm();
            String chon = scanner.nextLine();
            try {
                switch (chon) {
                    case "y":
                        chairService.remove(chair.getProductID());
                        System.out.println("Xóa thành công!!!");
                        do {
                            System.out.println("=====================================");
                            System.out.println("|       Nhấn '1' để quay lại        |");
                            System.out.println("|       Nhấn '2' để thoát           |");
                            System.out.println("=====================================");
                            System.out.printf("=> \t");
                            byte choice = Byte.parseByte(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    ManagerChairView.create();
                                    break;
                                case 2:
                                    Menu.exit();
                                    break;
                                default:
                                    System.out.println("\t Nhập lại!!! ");
                                    check = false;
                            }
                        } while (!check);
                        break;
                    case "b":
                        ManagerChairView.create();
                        break;
                    default:
                        System.out.println("Mời Nhập Lại!!! ");
                }
            } catch (Exception e) {
                System.out.println("Chưa hợp lệ!!! Mời Nhập Lại");
            }
        }
    }

}
