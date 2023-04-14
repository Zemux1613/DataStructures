package keyValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KeyValue <T, R> {
    private T key;
    private R value;

    @Override
    public String toString() {
        return key + ": " + value;
    }
}
