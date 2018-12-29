package com.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.service.TaskService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.dto.*;
import com.model.ApiErrorResponse;

/**
 * 
 * @author Housni Mohamed
 *
 */
@RestController
@RequestMapping("/api/task")
@Api("/api/task")
public class TaskController {

	@Autowired
	TaskService taskService;

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "get task by id", notes = "get task based on id provided from client", response = TaskInfoDto.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "success", response = TaskInfoDto.class),
			@ApiResponse(code = 404, message = "failed to retrieve task", response = ApiErrorResponse.class) })
	public TaskInfoDto getOne(
			@ApiParam(required = true, name = "id", value = "ID of the task you want to retrieve") @PathVariable int id) {
		return this.taskService.findOneSafe(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "delete task with Id", notes = "delete a task with an id provided from user", response = Boolean.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "successffully deleted"),
			@ApiResponse(code = 400, message = "Bad request", response = ApiErrorResponse.class),
			@ApiResponse(code = 404, message = "not found", response = ApiErrorResponse.class) })
	public boolean deleteTask(@PathVariable int id) {
		return this.taskService.deleteTask(id);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ApiOperation(value = "find all tasks ", notes = "Retrieving a collection of user task", response = TaskInfoDto[].class)
	@ApiResponses({ @ApiResponse(code = 200, message = "operation successfully ", response = TaskInfoDto[].class),
			@ApiResponse(code = 404, message = "task table is empty", response = ApiErrorResponse.class) })
	public List<TaskInfoDto> getAll() {
		return this.taskService.findAll();
	}


	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	@ApiOperation(value = "add task", notes = "create new task", response = TaskInfoDto.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "successfully created", response = TaskInfoDto.class),
			@ApiResponse(code = 400, message = "bad request", response = ApiErrorResponse.class) })
	public TaskInfoDto addTask(@Valid @RequestBody TaskAddDto taskAddDto) {
		return this.taskService.addTask(taskAddDto);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)

	@ApiOperation(value = "update a task ", notes = "we provide a taskinfo object ", response = TaskInfoDto.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "successfully updated", response = TaskInfoDto.class),
			@ApiResponse(code = 400, message = "error while updating", response = ApiErrorResponse.class),
			@ApiResponse(code = 404, message = "not found", response = ApiErrorResponse.class) })

	public TaskInfoDto updateTask(@Valid @RequestBody TaskInfoDto taskInfoDto) {
		return this.taskService.updatetask(taskInfoDto);
	}
}
