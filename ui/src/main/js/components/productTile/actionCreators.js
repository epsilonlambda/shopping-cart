import * as apiRequester from '../../helpers/apiRequester.js';
import orderedProductRepo from '../../orderedProductsRepository.js';

function addToCart(product) {
    return (dispatch) => {
        apiRequester.apiRequest({path: '/api/v1/me', authenticate: true, success: (user) => {
            const requestBody = {
                product,
                owner: {id: user.id},
                quantity: 1
            };
            
            dispatch(orderedProductRepo.actionCreators.create(requestBody));
        }});
    };
}

export default {
    addToCart
};