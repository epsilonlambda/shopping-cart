/**
 * 
 * Created by Kirill on 6/15/2016.
 */

import {combineReducers} from 'redux';
import shoppingCartLinkReducer from '../components/shoppingCartLink/reducer.js';

const appReducer = combineReducers({
    shoppingCartLink: shoppingCartLinkReducer
});

export default appReducer;
