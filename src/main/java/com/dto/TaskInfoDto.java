package com.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskInfoDto {

	private int id;
	@NotNull
	@Size(min = 10, max = 100)
	private String description;
	@NotNull
	private Boolean completed;

	public TaskInfoDto() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

}
