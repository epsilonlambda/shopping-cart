/**
 * 
 * Created by Kirill on 6/15/2016.
 */

import {combineReducers} from 'redux';
import orderedProductsRepo from '../orderedProductsRepository.js';

const appReducer = combineReducers({
    orderedProductsRepo: orderedProductsRepo.reducer
});

export default appReducer;
