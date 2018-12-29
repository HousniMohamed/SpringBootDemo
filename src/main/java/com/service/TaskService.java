package com.service;

import java.util.List;

import com.dto.TaskAddDto;
import com.dto.TaskInfoDto;

/**
 * 
 * @author Housni Mohamed
 *
 */
public interface TaskService {

	public List<TaskInfoDto> findAll();

	public TaskInfoDto addTask(TaskAddDto taskAddDto);

	public boolean deleteTask(int id);

	public TaskInfoDto updatetask(TaskInfoDto taskInfoDto);

	public TaskInfoDto findOneSafe(int id);

}
