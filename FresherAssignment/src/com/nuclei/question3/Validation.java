package com.nuclei.question3;

/**
 * The type Validation.
 */
public class Validation {

    /**
     * The State.
     */
    static ApplicationState state = ApplicationState.getInstance();

    /**
     * Validate parent and child ids boolean.
     *
     * @param parentId the parent id
     * @param childId  the child id
     * @return the boolean
     */
    public static boolean validateParentAndChildIds(int parentId, int childId) {
        if (!state.getIdMap().containsKey(parentId)) {
            ExceptionHandler.handleNodeDoesNotExistException(Constants.INVALID_PARENT_NODE);
            return false;
        } else if (!state.getIdMap().containsKey(childId)) {
            ExceptionHandler.handleNodeDoesNotExistException(Constants.INVALID_CHILD_NODE);
            return false;
        } else {
            return true;
        }

    }

    /**
     * Validate id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public static boolean validateId(int id) {
        if (!state.getIdMap().containsKey(id)) {
            ExceptionHandler.handleNodeDoesNotExistException(Constants.INVALID_NODE);
            return false;
        }

        return true;
    }

    /**
     * Validate new id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public static boolean validateNewId(int id) {
        if (state.getIdMap().containsKey(id)) {
            ExceptionHandler.handleNodeExistsException();
            return false;
        }

        return true;
    }

    /**
     * Validate dependency boolean.
     *
     * @param parentId the parent id
     * @param childId  the child id
     * @return the boolean
     */
    public static boolean validateDependency(int parentId, int childId) {
        Node node = state.getNodeMap().get(parentId);
        if(node.getChildren().contains(childId)){
            return true;
        }
        return false;
    }
}
