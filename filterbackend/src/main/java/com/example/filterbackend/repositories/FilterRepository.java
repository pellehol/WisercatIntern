package com.example.filterbackend.repositories;

import com.example.filterbackend.enitities.Filter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface responsible for persisting data to database
 */
public interface FilterRepository extends JpaRepository<Filter, Long> {
}
