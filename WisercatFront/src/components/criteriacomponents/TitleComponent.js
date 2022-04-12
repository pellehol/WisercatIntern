import React from 'react';
import PropTypes from 'prop-types';

export default function TitleComponent({defaultValue, register, index, errors}) {
  return (
    <>
      <div className="row-select">
        <select name={`inputs[${index}].operator`}
          {...register(`inputs[${index}].operator`)}
          defaultValue={`${defaultValue.operator}`}>
          <option value="Starts with">
                        Starts with
          </option>
          <option value="Includes">
                        Includes
          </option>
          <option value="Exact">
                        Exact
          </option>
          <option value="Ends with">
                        Ends with
          </option>
        </select>
        <p className="p-error">{errors.inputs?.[index]?.operator?.message}</p>
      </div>
      <div className="row-select">
        <input name={`inputs[${index}].userinput`} {...register(`inputs[${index}].userinput`)} type="text"/>
        <p className="p-error">{errors.inputs?.[index]?.userinput?.message}</p>
      </div>
    </>
  );
}

TitleComponent.propTypes =
    {
      defaultValue: PropTypes.object,
      register: PropTypes.func,
      index: PropTypes.number,
      errors: PropTypes.object
    };
