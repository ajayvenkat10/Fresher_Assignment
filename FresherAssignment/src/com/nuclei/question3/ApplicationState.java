package com.nuclei.question3;

import com.nuclei.question2.Logger;

import java.util.HashMap;
import java.util.HashSet;

/**
 * The type Application state.
 */
public class ApplicationState {

    private static ApplicationState instance;
    private HashMap<Integer, Boolean> idMap = new HashMap<>();
    private HashMap<Integer, Node> nodeMap = new HashMap<>();
    private HashSet<Node> ancestors = new HashSet<>();
    private HashSet<Node> descendants = new HashSet<>();

    private ApplicationState() {
        try {
            if (instance != null)
                throw new IllegalAccessException();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static ApplicationState getInstance() {
        if (instance == null) {
            instance = new ApplicationState();
        }
        return instance;
    }

    /**
     * Add to id map.
     *
     * @param Id the id
     */
    public void addToIdMap(int Id) {
        idMap.put(Id, true);
    }

    /**
     * Delete from id map int.
     *
     * @param Id the id
     * @return the int
     */
    public int deleteFromIdMap(int Id) {
        try {
            idMap.remove(Id);
        } catch (Exception e) {
            Logger.log("Node with the entered id does not exist.");
            return -1;
        }
        return 1;
    }

    /**
     * Gets id map.
     *
     * @return the id map
     */
    public HashMap<Integer, Boolean> getIdMap() {
        return idMap;
    }

    /**
     * Gets node map.
     *
     * @return the node map
     */
    public HashMap<Integer, Node> getNodeMap() {
        return nodeMap;
    }

    /**
     * Add to node map.
     *
     * @param node the node
     */
    public void addToNodeMap(Node node) {
        nodeMap.put(node.getNodeId(), node);
    }

    /**
     * Delete from node map int.
     *
     * @param node the node
     * @return the int
     */
    public int deleteFromNodeMap(Node node) {
        try {
            nodeMap.remove(node.getNodeId());
        } catch (Exception e) {
            Logger.log("Node with the entered id does not exist.");
            return -1;
        }
        return 1;
    }

    /**
     * Gets ancestors.
     *
     * @return the ancestors
     */
    public HashSet<Node> getAncestors() {
        return ancestors;
    }

    /**
     * Gets descendants.
     *
     * @return the descendants
     */
    public HashSet<Node> getDescendants() {
        return descendants;
    }

    /**
     * Add to ancestors.
     *
     * @param ancestorNode the ancestor node
     */
    public void addToAncestors(Node ancestorNode) {
        ancestors.add(ancestorNode);
    }

    /**
     * Add to descendants.
     *
     * @param descendantNode the descendant node
     */
    public void addToDescendants(Node descendantNode) {
        descendants.add(descendantNode);
    }

    /**
     * Clear ancestors.
     */
    public void clearAncestors() {
        ancestors.clear();
    }

    /**
     * Clear descendants.
     */
    public void clearDescendants() {
        descendants.clear();
    }
}
