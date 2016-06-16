import React from 'react';
import OrderItemTile from '../orderItemTile';
import {connect} from 'react-redux';

@connect(state => ({orderItems: state.orderedProductsRepo.items}))
export default class OrderSummary extends React.Component {
    static propTypes = {
        orderItems: React.PropTypes.array.isRequired
    };
    
    render() {
        return (
            <div>
                {this.props.orderItems.map(item => <OrderItemTile product={item.product} quantity={item.quantity} />)}
            </div>);
    }
}