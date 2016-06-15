import * as apiRequester from '../../helpers/apiRequester.js';

function deleteItem(productId) {
    return () => {
        apiRequester.apiRequest({
            path: '/api/v1/ordered_products/' + productId,
            authenticate: true,
            method: 'DELETE',
            success: () => console.log("TODO")
        });
    };
}

export default {
    deleteItem
};