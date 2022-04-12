package com.example.filterbackend.mappers;

import com.example.filterbackend.enitities.AmountFilter;
import com.example.filterbackend.enitities.DateFilter;
import com.example.filterbackend.enitities.Filter;
import com.example.filterbackend.enitities.TitleFilter;
import com.example.filterbackend.dtos.*;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


/**
 * Class responsible for mapping dto-s to entity models and entity models to dto-s.
 */
@Mapper(componentModel = "spring")
public interface DtoMapper {

    DtoMapper MAPPER = Mappers.getMapper(DtoMapper.class);


    @Mapping(source = "dateFilter", target = "dateFilter")
    @Mapping(source = "amountFilter", target = "amountFilter")
    @Mapping(source = "titleFilter", target = "titleFilter")
    FilterDto map(Filter filter);

    TitleFilterDto map(TitleFilter titleFilter);

    AmountFilterDto map(AmountFilter amountFilter);

    DateFilterDto map(DateFilter dateFilter);


    @Mapping(target = "id", ignore = true)
    Filter toEntity(FilterDto filter, @Context JpaContext ctx);

    @Mapping(target = "filter", ignore = true)
    @Mapping(target = "id", ignore = true)
    DateFilter toEntity(DateFilterDto dateFilter, @Context JpaContext ctx);

    @Mapping(target = "filter", ignore = true)
    @Mapping(target = "id", ignore = true)
    AmountFilter toEntity(AmountFilterDto amountFilter, @Context JpaContext ctx);

    @Mapping(target = "filter", ignore = true)
    @Mapping(target = "id", ignore = true)
    TitleFilter toEntity(TitleFilterDto titleFilter, @Context JpaContext ctx);

}
