package linkedList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class ListNode<T> {
    private T value;
    @Setter
    private ListNode nextNode;
}
