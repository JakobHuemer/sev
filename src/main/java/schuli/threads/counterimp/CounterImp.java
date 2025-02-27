package schuli.threads.counterimp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class CounterImp implements Runnable {

    private static int totalCount;
    static final int maxTotalCount = 100_000;
    private int selfCounter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while ( totalCount < maxTotalCount ) {
            lock.lock();
            if ( totalCount < maxTotalCount ) {
                selfCounter++;
                totalCount++;
            }
            lock.unlock();
        }
    }

    public int getSelfCounter() {
        return selfCounter;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    public int getMaxTotalCount() {
        return maxTotalCount;
    }

    public static void main( String[] args ) {

        Map<Thread, CounterImp> threads = new HashMap<>();

        for ( int i = 0; i < 10; i++ ) {
            var counter = new CounterImp();
            threads.put( new Thread( counter ), counter );
        }

        threads.keySet().forEach( Thread::start );

        for ( Thread thread : threads.keySet() ) {
            try {
                thread.join();
            } catch ( InterruptedException e ) {
                throw new RuntimeException( e );
            }
        }

        int sumOfSelfCounters = threads
                .values()
                .stream()
                .map( CounterImp::getSelfCounter )
                .reduce( Integer::sum ).get();

        threads
                .values()
                .forEach( c -> {
                    System.out.println( c.selfCounter );

                } );

        System.out.println(sumOfSelfCounters);
        System.out.println( CounterImp.maxTotalCount );

    }


}
