package com.johnruiz.examples;

import org.apache.commons.daemon.Daemon;
import org.apache.commons.daemon.DaemonContext;
import org.apache.commons.daemon.DaemonController;
import org.apache.commons.daemon.DaemonInitException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The main entry point for the service.  It supports being started as a Java Application (java -jar) or as a linux
 * daemon via JSCV (see: Apache commons-daemon).
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements Daemon, DaemonContext {

    private static final Log LOG = LogFactory.getLog(Application.class);

    private ApplicationContext container;
    private String[] args;


    public static void main(String[] args) throws Exception {

        LOG.info("Application is started via the main method");

        Application app = new Application(args);
        app.init(app);
        app.start();
    }


    public Application() {

    }

    public Application(String[] args) {
        this.args = args;
    }


    @Override
    public void init(DaemonContext context) throws DaemonInitException, Exception {
        LOG.info("Application is initializing");
        // one does not simply initialize a Spring Boot application
    }

    @Override
    public void start() throws Exception {
        this.container = SpringApplication.run(Application.class, args);

        LOG.info("Application has started");
    }

    @Override
    public void stop() throws Exception {

        LOG.info("Application is stopping");
        ExitCodeGenerator exitCodeGenerator = () -> 0;
        SpringApplication.exit(this.container, exitCodeGenerator);
    }

    @Override
    public void destroy() {
        LOG.info("Application has stopped");
    }


    @Override
    public DaemonController getController() {
        return null;
    }

    @Override
    public String[] getArguments() {
        return this.args;
    }
}
