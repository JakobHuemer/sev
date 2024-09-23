package schuli.recursion;

public class Basic {
    public static void main( String[] args ) {

        System.out.println( fibonacci( 8 ) );

    }

    public static int fibonacci( int n ) {
        if ( n == 0 ) {
            return 0;
        } else if ( n == 1 ) {
            return 1;
        }

        return fibonacci( n - 2 ) + fibonacci( n - 1 );
    }
}
