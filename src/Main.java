//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static class MyThread extends Thread{
        public void run(){
            System.out.println("MyThread running");
            System.out.println("MyThread finished");
        }
    }

    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("MyRunnable running");
            System.out.println("MyRunnable finished");
        }
    }

    public static void main(String[] args) {
        //example 1
        MyThread myThread = new MyThread();
        myThread.start();

        //example 2
        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        //example 3
        Runnable runnableInstans = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnableInstans running");
                System.out.println("runnableInstans finished");
            }
        };

        Thread runnableInstansThread = new Thread(runnableInstans);
        runnableInstansThread.start();

        //example 4
        Runnable runnableLambda = () ->{
            System.out.println("runnableLambda running");
            System.out.println("runnableLambda finished");
        };

        Thread runnableLambdaThread = new Thread(runnableInstans);
        runnableLambdaThread.start();

        //example 5
        Runnable runnableThreadName = () ->{
            String threadName = Thread.currentThread().getName();
            System.out.println(String.format("thread name is %s", threadName));
        };

        Thread runnableThreadNameThread1 = new Thread(runnableThreadName, "my own name 1");
        runnableThreadNameThread1.start();

        Thread runnableThreadNameThread2 = new Thread(runnableThreadName, "my own name 2");
        runnableThreadNameThread2.start();

        //example 6
        Runnable runnableSleep = () ->{
            String threadName = Thread.currentThread().getName();
            System.out.println(String.format("%s running", threadName));
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println(String.format("%s finished", threadName));
        };

        Thread runnableSleepThread = new Thread(runnableSleep, "sleep thread");
        runnableSleepThread.start();
    }


}