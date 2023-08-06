package queue;

import java.util.NoSuchElementException;

/**
 * FIFO Prinzip
 *
 * @param <T> value type
 */
public class Queue<T> {

  private QueueNode<T> firstNode;
  private QueueNode<T> lastNode;

  public Queue<T> enqueue(T value) {
    final QueueNode<T> newNode = new QueueNode<>(value, null);
    if (isEmpty()) {
      firstNode = lastNode = newNode;
    } else {
      lastNode.setNext(newNode);
      lastNode = newNode;
    }
    return this;
  }

  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    final T value = firstNode.getValue();
    firstNode = firstNode.getNext();
    if (firstNode == null) {
      lastNode = null;
    }
    return value;
  }

  public T peek() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    return firstNode.getValue();
  }

  public boolean isEmpty() {
    return firstNode == null;
  }

}
