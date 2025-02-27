package hue.threading;

public class Example2 {
    public static void main( String[] args ) {
        System.out.println( "Name: " + Thread.currentThread().getName() );
        System.out.println( "Priorität: " + Thread.currentThread().getPriority() );
    }
}
