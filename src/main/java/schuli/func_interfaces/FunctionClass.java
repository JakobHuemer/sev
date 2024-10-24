package schuli.func_interfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionClass {
    public static void main( String[] args ) {
        Function<Integer, Integer> addTwo = x -> x + 2;
        Function<Integer, Integer> timesTwo = x -> x * 2;
        // tales two args
        BiFunction<Integer, Integer, String> add = ( n1, n2 ) -> String.format( "%d + %d = %d", n1, n2, n1 + n2 );

        int result1 = addTwo.apply( 5 );
        int result2 = timesTwo.apply( 5 );
        // first timesTwo then addTwo
        int result3 = timesTwo.andThen( addTwo ).apply( 5 );

        // first addTwo then timesTwo
        int result4 = timesTwo.compose( addTwo ).apply( 5 );

        System.out.println( result1 );
        System.out.println( result2 );
        System.out.println( result3 );
        System.out.println( result4 );

        System.out.println( add.apply( 2, 5 ) );
    }
}
