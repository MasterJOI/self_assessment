package com.ipze.self_assessment.domains.educationProgramDocument.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
public class GroupedProgramData {
	@JsonProperty("philosophy")
	private List<String> philosophy;

	@JsonProperty("magistr")
	private List<String> magistr;

	@JsonProperty("bakalavr")
	private List<String> bakalavr;
}
