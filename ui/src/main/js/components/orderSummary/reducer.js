import actionTypes from './actionTypes.js';
export default function(state = {isDialogOpen: false}, action) {
    if(action === undefined) return state;
    
    switch(action.type){
        case actionTypes.OPEN_ORDER_CONFIRMATION:
            return {
                ...state,
                isDialogOpen: true
            };
        case actionTypes.CLOSE_ORDER_CONFIRMATION:
            return {
                ...state,
                isDialogOpen: false
            };
        default:
            return state;
    }
}