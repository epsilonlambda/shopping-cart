/**
 * Created by Kirill on 6/15/2016.
 */

import {createStore, applyMiddleware} from 'redux';
import appReducer from './reducer.js';
import thunkMiddleware from 'redux-thunk';

const store = createStore(appReducer, applyMiddleware(thunkMiddleware));

export default store;