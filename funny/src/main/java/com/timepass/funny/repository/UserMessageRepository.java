package com.timepass.funny.repository;

import org.springframework.data.repository.CrudRepository;


import com.timepass.funny.binding.Word;

public interface UserMessageRepository extends CrudRepository<Word, Integer> {

}
