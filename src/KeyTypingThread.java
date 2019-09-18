import key.KeyCode;
import key.KeyManager;
import org.jnativehook.keyboard.NativeKeyEvent;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class KeyTypingThread extends Thread {
    private BlockingQueue<Character> blockingQueue;
    private HashMap<Character, KeyCode> keyMap;
    private Robot robot;
    private static final int SLEEP_TIME = 5;

    KeyTypingThread() throws AWTException {
        blockingQueue = KeyManager.getInstance().getBlockingQueue();
        keyMap = KeyManager.getInstance().getKeyMap();
        robot = new Robot();
    }

    @Override
    public void run() {
        while (true) {
            try {
                char character = blockingQueue.take();
                KeyCode keyCode = keyMap.get(character);
                if (keyCode == null)
                    continue;

                if (keyCode.isShiftOn()) {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                }
                
                robot.keyPress(keyCode.getKeyCode());
                robot.keyRelease(keyCode.getKeyCode());

                if (keyCode.isShiftOn()) {
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }
                Thread.sleep(SLEEP_TIME);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
