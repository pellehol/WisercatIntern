package com.example.filterbackend.enitities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * Entity to model database data
 */
@Entity
@Table(name = "filter")
public class Filter implements Serializable {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "filtername")
    private String filtername;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "filter")
    private List<DateFilter> dateFilter;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "filter")
    private List<TitleFilter> titleFilter;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "filter")
    private List<AmountFilter> amountFilter;

    public Filter(String filtername, List<DateFilter> dateFilter, List<TitleFilter> titleFilter, List<AmountFilter> amountFilter) {
        this.filtername = filtername;
        this.dateFilter = dateFilter;
        this.titleFilter = titleFilter;
        this.amountFilter = amountFilter;
    }

    public Filter(String filtername) {
        this.filtername = filtername;
    }

    public Filter() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFiltername() {
        return filtername;
    }

    public void setFiltername(String filtername) {
        this.filtername = filtername;
    }

    public List<DateFilter> getDateFilter() {
        return dateFilter;
    }

    public void setDateFilter(List<DateFilter> dateFilter) {
        this.dateFilter = dateFilter;
    }

    public List<TitleFilter> getTitleFilter() {
        return titleFilter;
    }

    public void setTitleFilter(List<TitleFilter> titleFilter) {
        this.titleFilter = titleFilter;
    }

    public List<AmountFilter> getAmountFilter() {
        return amountFilter;
    }

    public void setAmountFilter(List<AmountFilter> amountFilter) {
        this.amountFilter = amountFilter;
    }


    @Override
    public String toString() {
        return "Filter{" +
                "id=" + id +
                ", filtername='" + filtername + '\'' +
                ", dateFilter=" + dateFilter +
                ", titleFilter=" + titleFilter +
                ", amountFilter=" + amountFilter +
                '}';
    }
}
