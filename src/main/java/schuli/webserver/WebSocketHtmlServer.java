package schuli.webserver;

import javax.net.ServerSocketFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

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


            //GET / HTTP/1.1
            //Host: localhost:8080
            //User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:136.0) Gecko/20100101 Firefox/136.0
            //Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
            //Accept-Language: en-GB
            //Accept-Encoding: gzip, deflate, br, zstd
            //DNT: 1
            //Connection: keep-alive
            //Cookie: pmaUser-1=91HApubZsTWQb%2FWwlI3PF4ZQE7OLXIEAHGMw2mF1TgiOdjTcZ%2FMZEELcyT8%3D; pma_lang=en_GB; pga4_session=9d3a279c-555a-4331-9b2c-3b764466bb8e!TLRKYug9LuKaQ1e859lZK6d6JgifCTvb+tQO+VVkW40=; PHPSESSID=2a126dfff002cf8754b21184f352456c; phpMyAdmin=c0a3b80a881d17e76a27472a07cde8e1; PGADMIN_LANGUAGE=en; pmaAuth-1=7%2BsHU8Y3P%2Bje6No2qqIs7gujzxjO556gFVIdfhYVrteqF36yLVU6QvhtA%2Fwu6Wvj2KbKvUnXVevAed6Jx290lk1p4Q%3D%3D
            //Upgrade-Insecure-Requests: 1
            //Sec-Fetch-Dest: document
            //Sec-Fetch-Mode: navigate
            //Sec-Fetch-Site: cross-site
            //Priority: u=0, i


            var outputStream = client.getOutputStream();
            var sc = new Scanner( client.getInputStream() );


            while ( sc.hasNextLine() ) {
                var currLine = sc.nextLine();
                System.out.println( '"' + currLine + '"' );

                if ( currLine.startsWith( "GET" ) ) {
                    var parts = currLine.split( " " );
                    if ( parts.length != 3 ) {
                        throw new RuntimeException( "Invalid Request" );
                    }

                    if ( !parts[ 1 ].equals( "/" ) ) {
                        throw new RuntimeException( "Invalid Request" );
                    }
                }

                if ( currLine.isBlank() ) {
                    System.out.println( "End of Protocol" );
                    break;
                }
            }


            System.out.println( "Done Getting REQUEST" );

            try ( InputStream is = new FileInputStream( HTTP_FILE_PATH ) ) {

                System.out.println( "SENDING DATA" );
                outputStream.write( is.readAllBytes() );
            } catch ( IOException e ) {
                throw new RuntimeException( "Failed to Open index.html" );
            }

        } catch ( IOException e ) {
            throw new RuntimeException( e );
        }
    }
}
