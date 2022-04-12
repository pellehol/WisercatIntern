package com.example.filterbackend.controllers;

import com.example.filterbackend.mappers.DtoMapper;
import com.example.filterbackend.mappers.JpaContext;
import com.example.filterbackend.enitities.Filter;
import com.example.filterbackend.dtos.FilterDto;
import com.example.filterbackend.services.FiltersService;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


/**
 * Class containing REST endpoints.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/filter")
public class FilterController {

    private final FiltersService filtersService;
    private final DtoMapper dtoMapper;
    private final HttpHeaders responseHeaders = new HttpHeaders();


    @Autowired
    public FilterController(FiltersService filtersService, DtoMapper dtoMapper) {
        this.filtersService = filtersService;
        this.dtoMapper = dtoMapper;
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);

    }

    /**
     * Endpoint to get all Filters.
     *
     * @return all filters.
     */
    @GetMapping(value = "", produces = {"application/json"})
    public List<FilterDto> getAllFilters() {

        // Find all filters, map them to DTO-s and return

        return filtersService.findAll().stream().map(dtoMapper::map).collect(Collectors.toList());
    }

    /**
     * Endpoint to post a filter.
     *
     * @param filterDto Request body.
     * @return Response detailing the status of the request.
     */
    @PostMapping(value = "/add", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<FilterDto> saveFilter(@Valid @RequestBody FilterDto filterDto, BindingResult bindingResult) {

        // In case of validation errors
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().headers(responseHeaders).body(filterDto);
        }

        // In case of no criteria at all in post body
        if (filterDto.getDateFilter().isEmpty() && filterDto.getAmountFilter().isEmpty() && filterDto.getTitleFilter().isEmpty()) {
            return ResponseEntity.badRequest().headers(responseHeaders).body(filterDto);
        }

        // JPA context for bidirectional mapping
        JpaContext jpaCtx = new JpaContext(null);

        // Map to Entity
        Filter filter = DtoMapper.MAPPER.toEntity(filterDto, jpaCtx);

        // Save
        Filter res = filtersService.saveFilter(filter);

        // Map back to DTO
        FilterDto dto = dtoMapper.map(res);

        return ResponseEntity.ok().headers(responseHeaders).body(dto);
    }

}
