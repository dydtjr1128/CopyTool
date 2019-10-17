import com.sun.jna.Native;
import com.sun.jna.platform.win32.User32;
import key.KeyCode;
import key.KeyManager;
import language.Hangul;
import language.Language;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;

public class KeyTypingThread extends Thread {

    public interface User32jna extends User32 {
        User32jna INSTANCE = (User32jna) Native.load("user32.dll", User32jna.class);

        public void keybd_event(byte bVk, byte bScan, int dwFlags, int dwExtraInfo);
    }

    private User32jna u32 = User32jna.INSTANCE;
    private BlockingQueue<Character> blockingQueue;
    private HashMap<Character, KeyCode> keyMap;
    private Robot robot;
    private static final int SLEEP_TIME = 15;

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

    private void changeLanguage() {
        u32.keybd_event((byte) 0x15, (byte) 0xF2, 0, 0);
    }

    @Override
    public void run() {
        Language language = Language.Default;
        boolean isFirstRun = true;
        while (true) {
            char character = 0;
            try {
                character = blockingQueue.take();
                //System.out.println(character);
                if (Hangul.isHangul(character)) {
                    if (isFirstRun) {
                        language = Language.Korean;
                    } else if (language != Language.Korean) {
                        changeLanguage();
                        language = Language.Korean;
                    }
                    for (char c : Hangul.split(character)) {
                        if (c == ' ')
                            continue;
                        keyLogic(c);
                    }
                } else {
                    if (isFirstRun) {
                        language = Language.English;
                    } else if (language != Language.English) {
                        changeLanguage();
                        language = Language.English;
                    }
                    keyLogic(character);
                }
                isFirstRun = false;
                sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
