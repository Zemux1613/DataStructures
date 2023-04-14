package linkedList;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LinkedIterator {
    public ListNode currentNode;

    public ListNode next() {
        this.currentNode = currentNode.getNextNode();
        return this.currentNode;
    }

    public boolean hasNext() {
        return currentNode.getNextNode() != null;
    }
}
