import React from 'react';
import OrderItemTile from '../orderItemTile';
import {connect} from 'react-redux';
import {Button} from 'react-bootstrap';
import actionCreators from './actionCreators.js';
import Modal from 'react-modal';
import store from '../../redux/store.js';

@connect(state => ({orderItems: state.orderedProductsRepo.items, isDialogOpen: state.orderSummary.isDialogOpen}), () => actionCreators)
export default class OrderSummary extends React.Component {
    static propTypes = {
        orderItems: React.PropTypes.array.isRequired,
        submitOrder: React.PropTypes.func.isRequired,
        closeConfirmDialog: React.PropTypes.array.isRequired,
        isDialogOpen: React.PropTypes.bool.isRequired
    };
    
    componentWillMount() {
        Modal.setAppElement('body');
    }
    
    render() {
        const modalStyles = {
            content : {
                top                   : '50%',
                left                  : '50%',
                right                 : 'auto',
                bottom                : 'auto',
                marginRight           : '-50%',
                transform             : 'translate(-50%, -50%)'
            }
        };
        return (
            <div>
                <Button onClick={() => store.dispatch(actionCreators.submitOrder())}>Submit Order</Button>
                <Modal
                    isOpen={this.props.isDialogOpen}
                    style={modalStyles}
                    >
                    <h1>Thank you</h1>
                    <p>Your order has been submitted successfully.</p>
                    <Button onClick={() => store.dispatch(actionCreators.closeConfirmDialog())}>OK</Button>
                </Modal>
                {this.props.orderItems.map(item => <OrderItemTile product={item.product} quantity={item.quantity} />)}
            </div>);
    }
}