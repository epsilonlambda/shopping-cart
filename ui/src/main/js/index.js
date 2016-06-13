/**
 * Created by Kirill on 6/8/2016.
 */

import Catalog from './components/catalog.js';
import ReactDOM from 'react-dom';
import React from 'react';
import $ from 'jquery';
import {IntlProvider} from 'react-intl';

import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
import 'bootstrap/dist/css/bootstrap-theme.min.css';


$(document).ready(() => {
    const container = $(document.body).append('<div />');
    // TODO: [ET-11] Factor out the app root component?
    $.get('/api/v1/products', (products) => {
            ReactDOM.render(
                <IntlProvider>
                    <Catalog products={products}/>
                </IntlProvider>,
                container[0]);
        }
    );
});
