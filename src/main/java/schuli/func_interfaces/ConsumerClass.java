package schuli.func_interfaces;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerClass {
    public static void main( String[] args ) {


        Consumer<String> prettyPrint = ( s ) -> {
            System.out.println( "----------------------------" );
            System.out.println( s );
            System.out.println( "----------------------------" );
        };

        prettyPrint.accept( "Hello world" );



    }
}
