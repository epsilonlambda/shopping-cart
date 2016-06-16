import React from 'react';
import {Button} from 'react-bootstrap';
import store from '../../redux/store.js';
import actionCreators from './actionCreators.js';
import QuantityControl from '../quantityControl';

export default class OrderItemTile extends React.Component {
    static propTypes = {
        product: React.PropTypes.object.isRequired,
        quantity: React.PropTypes.number.isRequired
    };
    
    constructor(props) {
        super(props);
        
        this.state = { newQuantity: props.quantity };
    }
    
    componentWillReceiveProps(props) {
        this.setState({newQuantity: props.quantity});
    }
    
    render() {
        const { product, quantity } = this.props;
        
        return (
            <div className="esc-order-item-tile">
                <div className="esc-gen-product-name">{product.name}</div>
                <div className="esc-gen-amounts">
                    {quantity} x {product.price} = {quantity*product.price}
                </div>
                <QuantityControl value={this.state.newQuantity} onChange={(value) => this.setState({newQuantity: value})} />
                <Button onClick={() => store.dispatch(actionCreators.changeItemQuantity(product, this.state.newQuantity))}>
                    Change
                </Button>
                <Button onClick={() => store.dispatch(actionCreators.deleteItem(product.id))}>
                    Remove
                </Button>
            </div>
        );
    }
}