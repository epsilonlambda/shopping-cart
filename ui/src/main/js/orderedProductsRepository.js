import createRepository from './repository';

const repo = createRepository({
    repositoryId: 'ORDERED_ITEMS',
    authenticate: true,
    endpoint: '/api/v1/ordered_products'
});

export default repo;
    