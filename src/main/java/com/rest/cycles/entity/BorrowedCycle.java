package com.rest.cycles.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BorrowedCycle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

    @ManyToOne
    @JoinColumn(name = "cycle_id", referencedColumnName = "id")
    private Cycle cycle;

    @ManyToOne
    @JoinColumn(name = "borrower_id", referencedColumnName = "id")
    private User borrower;
    
    private Date borrowedAt;
    private Date returnedAt;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cycle getCycle() {
		return cycle;
	}
	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}
	public User getBorrower() {
		return borrower;
	}
	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}
	public Date getBorrowedAt() {
		return borrowedAt;
	}
	public void setBorrowedAt(Date borrowedAt) {
		this.borrowedAt = borrowedAt;
	}
	public Date getReturnedAt() {
		return returnedAt;
	}
	public void setReturnedAt(Date returnedAt) {
		this.returnedAt = returnedAt;
	}

}
