/**
 * Created by Kirill on 6/11/2016.
 */

import React from 'react';
import {PropTypes} from 'react';

export default class ProductTile extends React.Component {
    static propTypes = {
        name: PropTypes.string.isRequired,
        description: PropTypes.string,
        price: PropTypes.number.isRequired
    };

    render() {
        const {name, description, price} = this.props;

        return (
            <div class="esc-product-tile">
                <div class="esc-gen-title">{name}</div>
                <div class="esc-gen-desc">{description}</div>
                <div class="esc-gen-price">{price}</div>
            </div>
        )
    }
}
