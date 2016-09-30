package com.kaza;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ResourceBundle;

/**
 * Created by Maciel on 04/08/2016.
 */
@RestController
@EnableAutoConfiguration
@SpringBootApplication
@Slf4j
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping(value = "/ping", consumes = "*/*", produces = "text/plain")
    public String ping(){
        return "OK";
    }

    @RequestMapping(value = "/version", consumes = "*/*", produces = "text/plain")
    public String version(){
        ResourceBundle rb = ResourceBundle.getBundle("version");
        Object version = rb.getObject("version");
        Object buildNumber = rb.getObject("build_number");

        return String.join(" ", "Version", version.toString(), "build", buildNumber.toString());
    }

}
