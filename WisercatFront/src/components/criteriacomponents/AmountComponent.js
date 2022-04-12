import React from 'react';
import PropTypes from 'prop-types';


export default function AmountComponent({defaultValue, register, index, errors}) {
  return (
    <>
      <div className="row-select">
        <select name={`inputs[${index}].operator`}
          {...register(`inputs[${index}].operator`)}
          defaultValue={`${defaultValue.operator}`}>
          <option value="Equal">
                        Equal
          </option>
          <option value="Not Equal">
                        Not Equal
          </option>
          <option value="Greater">
                        Greater
          </option>
          <option value="Less">
                        Less
          </option>
          <option value="Greater or equal">
                        Greater or equal
          </option>
          <option value="Less or equal">
                        Less or equal
          </option>
        </select>
        <p className="p-error">{errors.inputs?.[index]?.operator?.message}</p>
      </div>
      <div className="row-select">
        <input name={`inputs[${index}].userinput`}
          {...register(`inputs[${index}].userinput`)}
          type="number"/>
        <p className="p-error">{errors.inputs?.[index]?.userinput?.message}</p>
      </div>

    </>
  );
}

AmountComponent.propTypes =
    {
      defaultValue: PropTypes.object,
      register: PropTypes.func,
      index: PropTypes.number,
      errors: PropTypes.object
    };
