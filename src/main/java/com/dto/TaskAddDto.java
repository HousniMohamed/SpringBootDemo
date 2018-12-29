package com.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "TaskAddDto", description = "user task")
@Data
@NoArgsConstructor
public class TaskAddDto {

	@NotNull
	@Size(min = 10, max = 100, message = "{message.description}")
	@ApiModelProperty(value = "description of the task", required = true)
	private String description;
	@NotNull
	@ApiModelProperty(value = "inidcate if the task was completed or not", required = true)
	private Boolean completed;

}
