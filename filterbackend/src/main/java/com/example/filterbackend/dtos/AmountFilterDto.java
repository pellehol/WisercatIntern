package com.example.filterbackend.dtos;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * DTO to model frontend data
 */
public class AmountFilterDto implements Serializable {

    @NotNull
    private Long value;

    // Cleaner way to do this would be a custom annotation, with enums or etc.
    @Pattern(regexp = "^(Equal|Not Equal|Greater|Less|Greater or equal|Less or equal)$")
    private String operator;


    public AmountFilterDto() {
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
