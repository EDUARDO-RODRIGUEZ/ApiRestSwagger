package com.company.api.controller;

import com.company.api.component.mapper.MapperTaskInterface;
import com.company.api.component.response.ApiResponse;
import com.company.api.component.response.Response;
import com.company.api.constant.RestRequest;
import com.company.api.dto.task.TaskCreateRequest;
import com.company.api.dto.task.TaskResponse;
import com.company.api.dto.task.TaskUpdateRequest;
import com.company.api.service.TaskServiceInterface;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success Request"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Failed Server"),
    })
    public ResponseEntity<Response> list() {
        List<TaskResponse> tasksDtos = mapperTask.mapFromEntity(taskService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(response.createCorrectResponse(tasksDtos));
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success Request"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Failed Server"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not found Resource")
    })
    public ResponseEntity<Response> update(@PathVariable("id") Long id, @Valid @RequestBody TaskUpdateRequest taskUpdateDto) {
        TaskResponse taskDto = mapperTask.mapFromEntity(taskService.update(id, taskUpdateDto));
        return ResponseEntity.status(HttpStatus.OK).body(response.createCorrectResponse(taskDto));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Success Request"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Failed Server")
    })
    public ResponseEntity<Response> save(@Valid @RequestBody TaskCreateRequest taskCreateDto) {
        TaskResponse taskDto = mapperTask.mapFromEntity(taskService.save(taskCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(response.createCorrectResponse(taskDto));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Success Request"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "500", description = "Failed Server"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Not found Resource")
    })
    public ResponseEntity<Response> remove(@PathVariable("id") Long id) {
        taskService.remove(id);
        return ResponseEntity.status(HttpStatus.OK).body(response.createCorrectResponse());
    }

}
