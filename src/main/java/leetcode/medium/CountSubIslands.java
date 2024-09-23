package leetcode.medium;

import java.awt.*;
import java.util.*;
import java.util.List;

public class CountSubIslands {
    public static void main( String[] args ) {
        List<int[][][]> tests = new ArrayList<>();

        // [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]
        var map11 = new int[][]{ { 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 } };
        // [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
        var map12 = new int[][]{ { 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1 }, { 0, 1, 0, 0, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 1, 0 } };

        tests.add( new int[][][]{ map11, map12 } );

        var sub = new CountSubIslands();
        var res = sub.countSubIslands( map11, map12 );

        System.out.println(res);
    }

    public int countSubIslands( int[][] grid1, int[][] grid2 ) {
        int count = 0;

        List<List<int[]>> islands = new ArrayList<>();
        List<List<int[]>> subIslands = new ArrayList<>();

        for( int i = 0; i < grid1.length; i++ ) {
            for( int j = 0; j < grid1[ 0 ].length; j++ ) {
                if( grid1[ i ][ j ] == 1 ) {
                    islands.add( getIsland( grid1, i, j ) );
                }
                if( grid2[ i ][ j ] == 1 ) {
                    subIslands.add( getIsland( grid2, i, j ) );
                }
            }
        }

        // print islands
        for( List<int[]> island : islands ) {
            System.out.println( "Island" );
            for( int[] point : island ) {
                System.out.println( Arrays.toString( point ) );
            }
        }

        return count;
    }

    public List<int[]> getIsland( int[][] grid, int i, int j ) {
        List<int[]> l = new ArrayList<>();
        if( i < 0 || i >= grid.length || j < 0 || j >= grid[ 0 ].length || grid[ i ][ j ] == 0 ) return l;
        grid[ i ][ j ] = 0;
        l.add( new int[]{ i, j } );

        l.addAll( getIsland( grid, i + 1, j ) );
        l.addAll( getIsland( grid, i - 1, j ) );
        l.addAll( getIsland( grid, i, j + 1 ) );
        l.addAll( getIsland( grid, i, j - 1 ) );

        return l;
    }

}


