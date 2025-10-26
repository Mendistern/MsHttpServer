package dev.generationz.httpserver.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MsHttpServer {

    private static final Logger log = LoggerFactory.getLogger(MsHttpServer.class);
    private static final int PORT = 4221;

    private static MsHttpServer instance;

    private MsHttpServer() {

    }

    public void buildServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            log.info("Started Server Socket on port {}", PORT);

            Socket clientSocket = serverSocket.accept();
            log.info("Accepted new conncetion");

            InputStream is = clientSocket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bf = new BufferedReader(isr);
            log.info("Request received\nMessage:\n{}", bf.readLine());

            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);
            pw.write("HTTP/1.1 200 OK\r\n\r\nclear");
            pw.close();
        } catch (Exception ex) {
            log.error("Error occurred while initializing server", ex);
        }
    }

    public static MsHttpServer getInstance() {
        if (instance == null) {
            instance = new MsHttpServer();
        }
        return instance;
    }
}
