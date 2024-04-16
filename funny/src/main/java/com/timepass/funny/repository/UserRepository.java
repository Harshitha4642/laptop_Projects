package com.timepass.funny.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.timepass.funny.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByName(String name);

}
