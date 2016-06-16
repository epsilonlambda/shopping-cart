import * as apiRequester from '../../helpers/apiRequester.js';
import orderedProductRepo from '../../orderedProductsRepository.js';
import _ from 'lodash';

function addToCart(product, qty, orderedItems) {
    return (dispatch) => {
        apiRequester.apiRequest({path: '/api/v1/me', authenticate: true, success: (user) => {
            const requestBody = {
                product,
                owner: {id: user.id},
                quantity: qty
            };

            const existingOrder = _.find(orderedItems, item => item.product.id === product.id);
            
            if(existingOrder === undefined) {
                dispatch(orderedProductRepo.actionCreators.create(requestBody));
            }
            else {
                requestBody.quantity += existingOrder.quantity;
                dispatch(orderedProductRepo.actionCreators.update(product.id, requestBody));
            }
        }});
    };
}

export default {
    addToCart
};