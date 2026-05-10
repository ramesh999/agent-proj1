package com.example.taskmanager.task.mapper;

import com.example.taskmanager.task.Task;
import com.example.taskmanager.task.dto.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    TaskDto toDto(Task task);

    Task toEntity(TaskDto taskDto);
}
