import * as apiRequester from '../../helpers/apiRequester.js';
import orderedItemsRepo from '../../orderedProductsRepository.js';
import actionTypes from './actionTypes.js';

function submitOrder() {
    return (dispatch) => {
        apiRequester.apiRequest({method: 'POST', path: '/api/v1/rpc/submit_order', success: () => {
            dispatch(orderedItemsRepo.actionCreators.retrieveAll());
            dispatch(openConfirmDialog());
        }})
    }
}

function openConfirmDialog() {
    return {
        type: actionTypes.OPEN_ORDER_CONFIRMATION
    };
}

function closeConfirmDialog() {
    return {
        type: actionTypes.CLOSE_ORDER_CONFIRMATION
    };
}

export default {
    submitOrder,
    closeConfirmDialog
};