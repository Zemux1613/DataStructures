package binaryTree;

import lombok.Data;

@Data
public class BinaryTreeNode<T extends Comparable> {
    private final T value;
    private BinaryTreeNode<T> rightNode;
    private BinaryTreeNode<T> leftNode;

    public boolean isLeave() {
        return rightNode == null && leftNode == null;
    }
}
