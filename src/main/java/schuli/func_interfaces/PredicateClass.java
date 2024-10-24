package schuli.func_interfaces;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateClass {
    public static void main( String[] args ) {

        // for tests

        List<String> l = new LinkedList<>();
        l.add( "Martin" );
        l.add( "Wagner" );
        l.add( "Tomas" );
        l.add( "Willi" );


        Predicate<String> test = ( s ) -> s.startsWith( "W" );
        BiPredicate<String, String> firstTwoCharsSame = ( s1, s2 ) -> s1.charAt( 0 ) == s2.charAt( 0 );

        System.out.println( test.test( "Hello" ) );
        System.out.println( test.test( "Wer" ) );
        System.out.println( test.test( "Hat" ) );
        System.out.println( test.test( "Gefragt" ) );

        System.out.println("----------------------");

        System.out.println( l.stream().allMatch( test ) );
        System.out.println( l.stream().anyMatch( test ) );


        System.out.println("----------------------");

        System.out.println( firstTwoCharsSame.test( l.get( 1 ), l.get( 3 ) ) );
        System.out.println( firstTwoCharsSame.test( l.get( 1 ), l.get( 2 ) ) );



    }
}
