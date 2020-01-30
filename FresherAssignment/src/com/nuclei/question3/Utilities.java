package com.nuclei.question3;

import java.util.HashSet;

/**
 * The type Utilities.
 */
public class Utilities {

    /**
     * The State.
     */
    static ApplicationState state = ApplicationState.getInstance();

    /**
     * Display parents.
     *
     * @param parents the parents
     * @param id      the id
     */
    public static void displayParents(HashSet<Integer> parents, int id) {
        if (parents.size() > 0) {
            Logger.log("Parents of node " + id + " are: ");
            for (Integer parent : parents) {
                Node parentNode = state.getNodeMap().get(parent);
                Logger.log("ID: " + parentNode.getNodeId() + " Name: " + parentNode.getNodeName());
            }
        } else {
            ExceptionHandler.handleGenericException("Given node has no parents.");
        }
    }

    /**
     * Display children.
     *
     * @param children the children
     * @param id       the id
     */
    public static void displayChildren(HashSet<Integer> children, int id) {
        if (children.size() > 0) {
            Logger.log("Children of node " + id + " are: ");
            for (Integer child : children) {
                Node childNode = state.getNodeMap().get(child);
                Logger.log("ID: " + childNode.getNodeId() + " Name: " + childNode.getNodeName());
            }
        } else {
            ExceptionHandler.handleGenericException("Given node has no children.");
        }
    }

    /**
     * Display ancestors.
     *
     * @param ancestors the ancestors
     * @param id        the id
     */
    public static void displayAncestors(HashSet<Node> ancestors, int id) {
        if (ancestors.size() > 0) {
            Logger.log("Ancestors of node " + id + " are: ");
            for (Node ancestor : ancestors) {
                Logger.log("ID: " + ancestor.getNodeId() + " Name: " + ancestor.getNodeName());
            }
            state.clearAncestors();
        } else {
            ExceptionHandler.handleGenericException("Given node has no ancestors.");
        }
    }

    /**
     * Display descendants.
     *
     * @param descendants the descendants
     * @param id          the id
     */
    public static void displayDescendants(HashSet<Node> descendants, int id) {
        if (descendants.size() > 0) {
            Logger.log("Descendants of node " + id + " are: ");
            for (Node descendant : descendants) {
                Logger.log("ID: " + descendant.getNodeId() + " Name: " + descendant.getNodeName());
            }
            state.clearDescendants();
        } else {
            ExceptionHandler.handleGenericException("Given node has no descendants.");
        }
    }
}
