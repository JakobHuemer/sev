package schuli.threads.better;

public class ThreadMaker {
    public static void runInBackground( Runnable runnable ) {
        Thread thread = new Thread( runnable );
        thread.start();
    }
}
