import * as apiRequester from '../../helpers/apiRequester.js';

function fetchItems() {
    return (dispatch) => 
        apiRequester.apiRequest({path: '/api/v1/ordered_products', authenticate: true, success: (orderItems) => dispatch(loadFetchedItems(orderItems))});
}

function loadFetchedItems(orderItems) {
    return {
        type: 'SCL_LOAD_FETCHED_ITEMS',
        orderItems
    };
}

export default {
    fetchItems
};
    

