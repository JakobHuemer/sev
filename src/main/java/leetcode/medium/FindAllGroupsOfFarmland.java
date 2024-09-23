package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FindAllGroupsOfFarmland {


    public static void main( String[] args ) {
        FindAllGroupsOfFarmland sol = new FindAllGroupsOfFarmland();

        int[][] land = new int[][]{
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        };

        var res = sol.findFarmland( land );

        System.out.println( Arrays.deepToString( res ) );
    }

    public int[][] findFarmland( int[][] land ) {

        List<int[]> result = new ArrayList<>();

        for( int i = 0; i < land.length; i++ ) {
            for( int j = 0; j < land[ 0 ].length; j++ ) {
                if( land[ i ][ j ] == 1 ) {
                    int[] res = new int[ 4 ];
                    res[ 0 ] = i;
                    res[ 1 ] = j;
                    int endI = i;
                    int endJ = j;

                    while( endI < land.length && land[ endI ][ endJ ] == 1 ) {
                        endI++;
                    }

                    if( endI > i ) {
                        endI--;
                    }

                    while( endJ < land[0].length && land[ endI ][ endJ ] == 1 ) {
                        endJ++;
                    }

                    if( endJ > j ) {
                        endJ--;
                    }

                    res[ 2 ] = endI;
                    res[ 3 ] = endJ;

                    j = endJ;

                    remove( land, res );

                    result.add( res );
                }
            }
        }

        return result.toArray( new int[ result.size() ][ 4 ] );

    }


    private void remove( int[][] land, int[] toR ) {
        for( int i = toR[ 0 ]; i <= toR[ 2 ]; i++ ) {
            for( int j = toR[ 1 ]; j <= toR[ 3 ]; j++ ) {
                land[ i ][ j ] = 0;
            }
        }
    }
}
