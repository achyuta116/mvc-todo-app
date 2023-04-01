package com.example.mvcooad.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mvcooad.model.Todo;

/**
 * TodoRepository
 */
public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
