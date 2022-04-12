import React, {useState} from 'react';
import Modal from 'react-modal';
import '../css/index.scss';

import Form from './components/Form';
import ExistingFilters from './components/ExistingFilters';
import {SERVER_ADDRESS} from './ApiContext';


export default function App() {
  /* State for toggling the modal */
  const [showModal, setShowModal] = useState(false);

  /* State for holding the existing filters */
  const [filterList, setFilterList] = useState({filters: []});

  /* Close or open the modal window */
  function toggleModal() {
    setShowModal(!showModal);
  }

  /* On first render get existing filters and display them*/
  React.useEffect(() => {
    getFilters();
  }, []);


  /* When a new filter is added in the modal close it and update existing filters */
  function newFilterAdded() {
    toggleModal();
    getFilters();
  }

  /* GET request to the api to get existing filters */
  function getFilters() {
    fetch(SERVER_ADDRESS + '/filter').then(async (response) => {
      const data = await response.json();

      /* Handles http errors */
      if (!response.ok) {
        const error = response.statusText;
        alert(error);
        return Promise.reject(error);
      }

      /* Updates existing filter list */
      setFilterList({filters: data});

      /* Handles network errors */
    }).catch((error) => {
      alert(error);
    });
  }


  return (
    <section className="app">
      <div className="header">
        <button onClick={toggleModal}>Add new filter</button>
      </div>
      {/* Render modal with the form */}
      <Modal
        isOpen={showModal}
        onRequestClose={toggleModal}
        contentLabel="New filter"
        className="modal"
        appElement={document.getElementById('root') || undefined}
      >
        <div className="form-wrapper">
          <div className="form-header">
            <h4>Filter</h4>
            <h3 onClick={toggleModal}>X</h3>
          </div>
          <Form onBack={toggleModal} newFilter={newFilterAdded}/>
        </div>
      </Modal>
      {/* Render existing filters */}
      <div>
        <ExistingFilters filters={filterList.filters}/>
      </div>
    </section>
  );
}
