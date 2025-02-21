package com.web.user.sample_application.repository;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import com.web.user.sample_application.model.Manager;


public interface ManagerRepository extends JpaRepository<Manager, UUID> {
	

}
