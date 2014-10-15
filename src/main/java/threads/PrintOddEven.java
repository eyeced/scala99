package threads;

/**
 *
 * Created by abhinav on 29/7/14.
 */
public class PrintOddEven {

    private static class PrintNum implements Runnable {
        public volatile static boolean isEven = true;
        private Object lock;
        private int num;

        public PrintNum(int num, Object lock) {
            this.lock = lock;
            this.num = num;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (isEven == (num % 2 == 0)) {
                        System.out.println(Thread.currentThread().getName() + " --- " + num);
                        num += 2;
                        isEven = !(num % 2 == 0);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        PrintNum p1 = new PrintNum(0, lock);
        PrintNum p2 = new PrintNum(1, lock);

        Thread t1 = new Thread(p1, "Even thread");
        Thread t2 = new Thread(p2, "Odd Thread");
        t1.start();
        t2.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
