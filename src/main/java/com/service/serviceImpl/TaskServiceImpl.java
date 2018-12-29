package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.TaskAddDto;
import com.dto.TaskInfoDto;
import com.entities.Task;
import com.exceptions.DataNotFoundException;
import com.exceptions.MappingExceptions;
import com.exceptions.PersistenceException;
import com.repositories.TaskRepository;
import com.service.TaskService;

/**
 * 
 * @author Housni Mohamed
 *
 */
@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	ModelMapper mapper;

	@Override
	public List<TaskInfoDto> findAll() {
		/** list of task */
		List<TaskInfoDto> taskInfoDto = new ArrayList<>();
		this.taskRepository.findAll().forEach(task -> {
			try {
				taskInfoDto.add(this.mapper.map(task, TaskInfoDto.class));
			} catch (Exception e) {
				e.printStackTrace();
				throw new MappingExceptions("mapping exceptions", task.getId());
			}
		});
		return taskInfoDto;
	}

	@Override
	public TaskInfoDto addTask(TaskAddDto taskAddDto) {
		Task task = this.mapper.map(taskAddDto, Task.class);
		try {
			task = this.taskRepository.saveAndFlush(task);
			return this.mapper.map(task, TaskInfoDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new PersistenceException("Error while saving task");
	}

	@Override
	public boolean deleteTask(int id) {

		try {
			this.taskRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new PersistenceException("Error while deleting task");
	}

	@Override
	public TaskInfoDto updatetask(TaskInfoDto taskInfoDto) {

		Task task = null;
		/** mapping TaskInfoDto to Task */
		try {
			task = this.mapper.map(taskInfoDto, Task.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MappingExceptions("Error while mapping taskInfoDto to task");
		}
		/** update entity */
		try {
			task = this.taskRepository.saveAndFlush(task);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenceException("Error while updating Task");
		}
		/** mapping task to TaskInfoDto */
		try {
			return this.mapper.map(task, TaskInfoDto.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new MappingExceptions("Error while Mapping task to TaskInfoDto");
	}

	@Override
	public TaskInfoDto findOneSafe(int id) {
		
		Optional<Task> task = this.taskRepository.findById(id);
		
		if (!task.isPresent()) {
			throw new DataNotFoundException(id);
		}
		return this.mapper.map(task.get(), TaskInfoDto.class);
	}
}
