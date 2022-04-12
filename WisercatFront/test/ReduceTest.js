import {
  cityAdded,
  deleteEverything,
  initializer,
  reducer
} from '../src/reducerUtil';

describe('Add city', () =>{
  test('adds a city', () =>{
    const initialState = initializer();
    const state = reducer(initialState,
        cityAdded('Tartu'));
    expect(state.cities.length === 1);
  });
});

describe('Add city', () =>{
  test('adds a city', () =>{
    const initialState = initializer();
    const state = reducer(initialState,
        cityAdded('Tartu'));
    expect(state.cities === 'Tartu');
  });
});


const createStateWithCities = (cityAttributes) => reducer(initializer(), cityAdded(cityAttributes));

test('delete cities', () =>{
  const initialState = createStateWithCities('Tallinn');
  const state = reducer(initialState, deleteEverything());
  expect(state.cities.length === 0);
});


const createStateWithCitiesMany = (cityAttributes) => reducer(initializer(), cityAdded(cityAttributes));

test('add 3 cities', () =>{
  const initialState = createStateWithCitiesMany('Tallinn');
  const state = reducer(initialState, cityAdded('Tartu'));
  const state1 = reducer(state, cityAdded('Pärnu'));
  expect(state1.cities.length === 3);
});

const createStateWithCitiesManyMore = (cityAttributes) => reducer(initializer(), cityAdded(cityAttributes));

test('add 4 cities', () =>{
  const initialState = createStateWithCitiesManyMore('Tallinn');
  const state = reducer(initialState, cityAdded('Tartu'));
  const state1 = reducer(state, cityAdded('Pärnu'));
  const state2 = reducer(state1, cityAdded('Pärnu'));
  expect(state2.cities.length === 3);
});


const createStateWithCitiesManyMore1 = (cityAttributes) => reducer(initializer(), cityAdded(cityAttributes));

test('add 4 cities and test names', () =>{
  const initialState = createStateWithCitiesManyMore1('Tallinn');
  const state = reducer(initialState, cityAdded('Tartu'));
  const state1 = reducer(state, cityAdded('Pärnu'));
  const state2 = reducer(state1, cityAdded('Narva'));
  expect(state2.cities[0] === 'Narva' && state2.cities[0] === 'Pärnu' && state2.cities[0] === 'Tartu');
});


test('test unknown action', () =>{
  const initialState = initializer();
  const ele = 1;
  expect(() => {
    reducer(initialState, 1);
  }).toThrowError('Invalid');
});


