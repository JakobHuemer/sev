package schuli.streams;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Main {
    public static void main( String[] args ) {
        var l = new ArrayList<String>();

        l.add( "Albert" );
        l.add( "Robert" );
        l.add( "Johanness" );

        System.out.println( l.toString() );

        l.stream()
                .reduce( ( i, s ) -> i + ", " + s )
                .ifPresent( s -> System.out.printf( "'%s'\n", s ) );


        // max
        l.stream()
                .reduce( ( i, j ) -> i.compareTo( j ) < 0 ? i : j )
                .ifPresent( System.out::println );

        System.out.println( l.stream()
                .mapToDouble( s -> s.chars().sum() )
                .sum() );

        Predicate<String> p = s -> s.length() < 2   ;

        System.out.println( l.stream()
                .allMatch( p ) );

        System.out.println( l.stream()
                .anyMatch( p ) );

        System.out.println( l.stream()
                .noneMatch( p ) );
    }
}
