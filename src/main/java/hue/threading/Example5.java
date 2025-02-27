package hue.threading;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.logging.*;


class Test {

    private static final int ANZAHL_THREADS = 5;
    private static final int SEKUNDEN = 10;

    public static void main( String[] args ) {
        var konto = new Konto();

        var map = new HashMap<Thread, Manager>();

        for ( int i = 0; i < ANZAHL_THREADS; i++ ) {
            var m = new Manager( konto );
            var t = new Thread( m );
            t.start();
            map.put( t, m );
        }

        System.out.println( "main: Warte " + SEKUNDEN + " Sekunden ..." );
        try {
            Thread.sleep( Duration.ofSeconds( SEKUNDEN ) );
        } catch ( InterruptedException e ) {
            throw new RuntimeException( e );
        }
        map.keySet()
                .forEach( Thread::interrupt );


        map.keySet().forEach( t -> {
            try {
                t.join();
            } catch ( InterruptedException e ) {
                throw new RuntimeException( e );
            }
        } );

        long sumOfSums = map
                .values()
                .stream()
                .map( Manager::getSumme )
                .reduce( Long::sum )
                .orElseThrow();

        long summOfTransactions = map
                .values()
                .stream()
                .map( Manager::getTransaktionen )
                .reduce( Long::sum )
                .orElseThrow();


        System.out.println( "Gesamtanzahl der Transaktionen: " + summOfTransactions );
        System.out.println( "Gesamtsumme: " + sumOfSums );
        System.out.println( "Saldo: " + konto.getSaldo() );

    }
}


class Konto {
    private long saldo = 0;


    private static final Logger LOG = Logger.getLogger(Konto.class.getSimpleName());

    static {
        try {
            Handler fileHandler = new FileHandler( "KontoLogger.txt" );
            fileHandler.setFormatter( new SimpleFormatter() );
            LOG.addHandler( fileHandler );
            LOG.setUseParentHandlers( false );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }


    public synchronized void add( long value ) {
        var localSaldo = getSaldo();
        try {
            Thread.sleep( 10 );
        } catch ( InterruptedException e ) {
            Thread.currentThread().interrupt();
            LOG.log( Level.SEVERE, Thread.currentThread().getName() + " Konto.add() interrupted" );
        }
        localSaldo += value;
        saldo = localSaldo;
    }

    public long getSaldo() {
        return saldo;
    }
}

class Manager implements Runnable {

    private final Konto konto;
    private long summe = 0;
    private long transaktionen;

    private boolean isRunning = true;

    private static final Logger LOG = Logger.getLogger(Manager.class.getSimpleName());

    static {
        try {
            Handler fileHandler = new FileHandler( "ManagerLogger.txt" );
            fileHandler.setFormatter( new SimpleFormatter() );
            LOG.addHandler( fileHandler );
            LOG.setUseParentHandlers( false );
        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }


    public Manager( Konto konto ) {
        this.konto = konto;
    }

    @Override
    public void run() {
        while ( isRunning ) {
            long toAdd = (long) Math.ceil( Math.random() * 10 );
            konto.add( toAdd );
            transaktionen++;
            summe += toAdd;
            try {
                Thread.sleep( 2 );
            } catch ( InterruptedException e ) {
                Thread.currentThread().interrupt();
                isRunning = false;
                LOG.log( Level.SEVERE, Thread.currentThread().getName() + " Manager.run() interrupted" );
            }
        }

    }

    public long getSumme() {
        return summe;
    }

    public long getTransaktionen() {
        return transaktionen;
    }
}

public class Example5 {

}