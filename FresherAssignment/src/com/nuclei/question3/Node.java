package com.nuclei.question3;

import java.util.HashSet;

/**
 * The type Node.
 */
public class Node {
    private int nodeId;
    private String nodeName;
    private HashSet<Integer> parents = new HashSet<>();
    private HashSet<Integer> children = new HashSet<>();

    /**
     * Gets node id.
     *
     * @return the node id
     */
    public int getNodeId() {
        return nodeId;
    }

    /**
     * Sets node id.
     *
     * @param nodeId the node id
     */
    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    /**
     * Gets node name.
     *
     * @return the node name
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * Sets node name.
     *
     * @param nodeName the node name
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * Add to parents.
     *
     * @param Id the id
     */
    public void addToParents(int Id) {
        parents.add(Id);
    }

    /**
     * Add to children.
     *
     * @param Id the id
     */
    public void addToChildren(int Id) {
        children.add(Id);
    }

    /**
     * Remove from children.
     *
     * @param Id the id
     */
    public void removeFromChildren(int Id) {
        children.remove(Id);
    }

    /**
     * Remove from parents.
     *
     * @param Id the id
     */
    public void removeFromParents(int Id) {
        parents.remove(Id);
    }

    /**
     * Gets parents.
     *
     * @return the parents
     */
    public HashSet<Integer> getParents() {
        return parents;
    }

    /**
     * Gets children.
     *
     * @return the children
     */
    public HashSet<Integer> getChildren() {
        return children;
    }
}
