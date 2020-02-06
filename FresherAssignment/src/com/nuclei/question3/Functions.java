package com.nuclei.question3;

import java.util.HashSet;

/**
 * The type Functions.
 */
public class Functions implements GraphOperations{

    /**
     * The State.
     */
    static ApplicationState state = ApplicationState.getInstance();

    @Override
    public void getParents(int nodeId) {
        if (state.getIdMap().containsKey(nodeId)) {
            Node node = state.getNodeMap().get(nodeId);
            HashSet<Integer> parents = node.getParents();
            Utilities.displayParents(parents, nodeId);
        } else {
            ExceptionHandler.handleNodeDoesNotExistException(Constants.INVALID_NODE);
        }
    }

    @Override
    public void getChildren(int nodeId) {
        if (state.getIdMap().containsKey(nodeId)) {
            Node node = state.getNodeMap().get(nodeId);
            HashSet<Integer> children = node.getChildren();
            Utilities.displayChildren(children, nodeId);
        } else {
            ExceptionHandler.handleNodeDoesNotExistException(Constants.INVALID_NODE);
        }
    }

    @Override
    public void getAncestors(int nodeId) {
        if (state.getIdMap().containsKey(nodeId)) {
            Node node = state.getNodeMap().get(nodeId);
            Utilities.displayAncestors(AncestorsAndDescendants.obtainAncestors(node), nodeId);
        } else {
            ExceptionHandler.handleNodeDoesNotExistException(Constants.INVALID_NODE);
        }

    }

    @Override
    public void getDescendants(int nodeId) {
        if (state.getIdMap().containsKey(nodeId)) {
            Node node = state.getNodeMap().get(nodeId);
            Utilities.displayDescendants(AncestorsAndDescendants.obtainDescendants(node), nodeId);
        } else {
            ExceptionHandler.handleNodeDoesNotExistException(Constants.INVALID_NODE);
        }
    }

    @Override
    public void deleteDependency(int parentId, int childId) {
        if (state.getIdMap().containsKey(parentId)) {
            if (state.getIdMap().containsKey(childId)) {
                Node parentNode = state.getNodeMap().get(parentId);
                parentNode.removeFromChildren(childId);

                Node childNode = state.getNodeMap().get(childId);
                childNode.removeFromParents(parentId);
                Logger.log("Dependency Deleted.");
            } else {
                ExceptionHandler.handleNodeDoesNotExistException(Constants.INVALID_CHILD_NODE);
            }
        } else {
            ExceptionHandler.handleNodeDoesNotExistException(Constants.INVALID_PARENT_NODE);
        }
    }

    @Override
    public void deleteNode(int nodeId) {
        if (state.getIdMap().containsKey(nodeId)) {
            Node node = state.getNodeMap().get(nodeId);

            HashSet<Integer> parents = node.getParents();
            for (Integer parent : parents) {
                Node parentNode = state.getNodeMap().get(parent);
                parentNode.removeFromChildren(nodeId);
            }

            HashSet<Integer> children = node.getChildren();
            for (Integer child : children) {
                Node parentNode = state.getNodeMap().get(child);
                parentNode.removeFromParents(nodeId);
            }

            state.deleteFromIdMap(nodeId);
            state.deleteFromNodeMap(node);

            Logger.log("Node Deleted.");
        } else {
            ExceptionHandler.handleNodeDoesNotExistException(Constants.INVALID_NODE);
        }

    }

    @Override
    public void addDependency(int parentId, int childId) {
        if (state.getIdMap().containsKey(parentId)) {
            if (state.getIdMap().containsKey(childId)) {
                Node parentNode = state.getNodeMap().get(parentId);
                HashSet<Node> ancestors = AncestorsAndDescendants.obtainAncestors(parentNode);
                Node childNode = state.getNodeMap().get(childId);
                if (!ancestors.contains(childNode)) {
                    parentNode.addToChildren(childId);
                    childNode.addToParents(parentId);
                    Logger.log("Dependency added successfully");
                } else {
                    ExceptionHandler.handleCyclicDependencyException();
                }
            } else {
                ExceptionHandler.handleNodeDoesNotExistException(Constants.INVALID_CHILD_NODE);
            }
        } else {
            ExceptionHandler.handleNodeDoesNotExistException(Constants.INVALID_PARENT_NODE);
        }
    }

    @Override
    public void addNode(int nodeId, String nodeName) {
        Node node = new Node();
        node.setNodeId(nodeId);
        node.setNodeName(nodeName);

        state.addToIdMap(nodeId);
        state.addToNodeMap(node);

        Logger.log("Node successfully created");
    }

}
