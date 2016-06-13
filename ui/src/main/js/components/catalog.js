/**
 *
 * Created by Kirill on 6/9/2016.
 */

import React from 'react';
import {PropTypes} from 'react';
import ProductTile from './productTile';

export default class Catalog extends React.Component {
    static propTypes = {
        products: PropTypes.array.isRequired
    };
    
    renderProducts(products) {
        return products.map(p => (
            <ProductTile name={p.name} description={p.description} price={p.price} imageUrl={p.image} />
        ));
    }

    render() {
        const {products} = this.props;
        return(
            <div>
                <h1>Product Catalog</h1>
                {this.renderProducts(products)}
            </div>
        );
        
    }
}
