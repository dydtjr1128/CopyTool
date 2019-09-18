package key;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KeyCode {
    private String keyName;
    private boolean shiftOn;
    private int keyCode;
}
