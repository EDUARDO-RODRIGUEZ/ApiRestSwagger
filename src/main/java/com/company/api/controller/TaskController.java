package com.company.api.controller;

import com.company.api.component.response.ApiResponse;
import com.company.api.component.response.Response;
import com.company.api.constant.RestRequest;
import com.company.api.dto.task.TaskCreateRequest;
import com.company.api.dto.task.TaskResponse;
import com.company.api.dto.task.TaskUpdateRequest;
import com.company.api.component.mapper.MapperTaskInterface;
import com.company.api.service.TaskServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = RestRequest.TASK)
public class TaskController {
    @Autowired
    private TaskServiceInterface taskService;
    @Autowired
    private MapperTaskInterface mapperTask;
    @Autowired
    private ApiResponse response;

    @GetMapping
    public Response list() {
        List<TaskResponse> tasksDtos = mapperTask.mapFromEntity(taskService.findAll());
        return response.createCorrectResponse(tasksDtos);
    }

    @PostMapping
    public Response save(@RequestBody TaskCreateRequest taskCreateDto) {
        TaskResponse taskDto = mapperTask.mapFromEntity(taskService.save(taskCreateDto));
        return response.createCorrectResponse(taskDto);
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable("id") Long id, @RequestBody TaskUpdateRequest taskUpdateDto) {
        TaskResponse taskDto = mapperTask.mapFromEntity(taskService.update(id, taskUpdateDto));
        return response.createCorrectResponse(taskDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Response remove(@PathVariable("id") Long id) {
        taskService.remove(id);
        return response.createCorrectResponse();
    }

}
