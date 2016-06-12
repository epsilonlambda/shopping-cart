/**
 * Created by Kirill on 6/11/2016.
 */

import React from 'react';
import {PropTypes} from 'react';
import {Button} from 'react-bootstrap';
import {FormattedNumber} from 'react-intl';
import './productTile.css';

export default class ProductTile extends React.Component {
    static propTypes = {
        name: PropTypes.string.isRequired,
        description: PropTypes.string,
        price: PropTypes.number.isRequired,
        imageUrl: PropTypes.string.isRequired
    };

    render() {
        const {name, description, price, imageUrl} = this.props;

        return (
            <div className="esc-product-tile">
                <img src={imageUrl} />
                <div className="esc-gen-title">{name}</div>
                <div className="esc-gen-desc">{description}</div>
                <div className="esc-gen-price">
                    <FormattedNumber style="currency" currency="CAD" value={price} />
                </div>
                <Button className="esc-gen-add-to-cart-btn">Add to cart</Button>
            </div>
        )
    }
}
