/**
 * Created by Kirill on 6/8/2016.
 */

import Catalog from './components/catalog.js';
import ShoppingCartLink from './components/shoppingCartLink';
import OrderSummary from './components/orderSummary';
import ReactDOM from 'react-dom';
import React from 'react';
import $ from 'jquery';
import {IntlProvider} from 'react-intl';
import {Provider} from 'react-redux';
import store from './redux/store.js';
import {Tabs, Tab} from 'react-bootstrap';


import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
import 'bootstrap/dist/css/bootstrap-theme.min.css';

import * as requester from './helpers/apiRequester.js';

import orderedProductsRepo from './orderedProductsRepository.js';


$(document).ready(() => {
    if(!requester.getToken()) {
        requester.tokenRequest({
            path: '/api/v1/rpc/anonymous_login', method: 'POST', success: () => {
                requester.apiRequest({path: '/api/v1/me', success: (data) => console.log(data), authenticate: true});
                store.dispatch(orderedProductsRepo.actionCreators.retrieveAll());
            }
        });
    }
    else {
        console.log('Saved session');
        requester.apiRequest({path: '/api/v1/me', success: (data) => console.log(data), authenticate: true});
        store.dispatch(orderedProductsRepo.actionCreators.retrieveAll());
    }
    
    
    const container = $(document.body).append('<div />');
    // TODO: [ET-11] Factor out the app root component?
    $.get('/api/v1/products', (products) => {
            ReactDOM.render(
                <Provider store={store}>
                    <IntlProvider>
                        <Tabs>
                            <Tab eventKey={1} title="Catalog">
                                <Catalog products={products}/>
                            </Tab>
                            <Tab eventKey={2} title={<ShoppingCartLink />}>
                                <h1>Your Order</h1>
                                <OrderSummary />
                            </Tab>
                        </Tabs>
                    </IntlProvider>
                </Provider>,
                container[0]);
        }
    );
});
