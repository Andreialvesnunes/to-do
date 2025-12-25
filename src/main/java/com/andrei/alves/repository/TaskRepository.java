package com.andrei.alves.repository;

import com.andrei.alves.model.Status;
import com.andrei.alves.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task ,Long > {

    Optional<Task> findByStatus(Status status);
}
