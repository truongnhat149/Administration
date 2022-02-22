package services.thread;

public class Loading {
    synchronized public static void loading() {
        System.out.print("Loading");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(". ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 20; i++) {
            try {
                System.out.println("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("WELCOME SHOP-MALL");
    }
}
