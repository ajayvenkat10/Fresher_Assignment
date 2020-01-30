package com.nuclei.question3;

/**
 * The interface Graph operations.
 */
public interface GraphOperations {
    /**
     * Gets parents.
     *
     * @param nodeId the node id
     */
    void getParents(int nodeId);

    /**
     * Gets children.
     *
     * @param nodeId the node id
     */
    void getChildren(int nodeId);

    /**
     * Gets ancestors.
     *
     * @param nodeId the node id
     */
    void getAncestors(int nodeId);

    /**
     * Gets descendants.
     *
     * @param nodeId the node id
     */
    void getDescendants(int nodeId);

    /**
     * Delete dependency.
     *
     * @param parentId the parent id
     * @param childId  the child id
     */
    void deleteDependency(int parentId, int childId);

    /**
     * Delete node.
     *
     * @param nodeId the node id
     */
    void deleteNode(int nodeId);

    /**
     * Add dependency.
     *
     * @param parentId the parent id
     * @param childId  the child id
     */
    void addDependency(int parentId, int childId);

    /**
     * Add node.
     *
     * @param nodeId   the node id
     * @param nodeName the node name
     */
    void addNode(int nodeId, String nodeName);
}
