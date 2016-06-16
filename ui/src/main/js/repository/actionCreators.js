import * as apiRequester from '../helpers/apiRequester.js';
import createActionTypes from './actionTypes.js';

export default function createActionCreators(repositoryId, endpoint, authenticate) {
    const actionTypes = createActionTypes(repositoryId);
  
    function reloadData(items) {
        return {
            type: actionTypes.REFRESH,
            payload: items
        };
    }
    function refresh() {
        return (dispatch) => {
            apiRequester.apiRequest({
                method: 'GET',
                path: endpoint,
                authenticate,
                success: (items) => dispatch(reloadData(items))
            });
        };
    }
    
    function create(item) {
        return (dispatch) => {
            apiRequester.apiRequest({
                method: 'POST',
                path: endpoint,
                body: item,
                success: () => dispatch(refresh())
            });
        };
    }
    
    function update(id, item) {
        return (dispatch) => {
            apiRequester.apiRequest({
                method: 'PUT',
                path: endpoint + '/' + id,
                body: JSON.stringify(item),
                success: () => dispatch(refresh())
            });
        };
    }
    function remove(id, item) {
        return (dispatch) => {
            apiRequester.apiRequest({
                method: 'DELETE',
                path: endpoint + '/' + id,
                success: () => dispatch(refresh())
            });
        };
    }
    
    return {
        create,
        retrieveAll: refresh,
        update,
        remove
    };
}