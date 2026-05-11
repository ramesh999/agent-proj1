package com.example.taskmanager.task;

import com.example.taskmanager.task.dto.TaskDto;
import com.example.taskmanager.task.mapper.TaskMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskDto> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }

    public TaskDto findById(Long id) {
        return taskMapper.toDto(getTask(id));
    }

    public TaskDto create(TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        task.setId(null);
        return taskMapper.toDto(taskRepository.save(task));
    }

    public TaskDto update(Long id, TaskDto taskDto) {
        Task existingTask = getTask(id);
        existingTask.setTitle(taskDto.getTitle());
        existingTask.setDescription(taskDto.getDescription());
        existingTask.setCompleted(taskDto.isCompleted());
        return taskMapper.toDto(taskRepository.save(existingTask));
    }

    public void delete(Long id) {
        taskRepository.delete(getTask(id));
    }

    private Task getTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with id " + id));
    }
}
