package schuli.threads.counter;

import java.util.LinkedList;
import java.util.List;

public class BadCounter {
    public static void main( String[] args ) {
        Box<Integer> counter = new Box<>( 0 );
        final int countUpTo = 1_000_000;

        List<CounterThread> counterThreadList = new LinkedList<>();
        List<Thread> threads = new LinkedList<>();

        System.out.println( "Counter is at " + counter + " and will count up to " + countUpTo );

        for ( int i = 0; i < 10; i++ ) {
            CounterThread counterThread = new CounterThread( counter, countUpTo );
            counterThreadList.add( counterThread );
            Thread thread = new Thread( counterThread );
            threads.add( thread );
            thread.start();
        }

        // wait for every thread in threads
        for ( var thread : threads ) {
            try {
                thread.join();
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }

        System.out.println( "Counter after counting is at " + counter.get() );

        int allIncrements = 0;

        for ( var counterThread : counterThreadList ) {
            System.out.println( "Counter counted " + counterThread.getIncrementCounter() + " times!" );
            allIncrements += counterThread.getIncrementCounter();
        }


        System.out.println( "All Threads together counted " + allIncrements + " times!" );
        System.out.println( ( allIncrements - countUpTo + " times more than necessary" ) );


    }
}


class CounterThread implements Runnable {

    private final Box<Integer> counter;
    private final int toValue;
    private int incrementCounter = 0;

    public CounterThread( Box<Integer> counter, int toValue ) {
        this.counter = counter;
        this.toValue = toValue;
    }

    @Override

    public void run() {

        var v = counter.get();
        while ( v < toValue ) {
            counter.set( v + 1 );
            incrementCounter++;
            v = counter.get();
        }
    }

    public int getIncrementCounter() {
        return incrementCounter;
    }
}

class Box<T> {
    private T value;

    public Box( T value ) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set( T value ) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}