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
     * @param
     */

    public static void obtainAncestorsUtil(HashSet<Integer> parents, HashSet<Node> ancestors){
        if (parents.size() == 0) {
            return;
        }

        for (Integer parent : parents) {
            Node parentNode = state.getNodeMap().get(parent);
            ancestors.add(parentNode);
            obtainAncestorsUtil(parentNode.getParents(), ancestors);
        }
    }

    public static HashSet<Node> obtainAncestors(Node node) {
        HashSet<Node> ancestors = new HashSet<>();
        obtainAncestorsUtil(node.getParents(),ancestors);
        return ancestors;
    }

    /**
     * Obtain descendants.
     *
     * @param
     */

    public static void obtainDescendantsUtil(HashSet<Integer> children, HashSet<Node> descendants){
        if (children.size() == 0) {
            return;
        }

        for (Integer child : children) {
            Node childNode = state.getNodeMap().get(child);
            descendants.add(childNode);
            obtainDescendantsUtil(childNode.getChildren(), descendants);
        }
    }
    public static HashSet<Node> obtainDescendants(Node node) {
        HashSet<Node> descendants = new HashSet<>();
        obtainDescendantsUtil(node.getChildren(), descendants);
        return descendants;
    }
}
