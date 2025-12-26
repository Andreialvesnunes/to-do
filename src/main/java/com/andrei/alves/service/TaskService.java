package com.andrei.alves.service;

import com.andrei.alves.dto.TaskDTO;
import com.andrei.alves.mapper.ObjectMapper;
import com.andrei.alves.model.Task;
import com.andrei.alves.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskDTO> findAll(){
        return ObjectMapper.parseObjectList(taskRepository.findAll(), TaskDTO.class);
    }

    public TaskDTO findById(Long id){
        var entity = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        return ObjectMapper.parseObject(entity, TaskDTO.class);
    }

    public TaskDTO create(TaskDTO taskDTO){
        var entity = ObjectMapper.parseObject(taskDTO, Task.class);
        return ObjectMapper.parseObject(taskRepository.save(entity), TaskDTO.class);
    }

    public TaskDTO update(Long id){
        Task entity = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        entity.setTitulo(entity.getTitulo());
        entity.setDescricao(entity.getDescricao());
        entity.setStatus(entity.getStatus());
        return ObjectMapper.parseObject(taskRepository.save(entity), TaskDTO.class);
    }

    public void delete(Long id){
        Task entity = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        taskRepository.delete(entity);
    }
}
