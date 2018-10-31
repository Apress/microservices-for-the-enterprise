package kasun.metaparticle;

import io.metaparticle.annotations.Package;

import static io.metaparticle.Metaparticle.Containerize;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class HelloService {
    private static final int port = 8080;

    @Package(repository = "docker.io/kasunindrasiri",
            jarFile = "target/metaparticle-hello-1.0-SNAPSHOT.jar")
    public static void main(String[] args) {
        Containerize(() -> {
            try {
                HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
                server.createContext("/", new HttpHandler() {
                    public void handle(HttpExchange t) throws IOException {
                        String msg = "Hello Containers [" + t.getRequestURI() + "] from " + System.getenv("HOSTNAME");
                        t.sendResponseHeaders(200, msg.length());
                        OutputStream os = t.getResponseBody();
                        os.write(msg.getBytes());
                        os.close();
                        System.out.println("[" + t.getRequestURI() + "]");
                    }
                });
                server.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}