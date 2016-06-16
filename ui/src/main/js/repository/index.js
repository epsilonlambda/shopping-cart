import createActions from './actionCreators.js';
import createReducer from './reducerCreator.js';

export default function createRepository({repositoryId, endpoint, authenticate}) {
    const actionCreators = createActions(repositoryId, endpoint, authenticate);
    const reducer = createReducer(repositoryId);
    
    return {
        actionCreators,
        reducer
    };
}