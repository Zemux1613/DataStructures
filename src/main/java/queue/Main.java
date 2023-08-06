package queue;

public class Main {

  public static void main(String[] args) {
    Queue<Integer> queue = new Queue<>();
    for (int i = 0; i < 50; i++) {
      queue.enqueue(i);
      System.out.println("enqueue value: " + i);
    }
    while (!queue.isEmpty()) {
      System.out.println("Front element: " + queue.peek()); // Ausgabe: Front element: 10
      queue.dequeue();
    }
  }
}
