package org.dev.xoobackend;

import org.dev.xoobackend.dao.xoo_1Dao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class XooBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(XooBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(xoo_1Dao xoo_1dao) {
        return args -> {
//          System.out.println(xoo_1dao.JoinSession("amol",";G'v'Og2CA"));
//          System.out.println(xoo_1dao.CreateNewSession("sudarshan"));
//            System.out.println(xoo_1dao.Xmove(";G'v'Og2CA",1,1));
//            System.out.println(xoo_1dao.currentMove(";G'v'Og2CA").toString());
        };
    }

}
