package schuli.threads.trying;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep( 1000 );
        } catch ( InterruptedException e ) {
            throw new RuntimeException( e );
        }

        System.out.println( "Hello world" );
    }
}
