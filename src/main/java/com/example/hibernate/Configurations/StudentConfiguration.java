package com.example.hibernate.Configurations;

import com.example.hibernate.Model.Laptop;
import com.example.hibernate.Model.Student;
import com.example.hibernate.Repositorys.LaptopRepository;
import com.example.hibernate.Repositorys.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    @Order(1)
    public CommandLineRunner commandLineRunner1(StudentRepository repo){
        return args -> {
            Student s1 = new Student("Marian","UPT");
            Student s2 = new Student("Adrian", "UVT" );
            List<Laptop> lap = s1.getLaptop();
            lap.add(new Laptop(1, "DELL",s1));
            lap.add(new Laptop(2, "PHP",s1));
            s1.setLaptop(lap);

            lap=s2.getLaptop();
            lap.add(new Laptop(1, "DELL",s2));
            s2.setLaptop(lap);
            ArrayList<Student> list = new ArrayList<>();
            list.add(s1);
            list.add(s2);
            for(int i =1;i<=30;i++) {
                Student s = new Student("Name"+i,"UPT"+i);
                list.add(s);
            }
            System.out.println(s1.getLaptop() + "" + s2.getLaptop() + "");
            repo.saveAll(list);
            s1.setUniversity("Pacanele");
        };
    }



}
