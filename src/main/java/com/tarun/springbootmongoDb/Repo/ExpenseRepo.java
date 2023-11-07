package com.tarun.springbootmongoDb.Repo;

import com.tarun.springbootmongoDb.Models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ExpenseRepo extends MongoRepository<Expense,String> {

    @Query("{'name':?0}")
   Optional<Expense> findByName(String name);
}
