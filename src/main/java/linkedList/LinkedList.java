package linkedList;

import java.util.StringJoiner;

public class LinkedList {
    private Class type;
    private ListNode firstNode;

    private LinkedIterator iterator;

    public LinkedIterator getIterator() {
        if (iterator == null) {
            this.iterator = new LinkedIterator(this.firstNode);
        }
        return iterator;
    }

    /**
     * @param value item to add
     * @param <T>
     * @return LinkedList with item
     */
    public <T> LinkedList add(final T value) {
        if (firstNode == null) {
            type = value.getClass();
            firstNode = new ListNode(value, null);
            this.iterator = new LinkedIterator(this.firstNode);
        } else {
            if (type != null) {
                if (value.getClass() != type) {
                    throw new IllegalArgumentException("Illegal type! The list is an " + type.getSimpleName() + " list.");
                }
            }
            ListNode currentNode = this.firstNode;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(new ListNode(value, null));
        }
        return this;
    }

    /**
     * Print linkedList
     */
    public void printList() {
        if (firstNode == null) {
            System.out.println("Empty list");
        } else {
            StringJoiner values = new StringJoiner(",");
            ListNode currentNode = this.firstNode;
            while (currentNode.getNextNode() != null) {
                values.add(currentNode.getValue() + "");
                currentNode = currentNode.getNextNode();
            }
            values.add(currentNode.getValue() + "");
            System.out.println("List values: " + values);
        }
    }

    /**
     * @return get firstNode
     */
    public ListNode getHead() {
        return firstNode;
    }

    /**
     * @param value item to add
     * @param <T>
     * @return add item at start
     */
    public <T> LinkedList addAtStart(final T value) {
        this.type = value.getClass();
        this.firstNode = new ListNode(value, this.firstNode);
        this.iterator = new LinkedIterator(this.firstNode);
        return this;
    }
}
