package com.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskInfoDto {

	private int id;
	@NotNull
	@Size(min = 10, max = 100)
	private String description;
	@NotNull
	private Boolean completed;
}
