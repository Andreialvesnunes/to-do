package com.andrei.alves.controller;

import com.andrei.alves.dto.TaskDTO;
import com.andrei.alves.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<TaskDTO> findAll(TaskDTO taskDTO){
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public TaskDTO findById(@PathVariable Long id){
        return taskService.findById(id);
    }

    @PostMapping("/alteracao")
    public TaskDTO create(TaskDTO taskDTO){
        return taskService.create(taskDTO);
    }

    @PutMapping("/atualizacao")
    public TaskDTO update(Long id){
        return taskService.update(id);
    }

    @DeleteMapping
    public void delete(Long id){
        taskService.delete(id);
    }
}
