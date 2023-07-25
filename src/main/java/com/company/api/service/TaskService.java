package com.company.api.service;

import com.company.api.dto.task.TaskCreateRequest;
import com.company.api.dto.task.TaskUpdateRequest;
import com.company.api.entity.Task;
import com.company.api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements TaskServiceInterface {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task find(Long id) {
        Optional<Task> boxTask = taskRepository.findById(id);
        if (boxTask.isEmpty())
            return null; //Lanzar Exception
        return boxTask.get();
    }

    @Override
    public Task save(TaskCreateRequest taskDtoCreate) {
        Task task = new Task();
        task.setTitle(taskDtoCreate.getTitle());
        task.setDescription(taskDtoCreate.getDescription());
        taskRepository.save(task);
        return task;
    }

    @Override
    public Task update(Long id, TaskUpdateRequest taskUpdateDto) {
        Task task = find(id);
        task.setTitle(taskUpdateDto.getTitle());
        task.setDescription(taskUpdateDto.getDescription());
        task.setFinished(taskUpdateDto.getFinished());
        taskRepository.save(task);
        return task;
    }

    @Override
    public void remove(Long id) {
        Task task = find(id);
        taskRepository.delete(task);
    }
}
