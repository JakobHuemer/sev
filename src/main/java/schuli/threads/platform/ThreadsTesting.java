package schuli.threads.platform;

public class ThreadsTesting {
    public static void main( String[] args ) {
        Thread.ofPlatform().start( new Thread( () -> {
            System.out.println( "Hello from platform thread" + Thread.currentThread().getName() );
        } ) );

    }
}
