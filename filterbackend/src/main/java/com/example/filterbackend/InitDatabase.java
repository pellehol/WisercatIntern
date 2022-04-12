package com.example.filterbackend;


import com.example.filterbackend.enitities.AmountFilter;
import com.example.filterbackend.enitities.DateFilter;
import com.example.filterbackend.enitities.Filter;
import com.example.filterbackend.enitities.TitleFilter;
import com.example.filterbackend.repositories.FilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Add some test data to the database.
 */

@Component
public class InitDatabase implements ApplicationRunner {
    private final FilterRepository filterRepository;

    @Autowired
    public InitDatabase(FilterRepository filterRepository) {
        this.filterRepository = filterRepository;
    }

    public void run(ApplicationArguments args) throws ParseException {
        Filter filter = new Filter("MyFilter");
        AmountFilter amountFilter1 = new AmountFilter(924342L, "Greater", filter);
        AmountFilter amountFilter2 = new AmountFilter(64L, "Equal", filter);
        List<AmountFilter> amountsFilters = new ArrayList<>();
        amountsFilters.add(amountFilter1);
        amountsFilters.add(amountFilter2);
        filter.setAmountFilter(amountsFilters);

        TitleFilter titleFilter = new TitleFilter("Shakespeare", "Starts with", filter);
        List<TitleFilter> titleFilters = new ArrayList<>();
        titleFilters.add(titleFilter);
        filter.setTitleFilter(titleFilters);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse("2022-04-05");
        DateFilter dateFilter = new DateFilter(date, "From", filter);
        List<DateFilter> dateFilterList = new ArrayList<>();
        dateFilterList.add(dateFilter);
        filter.setDateFilter(dateFilterList);

        Filter filter1 = new Filter("MySecondFilter");
        AmountFilter amountFilter3 = new AmountFilter(924342L, "Greater", filter1);
        List<AmountFilter> amountsFilters1 = new ArrayList<>();
        amountsFilters1.add(amountFilter3);
        filter1.setAmountFilter(amountsFilters1);
        filterRepository.save(filter);
        filterRepository.save(filter1);
    }
}
