import actionTypeCreators from './actionTypes.js';
export default function createReducer(repositoryId) {
    const actionTypes = actionTypeCreators(repositoryId);

    return function(state = {items: []}, action) {
        if (action === undefined) return state;
        
        switch(action.type) {
            case actionTypes.REFRESH:
                return {
                    ...state,
                    items: action.payload
                };
            default:
                return state;
        }
    };
}