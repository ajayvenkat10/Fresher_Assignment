package com.nuclei.question3;

/**
 * The interface Constants.
 */
public interface Constants {

    /**
     * The constant INVALID_NODE.
     */
    String INVALID_NODE = "Node with the given ID does not exist!";
    /**
     * The constant INVALID_PARENT_NODE.
     */
    String INVALID_PARENT_NODE = "Parent node with the given ID does not exist!";
    /**
     * The constant INVALID_CHILD_NODE.
     */
    String INVALID_CHILD_NODE = "Child node with the given ID does not exist!";
    /**
     * The constant NODE_EXISTS.
     */
    String NODE_EXISTS = "Node with entered ID already exists";
    /**
     * The constant CYCLIC_DEPENDENCY.
     */
    String CYCLIC_DEPENDENCY = "Adding this dependency creates Cyclic Dependency.\nDependency not allowed";
}
