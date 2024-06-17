package wdhl.lego.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main( String[] args ) {

        int[] randArray = new int[ 20 ];
        int[] sortedChecKArray = new int[ 20 ];

        for( int i = 0; i < randArray.length; i++ ) {
            int rand = (int) Math.floor( Math.random() * 100 ) - 50;
            randArray[ i ] = rand;
            sortedChecKArray[ i ] = rand;
        }

        Arrays.sort( sortedChecKArray );

        System.out.println( STR."Before \{Arrays.toString( randArray )}" );
        insertionSort( randArray );
        System.out.println( STR."After \{Arrays.toString( randArray )}" );

        System.out.println( STR."Check \{Arrays.equals( randArray, sortedChecKArray )}" );
    }

    private static void insertionSort( int[] toSort ) {
        for( int i = 1; i < toSort.length; i++ ) {
            int toInsert = toSort[ i ];
            int j = i - 1;

            while( j >= 0 && toSort[ j ] > toInsert ) {
                toSort[ j + 1 ] = toSort[ j ];
                j--;
            }

            toSort[ j + 1 ] = toInsert;
        }
    }
}
