package wdhl.lego.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main( String[] args ) {

        int[] randArray = new int[ 20 ];
        int[] sortedChecKArray = new int[ 20 ];

        for( int i = 0; i < randArray.length; i++ ) {
            int rand = (int) Math.floor( Math.random() * 100 ) - 50;
            randArray[ i ] = rand;
            sortedChecKArray[ i ] = rand;
        }

        Arrays.sort( sortedChecKArray );

    }

    private static void selectionSort( int[] toSort ) {
        for( int i = 0; i < toSort.length; i++ ) {
            int minIndex = i;
            for( int j = i + 1; j < toSort.length; j++ ) {
                if( toSort[ j ] < toSort[ minIndex ] ) {
                    minIndex = j;
                }
            }
            if( minIndex != i ) {
                int temp = toSort[ minIndex ];
                toSort[ minIndex ] = toSort[ i ];
                toSort[ i ] = temp;
            }
        }
    }
}
