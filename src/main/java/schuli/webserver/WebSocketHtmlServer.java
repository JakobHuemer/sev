package schuli.webserver;

import javax.net.ServerSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class WebSocketHtmlServer {

    private final static int PORT = 8080;

    private static final String HTTP_FILE_PATH = Objects.requireNonNull(
            WebSocketHtmlServer.class.getResource( "index.http" )
    ).getPath();

    public static void main( String[] args ) throws IOException {
        ServerSocket socket = ServerSocketFactory.getDefault().createServerSocket( PORT );

        while ( true ) {
            Socket client = socket.accept();
            new Thread( () -> handleConnection( client ) ).start();
        }
    }

    private static void handleConnection( Socket client ) {
        try ( client ) {


            var outputStream = client.getOutputStream();

            try ( InputStream is = new FileInputStream( HTTP_FILE_PATH ) ) {
                outputStream.write( is.readAllBytes() );
            } catch ( IOException e ) {
                throw new RuntimeException( "Failed to Open index.html" );
            }

        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }
}
