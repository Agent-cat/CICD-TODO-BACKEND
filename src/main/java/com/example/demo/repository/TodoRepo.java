package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Todo;

public interface TodoRepo extends JpaRepository<Todo, Long> {

}
