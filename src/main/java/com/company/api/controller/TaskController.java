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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Response> list() {
        List<TaskResponse> tasksDtos = mapperTask.mapFromEntity(taskService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(response.createCorrectResponse(tasksDtos));
    }

    @PostMapping
    public ResponseEntity<Response> save(@Valid @RequestBody TaskCreateRequest taskCreateDto) {
        TaskResponse taskDto = mapperTask.mapFromEntity(taskService.save(taskCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(response.createCorrectResponse(taskDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@PathVariable("id") Long id, @Valid @RequestBody TaskUpdateRequest taskUpdateDto) {
        TaskResponse taskDto = mapperTask.mapFromEntity(taskService.update(id, taskUpdateDto));
        return ResponseEntity.status(HttpStatus.OK).body(response.createCorrectResponse(taskDto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Response> remove(@PathVariable("id") Long id) {
        taskService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(response.createCorrectResponse());
    }

}
