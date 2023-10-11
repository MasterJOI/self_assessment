package com.ipze.self_assessment.domains.selfAssessment.dto;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.ipze.self_assessment.domains.selfAssessment.dto.sections.*;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString
public class SelfAssessmentInfoRequestBody {
	private final Map<String, Object> programDesign = new HashMap<>();
	private final Map<String, Object> structureAndContent = new HashMap<>();
	private final Map<String, Object> programAccess = new HashMap<>();
	private final Map<String, Object> learningAndTeaching = new HashMap<>();
	private final Map<String, Object> controlMeasuresAndAcademicIntegrity = new HashMap<>();
	private final Map<String, Object> humanResource = new HashMap<>();
	private final Map<String, Object> educationalEnvironmentAndMaterialResource = new HashMap<>();
	private final Map<String, Object> qualityAssurance = new HashMap<>();
	private final Map<String, Object> transparencyAndPublicity = new HashMap<>();
	private final Map<String, Object> educationalProgram = new HashMap<>();
	private final Map<String, Object> developmentPerspective = new HashMap<>();
	// Додайте інші поля, які вам потрібні

	@JsonAnySetter
	public void setDynamicField(String fieldName, Object value) {
		// Додайте поле до відповідного мапи згідно з назвою поля
		switch (fieldName) {
			case "programDesign" -> programDesign.putAll((Map<String, Object>) value);
			case "structureAndContent" ->
				structureAndContent.putAll((Map<String, Object>) value);
			case "programAccess" -> programAccess.putAll((Map<String, Object>) value);
			case "learningAndTeaching" ->
				learningAndTeaching.putAll((Map<String, Object>) value);
			case "controlMeasuresAndAcademicIntegrity" ->
				controlMeasuresAndAcademicIntegrity.putAll((Map<String, Object>) value);
			case "humanResource" -> humanResource.putAll((Map<String, Object>) value);
			case "educationalEnvironmentAndMaterialResource" ->
				educationalEnvironmentAndMaterialResource.putAll((Map<String, Object>) value);
			case "qualityAssurance" -> qualityAssurance.putAll((Map<String, Object>) value);
			case "transparencyAndPublicity" ->
				transparencyAndPublicity.putAll((Map<String, Object>) value);
			case "educationalProgram" -> educationalProgram.putAll((Map<String, Object>) value);
			case "developmentPerspective" ->
				developmentPerspective.putAll((Map<String, Object>) value);
		}
	}
}






