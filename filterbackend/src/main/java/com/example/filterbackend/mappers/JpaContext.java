package com.example.filterbackend.mappers;

import com.example.filterbackend.enitities.AmountFilter;
import com.example.filterbackend.enitities.DateFilter;
import com.example.filterbackend.enitities.Filter;
import com.example.filterbackend.enitities.TitleFilter;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;

import javax.persistence.EntityManager;

/**
 * Class responsible for mapping dto-s to entity models taking in account JPA context.
 */
public class JpaContext {
    private final EntityManager em;

    private Filter filter;

    public JpaContext(EntityManager em) {
        this.em = em;
    }

    @BeforeMapping
    public void setEntity(@MappingTarget Filter filter) {
        this.filter = filter;
    }

    @AfterMapping
    public void establishRelation(@MappingTarget AmountFilter amountFilter) {
        amountFilter.setFilter(filter);
    }

    @AfterMapping
    public void establishRelation(@MappingTarget DateFilter dateFilter) {
        dateFilter.setFilter(filter);
    }

    @AfterMapping
    public void establishRelation(@MappingTarget TitleFilter titleFilter) {
        titleFilter.setFilter(filter);
    }
}
