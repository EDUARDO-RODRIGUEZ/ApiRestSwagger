package com.company.api.component.mapper;


import com.company.api.dto.task.TaskResponse;
import com.company.api.entity.Task;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperTask implements MapperTaskInterface {
    @Override
    public TaskResponse mapFromEntity(Task task) {
        return TaskResponse.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .createdAt(task.getCreatedAt())
                .finished(task.getFinished())
                .build();
    }

    @Override
    public List<TaskResponse> mapFromEntity(List<Task> tasks) {
        return tasks.stream().map((task) ->
                TaskResponse.builder()
                        .title(task.getTitle())
                        .description(task.getDescription())
                        .createdAt(task.getCreatedAt())
                        .finished(task.getFinished())
                        .build()
        ).collect(Collectors.toList());
    }
}
