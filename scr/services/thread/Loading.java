package services.thread;

public class Loading {
    synchronized public static void loading() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(". ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
