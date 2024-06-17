package wdhl.lego.sorting;

import java.util.Arrays;

public class GrundSort {
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
        grundSort( randArray );
        System.out.println( STR."After \{Arrays.toString( randArray )}" );

        System.out.println( STR."Check \{Arrays.equals( randArray, sortedChecKArray )}" );
    }

    private static void grundSort( int[] toSort ) {
        for( int i = 0; i < toSort.length; i++ ) {
            for( int j = i + 1; j < toSort.length; j++ ) {
                if( toSort[ i ] > toSort[ j ] ) {
                    int temp = toSort[ i ];
                    toSort[ i ] = toSort[ j ];
                    toSort[ j ] = temp;
                }
            }
        }
    }
}
