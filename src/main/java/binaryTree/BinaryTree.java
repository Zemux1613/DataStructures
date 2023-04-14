package binaryTree;

import java.util.Stack;
import java.util.StringJoiner;

public class BinaryTree<T extends Comparable> {
    private BinaryTreeNode<T> startNode;

    public BinaryTree() {
        this.startNode = null;
    }

    public BinaryTree<T> add(T value) {
        startNode = addNode(startNode, value);
        return this;
    }

    private BinaryTreeNode<T> addNode(BinaryTreeNode<T> node, T value) {
        if (node == null) {
            node = new BinaryTreeNode<>(value);
        } else {
            if (value.compareTo(node.getValue()) <= 0) {
                node.setLeftNode(addNode(node.getLeftNode(), value));
            } else {
                node.setRightNode(addNode(node.getRightNode(), value));
            }
        }
        return node;
    }

    public void printTree() {
        final StringJoiner joiner = new StringJoiner(", ");
        printTree(this.startNode, joiner);
        System.out.println(joiner);
    }

    private void printTree(BinaryTreeNode<T> node, StringJoiner joiner) {
        if (node != null) {
            printTree(node.getLeftNode(), joiner);
            joiner.add(String.valueOf(node.getValue()));
            printTree(node.getRightNode(), joiner);
        }
    }

    public boolean isInTree(T value) {
        Stack<BinaryTreeNode> nodes = new Stack<>();
        nodes.push(this.startNode);
        while (!nodes.isEmpty()) {
            final BinaryTreeNode topNode = nodes.pop();
            if (!topNode.isLeave()) {
                if (topNode.getRightNode() != null) nodes.push(topNode.getRightNode());
                if (topNode.getLeftNode() != null) nodes.push(topNode.getLeftNode());
            }
            if (topNode.getValue().compareTo(value) == 0) {
                return true;
            }
        }
        return false;
    }
}
