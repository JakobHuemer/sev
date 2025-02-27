package schuli.threads.better;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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


        Thread.sleep( 0, 3 );
        int count = 0;
        list.getLast();
        for ( String s : list ) {
            System.out.println( s );
            count++;
        }

        System.out.println(count);

        var unique = list.stream().distinct().toList();

    }
}
