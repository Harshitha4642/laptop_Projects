package com.rest.cycles.repository;

import org.springframework.data.repository.CrudRepository;

import com.rest.cycles.entity.BorrowedCycle;

public interface BorrowRepository extends CrudRepository<BorrowedCycle, Long> {

}
