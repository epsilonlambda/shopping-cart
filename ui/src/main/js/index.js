/**
 * Created by Kirill on 6/8/2016.
 */

import Catalog from './components/catalog.js';
import ReactDOM from 'react-dom';
import React from 'react';
import $ from 'jquery';

import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';
import 'bootstrap/dist/css/bootstrap-theme.min.css';

$(document).ready(() => {
    const container = $(document.body).append('<div />');
    $.get('/api/v1/products', (products) => {
            ReactDOM.render(<Catalog products={products}/>, container[0]);
        }
    );
});
