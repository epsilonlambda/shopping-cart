export default function createActionTypes(repositoryId) {
  return {
    REFRESH: repositoryId + '_REFRESH'
  };
}