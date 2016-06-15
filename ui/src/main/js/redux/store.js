/**
 * Created by Kirill on 6/15/2016.
 */

import {createStore} from 'redux';
import appReducer from './reducer.js';

const store = createStore(appReducer);

export default store;