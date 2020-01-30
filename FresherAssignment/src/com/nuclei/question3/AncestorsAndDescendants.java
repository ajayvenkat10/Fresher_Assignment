package com.nuclei.question3;

import java.util.HashSet;

/**
 * The type Ancestors and descendants.
 */
public class AncestorsAndDescendants {
    /**
     * The State.
     */
    static ApplicationState state = ApplicationState.getInstance();

    /**
     * Obtain ancestors.
     *
     * @param node the node
     */
    public static void obtainAncestors(Node node) {
        HashSet<Integer> parents = node.getParents();

        if (parents.size() == 0) {
            return;
        }

        for (Integer parent : parents) {
            Node parentNode = state.getNodeMap().get(parent);
            state.addToAncestors(parentNode);
            obtainAncestors(parentNode);
        }
    }

    /**
     * Obtain descendants.
     *
     * @param node the node
     */
    public static void obtainDescendants(Node node) {
        HashSet<Integer> children = node.getChildren();

        if (children.size() == 0) {
            return;
        }

        for (Integer child : children) {
            Node childNode = state.getNodeMap().get(child);
            state.addToDescendants(childNode);
            obtainDescendants(childNode);
        }
    }
}
