package com.easylearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.easylearning.model.Worker;


public interface WorkRepository extends JpaRepository<Worker,Integer> {

}
