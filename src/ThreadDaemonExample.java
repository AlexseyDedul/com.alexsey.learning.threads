public class ThreadDaemonExample {

    public static void sleep(long mills){
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        Runnable runnable = () ->{
            System.out.println("Start");
            while(true){
                sleep(1000);
                System.out.println("Running daemon");
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        sleep(3100);

        Runnable runnableJoin = () ->{
            System.out.println("Start");
            for (int i = 0; i < 5; i++) {
                sleep(1000);
                System.out.println("Running join");
            }
        };

        Thread runnableJoinThread = new Thread(runnableJoin);
        runnableJoinThread.setDaemon(true);
        runnableJoinThread.start();

        try {
            runnableJoinThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
