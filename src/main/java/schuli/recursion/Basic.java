package schuli.recursion;

public class Basic {
    public static void main( String[] args ) {

        System.out.println( mult( 3, 7 ) );

    }

    public static int faculty( int n ) {
        if ( n > 1 ) {
            return 1;
        }

        return n * faculty( n - 1 );
    }

    public static int fibonacci( int n ) {
        if ( n == 0 ) {
            return 0;
        } else if ( n == 1 ) {
            return 1;
        }

        return fibonacci( n - 2 ) + fibonacci( n - 1 );
    }

    public static int mult( int a, int b ) {
        if ( a == 0 ) {
            return 0;
        }

        return b + mult( a - 1, b );
    }
}
