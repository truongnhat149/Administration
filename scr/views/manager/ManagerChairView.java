package views.manager;
import views.Menu;

import java.util.Scanner;

public class ManagerChairView {
    private static Scanner scanner = new Scanner(System.in);

    public static void create() {
        int num;
        boolean flag = true;
        try {
            do {
                ChairView chairView = new ChairView();
                Menu.menuChair();
                num = Integer.parseInt(scanner.nextLine());
                switch (num) {
                    case 1:
                        chairView.add();
                        break;
                    case 2:
                        chairView.update();
                        break;
                    case 3:
                        SearchMenu.searchMenu();
                        break;
                    case 4:
                        chairView.show();
                        ManagerChairView.create();
                        break;
                    case 5:
                        chairView.remove();
                        break;
                    case 9:
                        Menu.startMenu();
                        break;
                    case 0:
                        Menu.exit();
                        System.exit(0);
                    default:
                        System.out.println("Chưa hợp lệ!! Mời nhập lại");
                        flag = false;
                }
            } while (!flag);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
