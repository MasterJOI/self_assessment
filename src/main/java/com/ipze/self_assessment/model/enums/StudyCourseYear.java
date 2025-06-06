package com.ipze.self_assessment.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StudyCourseYear {
    YEAR_1("1 рік навчання"),
    YEAR_2("2 рік навчання"),
    YEAR_3( "3 рік навчання"),
    YEAR_4("4 рік навчання");

    private final String value;
}
