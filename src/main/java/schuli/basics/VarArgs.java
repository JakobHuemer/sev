package schuli.basics;

import java.util.Arrays;

public class VarArgs {

    public static void main( String[] args ) {
        print( "Hello", "World" );
        print();
        print( "Hello", "World", "This", "is", "more hehe" );
    }

    static void print( String... args ) {
        System.out.println("------------------------");
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}
