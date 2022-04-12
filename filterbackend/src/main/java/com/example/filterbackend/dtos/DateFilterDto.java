package com.example.filterbackend.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * DTO to model frontend data
 */
public class DateFilterDto implements Serializable {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date value;

    @NotEmpty @NotNull


    // Cleaner way to do this would be a custom annotation, with enums or etc.
    @Pattern(regexp = "^(To|From)$")
    private String operator;


    public DateFilterDto() {
    }

    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
