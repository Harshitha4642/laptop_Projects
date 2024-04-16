package com.prodapt.cycles.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prodapt.cycles.rent.Cycle;

import jakarta.transaction.Transactional;

public interface CycleRepository extends CrudRepository<Cycle, Integer> {
	
	@Query(value="update cycles set quantity = quantity - ?1 where model = ?2", nativeQuery=true)
	@Modifying
	@Transactional
	public void updateCycleQuantity(Integer borrowedQuantity, String borrowedModel);

	@Query(value="insert into borrowedCycles values(?1, ?2, ?3)", nativeQuery=true)
	@Modifying
	@Transactional
	public void UpdateBorrowedCycles(int cycle__id, String model, int quantity);
	
	@Query(value="select * from cycles", nativeQuery=true)
	public String[] getAllAvailableCycles();
	
	@Query(value="update cycles set quantity = quantity + (select quantity from borrowedCycles where cycle_id = ?1) where id=?1", nativeQuery=true)
	@Modifying
	@Transactional
	public void restockCyclesOfID(int cycle__id);

	@Query(value="delete from borrowedCycles where cycle_id=?1", nativeQuery=true)
	@Modifying
	@Transactional
	public void clearCyclesOfID(int id);
}
