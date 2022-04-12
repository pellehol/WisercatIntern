import React from 'react';
import PropTypes from 'prop-types';

/*
 Component responsible for creating a table
 for each of the filters received from the get request.
 */


export default function ExistingFilters({filters}) {
  /* Returns all existing filters as tables */
  return (
    <div className="all-filters">
      {/* Map all filters*/}
      {filters.map((filter, idx) => {
        return (
          <div key={idx} className="one-filter">
            <div className="filter-name"><h1>{filter.filtername}</h1></div>
            {filter.dateFilter.length !== 0 && <div className="filter-type"><p>Date</p></div>}
            {/* Map all date filters in a filter*/}
            {filter.dateFilter.map((fil, i) => {
              return (
                <div className="filter-values" key={'d' + i}>
                  <div>
                    <p>Criteria: </p>
                    <p>{fil.operator}</p>
                  </div>
                  <div>
                    <p>Input:</p>
                    <p>{fil.value}</p>
                  </div>

                </div>
              );
            })}
            {filter.titleFilter.length !== 0 && <div className="filter-type"><p>Title</p></div>}
            {/* Map all title filters in a filter*/}
            {filter.titleFilter.map((fil, i) => {
              return (
                <div className="filter-values" key={'t' + i}>
                  <div>
                    <p>Criteria: </p>
                    <p>{fil.operator}</p>
                  </div>
                  <div>
                    <p>Input:</p>
                    <p>{fil.value}</p>
                  </div>
                </div>
              );
            })}
            {filter.amountFilter.length !== 0 && <div className="filter-type"><p>Amount</p></div>}
            {/* Map all amount filters in a filter*/}
            {filter.amountFilter.map((fil, i) => {
              return (
                <div className="filter-values" key={'a' + i}>
                  <div>
                    <p>Criteria: </p>
                    <p>{fil.operator}</p>
                  </div>
                  <div>
                    <p>Input:</p>
                    <p>{fil.value}</p>
                  </div>
                </div>
              );
            })}
          </div>);
      })}
    </div>
  );
}

ExistingFilters.propTypes = {
  filters: PropTypes.array
};
