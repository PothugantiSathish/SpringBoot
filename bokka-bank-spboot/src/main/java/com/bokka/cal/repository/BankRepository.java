package com.bokka.cal.repository;

import org.springframework.data.repository.CrudRepository;

import com.bokka.cal.model.BankUser;

public interface BankRepository extends CrudRepository<BankUser, Integer> {

}
