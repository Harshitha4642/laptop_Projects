package com.rest.cycles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rest.cycles.entity.CartItem;
import com.rest.cycles.entity.Cycle;

public interface CartRepository extends CrudRepository<CartItem,Long> {
	@Query(value = "SELECT * FROM cart_item WHERE user_id = ?1", nativeQuery = true)
    List<CartItem> customQueryMethodName(long id);

}
