/**
 * 
 * Created by Kirill on 6/15/2016.
 */

import {combineReducers} from 'redux';
import orderedProductsRepo from '../orderedProductsRepository.js';
import orderSummaryReducer from '../components/orderSummary/reducer.js';

const appReducer = combineReducers({
    orderedProductsRepo: orderedProductsRepo.reducer,
    orderSummary: orderSummaryReducer
});

export default appReducer;
