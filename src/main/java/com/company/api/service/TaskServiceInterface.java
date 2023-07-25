package com.company.api.service;

import com.company.api.dto.task.TaskCreateRequest;
import com.company.api.dto.task.TaskUpdateRequest;
import com.company.api.entity.Task;

import java.util.List;

public interface TaskServiceInterface {
    List<Task> findAll();

    Task find(Long id);

    Task save(TaskCreateRequest taskDtoCreate);

    Task update(Long id, TaskUpdateRequest taskDto);

    void remove(Long id);
}
