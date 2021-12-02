package com.example.hibernate;

import com.example.hibernate.Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateApplication.class, args);
        //hibernate get files the query - will give you the object
        //hibernate load doesnt file the query only if you use it. - will give you the proxy object(blank object)
    }

}
