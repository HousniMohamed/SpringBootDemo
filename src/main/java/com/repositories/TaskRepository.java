package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
