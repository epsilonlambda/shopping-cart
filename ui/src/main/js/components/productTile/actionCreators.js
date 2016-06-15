import shoppingCartLinkActions from '../shoppingCartLink/actionCreators.js';
import * as apiRequester from '../../helpers/apiRequester.js';

function addToCart(product) {
    return (dispatch) => {
        apiRequester.apiRequest({path: '/api/v1/me', authenticate: true, success: (user) => {
            const requestBody = {
                product,
                owner: {id: user.id},
                quantity: 1
            };

            apiRequester.apiRequest({
                path: '/api/v1/ordered_products/' + product.id, method: 'POST', body: requestBody,
                authenticate: true, success: () => dispatch(shoppingCartLinkActions.fetchItems())
            });

        }});
    };
}

export default {
    addToCart
};