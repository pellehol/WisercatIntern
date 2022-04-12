import React from 'react';
import RowComponent from './RowComponent';
import 'babel-regenerator-runtime';
import {useFieldArray, useForm} from 'react-hook-form';
import {yupResolver} from '@hookform/resolvers/yup';
import * as yup from 'yup';
import {SERVER_ADDRESS} from '../ApiContext';
import PropTypes from 'prop-types';

export default function Form({onBack, newFilter}) {
  /* Client side validation schema for the form */
  const schema = yup.object().shape({
    filtername: yup.string().required('Name is required').max(25, 'Max length is 25'),
    inputs: yup.array().of(
        yup.object().shape({
          filterType: yup.string().required('Criteria is required'),
          operator: yup.string().required('Comperator is required'),
          /* Validation applied depends on the criteria selected */
          userinput: yup.mixed()
              .when('filterType', {is: 'Amount', then: yup.number()
                  .integer('Must be an integer').typeError('Number is required')
                  .required('number')
                  .test('Max digits', 'Max digits is 10', (userinput) => String(userinput).length <= 10)})
              .when('filterType',
                  {is: 'Title', then: yup.string().required('String is required').max(255, 'Max length is 255')})
              .when('filterType',
                  {is: 'Date', then: yup.date().typeError('Date is required').required('Date is required')})
        })
    )
  });

  /* Form configuration */
  const {register, control, watch, handleSubmit, formState: {errors}} = useForm({
    resolver: yupResolver(schema),
    shouldUnregister: true,
    defaultValues: {
      filtername: '',
      inputs: [{filterType: 'Amount', operator: '', userinput: ''}]
    }
  });

  /* Form field array to handle the dynamic form */
  const {fields, append, remove} = useFieldArray(
      {
        control,
        name: 'inputs'
      }
  );

  /* Model form data for the API. */
  const submitData = {
    filtername: '',
    dateFilter: [],
    titleFilter: [],
    amountFilter: []
  };


  /* Map form data and post it to API */
  const postFilter = async (data) =>{
    submitData.filtername = data.filtername;
    for (let i = 0; i < data.inputs.length; i++) {
      if (data.inputs[i].filterType === 'Amount') {
        submitData.amountFilter.push({operator: data.inputs[i].operator, value: data.inputs[i].userinput});
      } else if (data.inputs[i].filterType === 'Title') {
        submitData.titleFilter.push({operator: data.inputs[i].operator, value: data.inputs[i].userinput});
      } else {
        submitData.dateFilter.push({operator: data.inputs[i].operator, value: data.inputs[i].userinput});
      }
    }

    /* Create POST request with form information */
    fetch(SERVER_ADDRESS +'/filter/add', {
      method: 'POST',
      mode: 'cors',
      headers: {'Content-Type': 'application/json'},
      body: JSON.stringify(submitData)
    }).then(async (response) => {
      const isJson = response.headers.get('content-type')?.includes('applications/json');
      const data = isJson && await response.json();

      /* Handle http errors */
      if (!response.ok) {
        const error = (data && data.message) || response.status;
        alert(error);
        return Promise.reject(error);
      }
      newFilter(response);
      /* Handle network errors */
    }).catch((error) => {
      alert('Post request failed due to connection error, data not submitted.');
    });
  };


  /* Handle closing modal via back button */
  const handleBack = (e) =>{
    onBack(e);
  };


  return (
    <div className="formCont">
      <form onSubmit={handleSubmit(postFilter)}>
        <div className="biggest">
          <div className="content">
            <div className="form-labels">
              <p className="label-1">Filter name </p>
              <p className="label-2">Criteria </p>
            </div>
            <div className="form-content">
              <div className="form-filtername">
                <input {...register('filtername')}/>
                <p className="p-error">{errors.filtername?.message}</p>
              </div>
              {/* For each added row map criteria, comparator and input */}
              {fields.map((item, index) => (
                <div className="form-fields-wrapper" key={item.id}>
                  <RowComponent defaultValue={item} register={register} index={index} watch={watch} errors={errors}/>
                  <button className="remove-button" type="button" onClick={() => remove(index)}>[-]</button>
                </div>
              ))}
              <div className="append-button">
                {/* Add new row */}
                <button type="button" onClick={() => {
                  append({filterType: 'Amount', operator: '', userinput: ''});
                }}>+ ADD ROW
                </button>
              </div>
            </div>
          </div>
          <div className="form-footer">
            <button type='submit'>Save</button>
            <button type="button" onClick={handleBack}>Back</button>
          </div>
        </div>
      </form>
    </div>
  );
}

Form.propTypes = {
  onBack: PropTypes.func,
  newFilter: PropTypes.func
};
