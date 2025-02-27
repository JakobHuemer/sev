package hue.threading;

public class Example1 {
    public static void main( String[] args ) {

        withRunnable();

    }

    private static void withThread() {
        var thread1 = new PrintThread("Hip", 10);
        var thread2 = new PrintThread( "HOP", 10 * 5 );

        thread1.start();
        thread2.start();

    }


    private static void withRunnable() {

        var thread1 = new Thread( new PrintRunnable( "Hip", 10 ) );
        var thread2 = new Thread( new PrintRunnable( "HOP", 10 * 5 ) );

        thread1.start();
        thread2.start();
    }
}


class PrintThread extends Thread {

    private final String toPrint;
    private final int sleepTime;

    public PrintThread( String toPrint, int sleepTime ) {
        this.toPrint = toPrint;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        while ( true ) {
            System.out.print( toPrint + " " );
            try {
                Thread.sleep( sleepTime );
            } catch ( InterruptedException e ) {
                throw new RuntimeException( e );
            }

        }
    }
}

class PrintRunnable implements Runnable {

    private final String toPrint;
    private final int sleepTime;

    public PrintRunnable( String toPrint, int sleepTime ) {
        this.toPrint = toPrint;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        while ( true ) {
            System.out.print( toPrint + " " );
            try {
                Thread.sleep( sleepTime );
            } catch ( InterruptedException e ) {
                throw new RuntimeException( e );
            }

        }
    }
}