package schuli.websockets;

import javax.net.SocketFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {

    private static final int PORT = 4040;


    public static void main( String[] args ) {
        System.out.println();
        System.out.println( multiply( 23, 34 ) );
    }

    private static int multiply(int n1, int n2) {
        try ( Socket socket = SocketFactory.getDefault().createSocket( "localhost", PORT ) ) {

            System.out.println("Connected");

            var pw = new PrintWriter( socket.getOutputStream(), true, StandardCharsets.UTF_8 );
            var sc = new Scanner( socket.getInputStream() );

            pw.println( String.format( "%d", n1 ) );
            pw.println( String.format( "%d", n2 ) );

            String result = sc.nextLine();

            return Integer.parseInt( result );

        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }


}
