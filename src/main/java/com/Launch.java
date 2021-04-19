package com;

import com.Data.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Launch {

    public static void main(String[] args) {
        Data.parseData();
        SpringApplication.run(Launch.class, args);
    }
}
