package views.manager;

import model.order.Order;
import model.order.OrderItem;
import model.product.Chair;
import services.ChairService;
import services.OderService;
import services.OrderChairService;
import services.tools.IItemService;
import services.tools.IOderService;
import services.tools.IOrderItemService;
import utils.Validation;
import views.Menu;
import views.manager.ChairView;
import views.manager.ManagerOrderView;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    private IItemService itemService;
    private IOderService oderService;
    private IOrderItemService orderItemService;
    Scanner scanner = new Scanner(System.in);
    DecimalFormat format = new DecimalFormat("###,###,###" + " vnđ");

    public OrderView() {
        itemService = new ChairService();
        oderService = new OderService();
        orderItemService = new OrderChairService();
    }

    public OrderItem addOrderItems(long orderID) {
        orderItemService.getOrderItem();
        ChairView chairView = new ChairView();
        chairView.show();
        long id = System.currentTimeMillis() / 1000;
        long chairID = System.currentTimeMillis() / 1000;
        System.out.printf("Nhập id sản phẩm  \n=> \t");
        int productID = Integer.parseInt(scanner.nextLine());
        while (!itemService.exists(productID)) {
            System.out.println("Id không tồn tại ");
            System.out.printf("Nhập id sản phẩm  \n=> \t");
            productID = Integer.parseInt(scanner.nextLine());
        }

        Chair chair = itemService.getChairByID(productID);
        double price = chair.getPrice();
        int oldQuantity = chair.getQuantity();
        System.out.println("Nhập số lượng \n=> \t");
        int quantity = Integer.parseInt(scanner.nextLine());
        while (!checkQuantityChair(chair, quantity)) {
            System.out.println("Vượt quá số lượng! Mời nhập lại");
            System.out.println("Nhập số lượng \n=> \t");
            quantity = Integer.parseInt(scanner.nextLine());
        }
        String chairName = chair.getName();
        double total = quantity * price;
        int currentQuantity = oldQuantity - quantity;
        chair.setQuantity(currentQuantity);
        itemService.update(chair);
        OrderItem orderItem = new OrderItem(id, orderID, chairID, chairName, price, quantity, total);
        return orderItem;
    }

    public boolean checkQuantityChair(Chair chair, int quantity) {
        if (quantity <= chair.getQuantity()) {
            return true;
        } else
            return false;
    }

    public void addOrder() {
        try {
            oderService.getOrders();
            long orderID = System.currentTimeMillis() / 1000;
            System.out.print("Nhập Họ và tên\t (vd: Code Gym [không dấu]) \n => \t");
            String name = scanner.nextLine();
            while (!Validation.isNameValid(name)) {
                System.out.println("Tên: " + name + " chưa hợp lệ. Mời Nhập lại (VIẾT HOA chữ cái đầu)");
                System.out.print("Nhập tên (vd: Thien Hue) \n => \t");
                name = scanner.nextLine();
            }

            System.out.print("Nhập số điện thoại \n => \t ");
            String phone = scanner.nextLine();
            while (!Validation.isPhoneValid(phone)) {
                System.out.print("Số " + phone + " chưa hợp lệ . Mời nhập lại (Số điện thoại bắt đầu bằng số 0, số thứ 2 không được là số 0) \n " +
                        " \t (SĐT từ 10-11 số) (vd: 0862955026) \n => \t");
                phone = scanner.nextLine();
            }

            System.out.print("Nhập địa chỉ \n => \t");
            String address = scanner.nextLine();
            while (!Validation.isAddressValid(address)) {
                System.out.println("Địa chỉ " + address + " chưa hợp lệ. Mời nhập lại (Địa chỉ bắt đầu bằng số, ngăn cách nhau bởi dấu ', / -') \n " +
                        "\t (vd: 26 Nguyen Tri Phuong,Hue)");
                address = scanner.nextLine();
            }
            OrderItem orderItem = addOrderItems(orderID);
            Order order = new Order(orderID, name, phone, address);
            orderItemService.add(orderItem);
            oderService.add(order);
            System.out.println("Tạo đơn hàng thành công!!!");

            boolean flag = true;
            do {
                Menu.inputOrder();
                String choice = scanner.nextLine();
                switch (choice) {
                    case "c":
                        addOrder();
                        break;
                    case "b":
                        ManagerOrderView.start();
                        break;
                    case "p":
                        showPaymentInfo(orderItem, order);
                        break;
                    case "e":
                        Menu.exit();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Mời nhập lại !!!! ");
                        flag = false;
                }
            } while (!flag);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Nhập sai! mời nhập lại");
        }
    }

    public void showPaymentInfo(OrderItem orderItem, Order order) {
        try {
            System.out.println("-------------------------------------------------------------" +
                    "HOÁ ĐƠN--------------------------------------------------------------------");
            System.out.printf("|%-11s %-11s %-10s %-20s %-15s %-10s %-16s %-35s\n|",
                    "Id", "OrderID", "ChairID", "Tên Sản phẩm", "Giá", "Số lượng", "Tổng ", "Địa chỉ");
            System.out.printf("%-11s %-11s %-10s %-20s %-15s %-10s %-16s %-35s\n|", order.getOrderID(), orderItem.getOrderID(),
                    orderItem.getChairID(), orderItem.getChairName(), format.format(orderItem.getPrice()), orderItem.getQuantity(),
                    format.format(orderItem.getTotal()), order.getAddress());
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");

            boolean flag = true;
            do {
                System.out.print("Nhấn 'b' để quay lại \nNhấn 'e' để thoát chương trình \n=>\t");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "b":
                        ManagerOrderView.start();
                        break;
                    case "e":
                        Menu.exit();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Chưa hợp lệ!!! mời nhập lại");
                        flag = false;
                }
            } while (!flag);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }


    public void showAllOrder() {
        List<Order> orderList = oderService.getOrders();
        List<OrderItem> orderItems = orderItemService.getOrderItem();
        OrderItem newOI = new OrderItem();
        try {
            System.out.println("----------------------------------------------------------LIST ORDER--------------------------------------------------------------------");
            System.out.println("|                                                                                                                                      |");
            System.out.printf("|%-12s %-12s %-12s %-25s %-15s %-8s %-15s %-15s\n",
                    "Id", "OrderID", "ChairID", "Tên Sản phẩm", "Giá", "Số lượng", "Tổng", "Địa chỉ");
            for (Order order : orderList) {
                for (OrderItem orderItem : orderItems) {
                    if (orderItem.getOrderID() == order.getOrderID()) {
                        newOI = orderItem;
                        break;
                    }
                }
                System.out.printf("|%-12s %-12s %-12s %-25s %-15s %-8s %-15s %-15s\n", order.getOrderID(), newOI.getOrderID(),
                        newOI.getChairID(), newOI.getChairName(), format.format(newOI.getPrice()), newOI.getQuantity(),
                        format.format(newOI.getTotal()), order.getAddress());
            }
            System.out.println("|                                                                                                                                      |");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
            boolean flag = true;
            do {
                System.out.print("\tNhấn 'b' để quay lại \n\tNhấn 'e' để thoát chương trình \n\t=> \t");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "b":
                        ManagerOrderView.start();
                        break;
                    case "e":
                        Menu.exit();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Chưa hợp lệ, mời nhập lại");
                        flag = false;
                }
            } while (!flag);
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}
