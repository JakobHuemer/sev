package schuli.threads.better;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main( String[] args ) throws InterruptedException {
        List<String> list = new ArrayList<>();
        System.out.println("Fill list");

        ThreadMaker.runInBackground(() -> {
            for ( int i = 0; i < 1000; i++ ) {
                String string = "Doggy";
                list.add( string );
            }
        });


        Thread.sleep( 500 );
        for ( String s : list ) {
            System.out.println( s );
        }

        int i = ( new int[ 2 ] )[ 2 ];

    }
}
