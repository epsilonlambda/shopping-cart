import orderedItemsRepo from '../../orderedProductsRepository.js'

function deleteItem(productId) {
    return orderedItemsRepo.actionCreators.remove(productId);
}

export default {
    deleteItem
};