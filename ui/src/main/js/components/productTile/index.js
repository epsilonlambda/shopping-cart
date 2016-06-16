/**
 * Created by Kirill on 6/11/2016.
 */

import React from 'react';
import {PropTypes} from 'react';
import {Button} from 'react-bootstrap';
import {FormattedNumber} from 'react-intl';
import './productTile.css';
import {connect} from 'react-redux';
import actionCreators from './actionCreators.js';
import store from '../../redux/store.js';

export default class ProductTile extends React.Component {
    static propTypes = {
        id: PropTypes.number.isRequired,
        name: PropTypes.string.isRequired,
        description: PropTypes.string,
        price: PropTypes.number.isRequired,
        imageUrl: PropTypes.string.isRequired
    };

    render() {
        const {name, description, price, imageUrl, addToCart, id} = this.props;

        return (
            <div className="esc-product-tile">
                <img src={imageUrl} />
                <div className="esc-gen-title">{name}</div>
                <div className="esc-gen-desc">{description}</div>
                <div className="esc-gen-price">
                    <FormattedNumber style="currency" currency="CAD" value={price} />
                </div>
                <Button className="esc-gen-add-to-cart-btn" onClick={() => store.dispatch(actionCreators.addToCart(this.props))}>Add to cart</Button>
            </div>
        )
    }
}
