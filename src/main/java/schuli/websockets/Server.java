package schuli.websockets;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server {

    private static final int PORT = 4040;

    public static void main( String[] args ) throws IOException {
        ServerSocket socket = ServerSocketFactory.getDefault().createServerSocket( PORT );

        while ( true ) {
            Socket client = socket.accept();
            new Thread( () -> handleConnection( client ) ).start();
        }
    }

    private static void handleConnection( Socket client ) {
        try ( client ) {


            var pw = new PrintWriter( client.getOutputStream(), true, StandardCharsets.UTF_8 );
            var sc = new Scanner( client.getInputStream() );

            var l1 = sc.nextLine();
            var l2 = sc.nextLine();

            var result = new BigInteger( l1 )
                    .multiply( new BigInteger( l2 ) )
                    .toString();

            pw.println( result );

        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }
}
