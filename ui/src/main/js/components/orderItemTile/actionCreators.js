import orderedItemsRepo from '../../orderedProductsRepository.js'
import * as apiRequester from '../../helpers/apiRequester';
import orderedProductRepo from '../../orderedProductsRepository.js';

function deleteItem(productId) {
    return orderedItemsRepo.actionCreators.remove(productId);
}

function changeItemQuantity(product, quantity){
    return (dispatch) => {
        apiRequester.apiRequest({path: '/api/v1/me', authenticate: true, success: (user) => {
            const requestBody = {
                product,
                owner: user,
                quantity
            };

            dispatch(orderedProductRepo.actionCreators.update(product.id, requestBody));
        }});
    };
}

export default {
    deleteItem,
    changeItemQuantity
};