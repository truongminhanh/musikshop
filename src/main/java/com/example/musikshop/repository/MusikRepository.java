package com.example.musikshop.repository;

import com.example.musikshop.Entity.Musik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MusikRepository extends JpaRepository<Musik,Long> {

}
