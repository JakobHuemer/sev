package schuli.threads.trying;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for ( int i = 0; i <5; i++ ) {
            System.out.println( "This is the " + (i + 1) + ". run!" );
            try {
                Thread.sleep( 400 );
            } catch ( InterruptedException e ) {
                throw new RuntimeException( e );
            }

        }
    }
}
