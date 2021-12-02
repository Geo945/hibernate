package com.example.hibernate.Repositorys;

import com.example.hibernate.Model.Laptop;
import com.example.hibernate.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

}
