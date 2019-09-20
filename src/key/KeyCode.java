package key;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@ToString
public class KeyCode {
    private String keyName;
    private boolean shiftOn;
    private int keyCode;
}
