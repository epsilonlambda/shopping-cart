import React from 'react';
import _ from 'lodash';
import {connect} from 'react-redux';

@connect(state => ({ orderItems: state.orderedProductsRepo.items }))
export default class ShoppingCartLink extends React.Component {
    static propTypes = {
        orderItems: React.PropTypes.array
    };

    render() {
        const {orderItems} = this.props;

        const totalQty = _.reduce(_.map(orderItems, i => i.quantity), (acc, x) => acc + x, 0);
        
        return (<div>Shopping cart ({totalQty})</div>);
    }
}