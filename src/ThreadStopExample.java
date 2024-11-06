public class ThreadStopExample {
    public static class StoppedRunnable implements Runnable{
        private boolean isStopRequested = false;

        public synchronized void requestStop(){
            this.isStopRequested = true;
        }

        private void sleep(long mills){
            try{
                Thread.sleep(mills);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            System.out.println("StoppedRunnable running");
            while(!isStopRequested){
                sleep(1000);
                System.out.println("...");
            }
            System.out.println("StoppedRunnable finished");
        }
    }

    public static void main(String[] args){
        StoppedRunnable stoppedRunnable = new StoppedRunnable();
        Thread stoppedRunnableThread = new Thread(stoppedRunnable);
        stoppedRunnableThread.start();

        try{
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("requesting stop");
        stoppedRunnable.requestStop();
        System.out.println("stop requested");
    }
}
