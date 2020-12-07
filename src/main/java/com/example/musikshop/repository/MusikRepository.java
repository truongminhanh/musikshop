package com.example.musikshop.repository;

import com.example.musikshop.Entity.Musik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public interface MusikRepository extends CrudRepository<Musik,Long> {

}
