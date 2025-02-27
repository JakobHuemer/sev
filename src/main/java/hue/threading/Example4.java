package hue.threading;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Example4 {

    private static final String FILENAME = "logs.txt";

    public static void main( String[] args ) {

        try ( var pw = new PrintWriter( new File( FILENAME ) ) ) {

            var logFileClass = new LogFile( pw );

            var t1 = new MyThread( logFileClass, 4 );
            var t2 = new MyThread( logFileClass, 10 );

            t1.start();
            System.out.println("Thread " + t1.getName() + " gestarted");
            t2.start();
            System.out.println("Thread " + t2.getName() + " gestarted");

            System.out.println( "Warte auf Beendung beider Threads ..." );

            try {
                t1.join();
                t2.join();
            } catch ( InterruptedException e ) {
                throw new RuntimeException( e );
            }

            System.out.println("Ende");

        } catch ( FileNotFoundException e ) {
            throw new RuntimeException( e );
        }

    }
}


class LogFile {

    private final PrintWriter pw;

    public LogFile( PrintWriter pw ) {
        this.pw = pw;
    }

    public synchronized void writeLine( String msg ) {
        pw.println( DateTimeFormatter.ofPattern( "dd.MM.yyyy HH:mm:ss" ).format( LocalDateTime.now() ) + " " + msg );
    }
}

class MyThread extends Thread {
    private final LogFile lf;
    private int linesToWrite;

    public MyThread( LogFile lf, int linesToWrite ) {
        this.lf = lf;
        this.linesToWrite = linesToWrite;
    }

    @Override
    public void run() {
        while ( linesToWrite > 0 ) {
            linesToWrite--;
            lf.writeLine( this.getName() );
            try {
                Thread.sleep( (long) (Math.random() * 1000) );
            } catch ( InterruptedException e ) {
                throw new RuntimeException( e );
            }
        }
    }
}