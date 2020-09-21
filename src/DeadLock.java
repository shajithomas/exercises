/*
This should run and stay deadlocked until we kill the program
 */
class DeadLock {
    public static void main(String[] args){
        String res1 = "lock1";
        String res2 = "lock2";

        Thread t1 = new Thread(() -> {
            synchronized (res1) {
                System.out.println("res1 locked in Thread1");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (res2) {
                    System.out.println("res2 locked in thread1");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (res2) {
                System.out.println("res2 locked in thread2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (res1) {
                    System.out.println("res1 locked in thread2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

