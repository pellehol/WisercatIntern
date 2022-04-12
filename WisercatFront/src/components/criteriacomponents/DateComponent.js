import React from 'react';
import PropTypes from 'prop-types';

export default function DateComponent({defaultValue, register, index, errors}) {
  return (
    <>
      <div className="row-select">
        <select name={`inputs[${index}].operator`}
          {...register(`inputs[${index}].operator`)}
          defaultValue={`${defaultValue.operator}`}>
          <option value="From">
                        From
          </option>
          <option value="To">
                        To
          </option>
        </select>
        <p className="p-error">{errors.inputs?.[index]?.operator?.message}</p>
      </div>
      <div className="row-select">
        <input name={`inputs[${index}].userinput`} {...register(`inputs[${index}].userinput`)} type="date"/>
        <p className="p-error">{errors.inputs?.[index]?.userinput?.message}</p>
      </div>
    </>
  );
}

DateComponent.propTypes =
    {
      defaultValue: PropTypes.object,
      register: PropTypes.func,
      index: PropTypes.number,
      errors: PropTypes.object
    };
