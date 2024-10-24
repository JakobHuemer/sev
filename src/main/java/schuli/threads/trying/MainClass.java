package schuli.threads.trying;

public class MainClass {
    public static void main( String[] args ) {
        MyThread thread = new MyThread();
        System.out.println("Hello world");
        thread.start();


        MyRunnable myRunnable = new MyRunnable();
        Thread thread1 = new Thread( myRunnable );
        thread1.start();

    }
}
