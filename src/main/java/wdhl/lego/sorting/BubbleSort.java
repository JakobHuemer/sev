package wdhl.lego.sorting;

import java.util.Arrays;

public class BubbleSort {
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

    public static void bubbleSort( int[] toSort ) {
        boolean hadToSort = true;

        for( int i = 0; i < toSort.length && hadToSort; i++ ) {
            hadToSort = false;
            for( int j = 0; j < toSort.length - i - 1; j++ ) {
                if( toSort[ j ] > toSort[ j + 1 ] ) {
                    // swap
                    int temp = toSort[ j ];
                    toSort[ j ] = toSort[ j + 1 ];
                    toSort[ j + 1 ] = temp;
                    hadToSort = true;
                }
            }
        }

    }
}
