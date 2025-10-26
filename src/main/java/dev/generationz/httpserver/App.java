package dev.generationz.httpserver;

import dev.generationz.httpserver.server.MsHttpServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        log.info("Application started");
        MsHttpServer instance = MsHttpServer.getInstance();
        instance.buildServer();
    }
}
