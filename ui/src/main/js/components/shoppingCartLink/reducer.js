export default function(state = {orderItems: []}, action) {
    if(!action) return state;
    
    switch(action.type) {
        case 'SCL_LOAD_FETCHED_ITEMS':
            return {
                ...state,
                orderItems: action.orderItems
            };
        default:
            return state;
    }
}