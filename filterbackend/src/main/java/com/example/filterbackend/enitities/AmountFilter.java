package com.example.filterbackend.enitities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity to model database data
 */
@Entity
@Table(name = "amountfilters")
public class AmountFilter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "value")
    private Long value;

    @Column(name = "operator")
    private String operator;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filter_id", nullable = false)
    private Filter filter;

    public AmountFilter() {
    }

    public AmountFilter(Long value, String operator, Filter filter) {
        this.value = value;
        this.operator = operator;
        this.filter = filter;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
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
        return "AmountFilter{" +
                "Id=" + Id +
                ", value='" + value + '\'' +
                ", operator='" + operator + '\'' +
                ", filter=" + filter +
                '}';
    }
}
