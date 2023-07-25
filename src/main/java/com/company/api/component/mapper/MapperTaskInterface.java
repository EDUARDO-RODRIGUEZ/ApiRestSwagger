package com.company.api.component.mapper;

import com.company.api.dto.task.TaskResponse;
import com.company.api.entity.Task;

import java.util.List;

public interface MapperTaskInterface {
    TaskResponse mapFromEntity(Task task);

    List<TaskResponse> mapFromEntity(List<Task> tasks);

}
