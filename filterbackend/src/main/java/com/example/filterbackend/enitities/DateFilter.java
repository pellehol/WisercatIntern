package com.example.filterbackend.enitities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * Entity to model database data
 */
@Entity
@Table(name = "datefilters")
public class DateFilter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "value")
    private Date value;

    @Column(name = "operator")
    private String operator;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filter_id", nullable = false)
    private Filter filter;

    public DateFilter(Date value, String operator, Filter filter) {
        this.value = value;
        this.operator = operator;
        this.filter = filter;
    }

    public DateFilter() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "DateFilter{" +
                "Id=" + Id +
                ", value='" + value + '\'' +
                ", operator='" + operator + '\'' +
                ", filter=" + filter +
                '}';
    }
}
