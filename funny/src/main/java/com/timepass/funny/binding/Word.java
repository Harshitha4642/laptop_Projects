package com.timepass.funny.binding;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Word {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int wordId;
	private int userId;
	private String wordContent;

}
