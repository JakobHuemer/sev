package wdhl.lego.searching;

import java.util.Arrays;


public class BinarySearch {
    public static void main( String[] args ) {
        int[] arr = new int[ 10 ];

        final int SEARCH_NUMBER = (int) Math.floor( Math.random() * 20 );

        for( int i = 0; i < arr.length; i++ ) {
            int num;
            do {
                num = (int) Math.floor( Math.random() * 20 );
            } while( num == SEARCH_NUMBER );
            arr[ i ] = num;
        }

        arr[ (int) Math.floor( Math.random() * arr.length ) ] = SEARCH_NUMBER;

        System.out.println( "Number to search: " + SEARCH_NUMBER );

        bubbleSort( arr );
        System.out.print("Array: ");
        System.out.println( Arrays.toString( arr ) );

        int index = binarySearch( arr, SEARCH_NUMBER );

        System.out.println( "FOUND AT INDEX: " + index );
        System.out.println( "Number at index " + index + ": " + arr[ index ] );

    }

    static void bubbleSort( int[] arr ) {

        boolean hadToSwap = true;

        for( int i = 0; i < arr.length && hadToSwap; i++ ) {
            hadToSwap = false;

            for( int j = 0; j < arr.length - 1 - i; j++ ) {
                if( arr[ j ] > arr[ j + 1 ] ) {
                    int temp = arr[ j ];
                    arr[ j ] = arr[ j + 1 ];
                    arr[ j + 1 ] = temp;
                    hadToSwap = true;
                }
            }
        }
    }

    static int binarySearch( int[] arr, int number ) {

        int start = 0;
        int end = arr.length - 1;

        while( end >= start ) {
            int mid = ( start + end ) / 2;

            if( arr[ mid ] == number ) {
                return mid;
            }
            if( number > arr[ mid ] ) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        return -1;
    }
}
