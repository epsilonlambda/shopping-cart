import React from 'react';
import {Button} from 'react-bootstrap';
import store from '../../redux/store.js';
import actionCreators from './actionCreators.js';

export default class OrderItemTile extends React.Component {
    static propTypes = {
        product: React.PropTypes.object.isRequired,
        quantity: React.PropTypes.number.isRequired
    };
    
    render() {
        const { product, quantity } = this.props;
        
        return (
            <div className="esc-order-item-tile">
                <div className="esc-gen-product-name">{product.name}</div>
                <div className="esc-gen-amounts">
                    {quantity} x {product.price} = {quantity*product.price}
                </div>
                <Button onClick={() => store.dispatch(actionCreators.deleteItem(product.id))}>
                    Remove
                </Button>
            </div>
        );
    }
}