package com.example.filterbackend.dtos;

import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * DTO to model frontend data
 */
public class TitleFilterDto implements Serializable {

    @NotEmpty
    @NotNull
    @Size(max = 255)
    private String value;

    // Cleaner way to do this would be a custom annotation ,with enums or etc.
    @Pattern(regexp = "^(Includes|Exact|Ends with|Starts with)$")
    private String operator;

    public TitleFilterDto() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
