package com.example.filterbackend.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DTO to model frontend data
 */
public class FilterDto implements Serializable {

    @NotEmpty
    @NotNull
    @Size(max = 25)
    private String filtername;

    @Valid
    private List<DateFilterDto> dateFilter = new ArrayList<>();

    @Valid
    private List<TitleFilterDto> titleFilter = new ArrayList<>();;

    @Valid
    private List<AmountFilterDto> amountFilter = new ArrayList<>();;



    public FilterDto() {
    }

    public String getFiltername() {
        return filtername;
    }

    public void setFiltername(String filtername) {
        this.filtername = filtername;
    }

    public List<DateFilterDto> getDateFilter() {
        return dateFilter;
    }

    public void setDateFilter(List<DateFilterDto> dateFilter) {
        this.dateFilter = dateFilter;
    }

    public List<TitleFilterDto> getTitleFilter() {
        return titleFilter;
    }

    public void setTitleFilter(List<TitleFilterDto> titleFilter) {
        this.titleFilter = titleFilter;
    }

    public List<AmountFilterDto> getAmountFilter() {
        return amountFilter;
    }

    public void setAmountFilter(List<AmountFilterDto> amountFilter) {
        this.amountFilter = amountFilter;
    }


    @Override
    public String toString() {
        return "FilterDto{" +
                ", filtername='" + filtername + '\'' +
                ", dateFilter=" + dateFilter +
                ", titleFilter=" + titleFilter +
                ", amountFilter=" + amountFilter +
                '}';
    }
}





