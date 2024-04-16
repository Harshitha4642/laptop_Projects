package com.prodapt.cycles.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prodapt.cycles.rent.User;

public interface UserRepository extends CrudRepository<User, String>{
	
	int findCountByPassword(String Password);
	
	@Query(value="select count(*) from user where user_name=?1 and password=?2", nativeQuery=true)
	public int findValidUser(String name, String password);
}
