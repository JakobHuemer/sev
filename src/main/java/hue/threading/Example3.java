package hue.threading;

import java.io.IOException;
import java.time.Duration;

public class Example3 implements Runnable {

    private static int threadNumber = 1;
    private static Thread currentThread;
    private static volatile boolean isRunning = false;

    public static void main( String[] args ) {
        // s - start thread
        // p - stop thread
        // e - exit program

        char input = ' ';

        do {

            try {
                input = (char) System.in.read();
            } catch ( IOException e ) {
                throw new RuntimeException( e );
            }

            switch ( input ) {
                case 's' -> start();
                case 'p' -> stop();
            }

        } while ( input != 'e' );
    }

    static void start() {
        currentThread = new Thread( new Example3() );
        currentThread.setName( "Thread Nr. " + threadNumber++ );
        isRunning = true;
        currentThread.start();
    }


    static void stop() {
        if ( currentThread != null ) {
            isRunning = false;
            currentThread = null;
        }
    }


    @Override
    public void run() {
        while ( isRunning ) {
            System.out.println( Thread.currentThread().getName() );
            try {
                Thread.sleep( Duration.ofSeconds( 2 ) );
            } catch ( InterruptedException e ) {
                throw new RuntimeException( e );
            }
        }
    }
}


