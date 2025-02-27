package just_writing_code;

import java.util.Arrays;

public class Algos {
    public static void main( String[] args ) {

        int[] arr = new int[]{ 1, 6, 8, 56, 48, 15, 48, 456, 87, 6, 89, 74, 63, 5, 8, 7, 6 };
        Arrays.sort( arr );
        System.out.println( Arrays.toString( arr ) );


    }

    public static void bubbleSort( int[] toSort ) {
        for ( int i = 0; i < toSort.length; i++ ) {
            for ( int j = 0; j < toSort.length - i - 1; j++ ) {
                if ( toSort[ i ] > toSort[ i + 1 ] ) {
                    // swap
                    int temp = toSort[ i ];
                    toSort[ i ] = toSort[ i + 1 ];
                    toSort[ i + 1 ] = toSort[ i ];
                }
            }
        }
    }
}
