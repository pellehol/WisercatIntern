import React from 'react';
import PropTypes from 'prop-types';
import AmountComponent from './criteriacomponents/AmountComponent';
import TitleComponent from './criteriacomponents/TitleComponent';
import DateComponent from './criteriacomponents/DateComponent';

/*
    Component responsible for handling criteria, comparators and inputs.
    Comparators, criteria and inputs are registered to Form.
 */

export default function RowComponent({defaultValue, register, index, watch, errors}) {
  /*
        Watches which kind of criteria is selected
        and changes inputs and comparators accordingly.
       */
  const watchType = watch(`inputs[${index}].filterType`);

  return (
    <>
      <div className="row-select">
        {/* Criteria selection, default amount */}
        <select name={`inputs[${index}].filterType`}
          {...register(`inputs[${index}].filterType`)}
          defaultValue={`${defaultValue.filterType}`}>
          <option value="Amount">Amount</option>
          <option value="Title">Title</option>
          <option value="Date">Date</option>
        </select>
        <p className="p-error">{errors.inputs?.[index]?.filterType?.message}</p>
      </div>
      {/* In case of amount criteria */}
      {watchType === 'Amount' &&
      <AmountComponent defaultValue={defaultValue} register={register} index={index} errors={errors}/>
      }
      {/* In case of title criteria */}
      {watchType === 'Title' &&
      <TitleComponent defaultValue={defaultValue} register={register} index={index} errors={errors}/>}
      {/* In case of date criteria */}
      {watchType === 'Date' &&
      <DateComponent defaultValue={defaultValue} register={register} index={index} errors={errors}/>}
    </>
  );
}

RowComponent.propTypes =
{
  defaultValue: PropTypes.object,
  register: PropTypes.func,
  index: PropTypes.number,
  watch: PropTypes.func,
  errors: PropTypes.object
};
