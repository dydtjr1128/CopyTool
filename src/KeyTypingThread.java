import key.KeyCode;
import key.KeyManager;
import language.Hangul;
import org.jnativehook.keyboard.NativeKeyEvent;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

import static java.lang.Thread.sleep;

public class KeyTypingThread extends Thread {
    private BlockingQueue<Character> blockingQueue;
    private HashMap<Character, KeyCode> keyMap;
    private Robot robot;
    private static final int SLEEP_TIME = 10;

    KeyTypingThread() throws AWTException {
        blockingQueue = KeyManager.getInstance().getBlockingQueue();
        keyMap = KeyManager.getInstance().getKeyMap();
        robot = new Robot();
    }

    private void keyLogic(char character) {
        KeyCode keyCode = keyMap.get(character);
        if (keyCode == null)
            return;

        if (keyCode.isShiftOn()) {
            robot.keyPress(KeyEvent.VK_SHIFT);
        }

        robot.keyPress(keyCode.getKeyCode());
        robot.keyRelease(keyCode.getKeyCode());

        if (keyCode.isShiftOn()) {
            robot.keyRelease(KeyEvent.VK_SHIFT);
        }
    }

    @Override
    public void run() {
        while (true) {
            char character = 0;
            try {
                character = blockingQueue.take();
                System.out.println(character);
                if (Hangul.isHangul(character)) {
                    for (char c : Hangul.split(character)) {
                        if (c == ' ')
                            continue;
                        keyLogic(c);
                    }
                } else {
                    keyLogic(character);
                }
                sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
