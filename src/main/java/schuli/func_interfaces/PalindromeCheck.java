package schuli.func_interfaces;

public class PalindromeCheck {
    public static void main( String[] args ) {

        int iterations = 100_000_000;
        String toTest = "rotavator";

        // performance wise is isPalindromeLong

        long start = System.currentTimeMillis();
        for ( int i = 0; i < iterations; i++ ) {
            isPalindromeLong( toTest );
        }
        System.out.println( "Ended at " + ( System.currentTimeMillis() - start ) );

        start = System.currentTimeMillis();

        for ( int i = 0; i < iterations; i++ ) {
            isPalindromeShort( toTest );
        }
        System.out.println( "Ended at " + ( System.currentTimeMillis() - start ) );


    }


    static boolean isPalindromeLong( String s ) {
        char[] charArray = s.toCharArray();
        for ( int i = 0; i < charArray.length / 2; i++ ) {
            if ( charArray[ i ] != charArray[ charArray.length - 1 - i ] ) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindromeShort( String s ) {
        return s.contentEquals( new StringBuilder( s ).reverse() );
    }
}
