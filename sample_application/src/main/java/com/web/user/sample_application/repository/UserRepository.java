package com.web.user.sample_application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.user.sample_application.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	List<User> findByMobNum(String mobNum);
    List<User> findByManagerId(String managerId);

}
