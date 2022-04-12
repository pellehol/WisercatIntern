package com.example.filterbackend.services;

import com.example.filterbackend.enitities.Filter;
import com.example.filterbackend.repositories.FilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class dealing with persistence.
 */

@Service
public class FiltersService {

    private final FilterRepository filterRepository;

    @Autowired
    FiltersService(FilterRepository filterRepository) {
        this.filterRepository = filterRepository;
    }

    /**
     * Save filter to database.
     *
     * @param filter Filter to save.
     * @return Result of persistence.
     */
    public Filter saveFilter(Filter filter) {
        return filterRepository.save(filter);
    }

    /**
     * Find all filters.
     *
     * @return List of all filters in database.
     */
    public List<Filter> findAll() {
        return filterRepository.findAll();
    }

}
