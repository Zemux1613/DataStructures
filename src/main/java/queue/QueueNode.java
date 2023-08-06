package queue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class QueueNode<T> {

  private T value;
  @Setter
  private QueueNode<T> next;

}
