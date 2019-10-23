package key;

import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class KeyManager {
    private static KeyManager INSTANCE;

    private HashMap<Character, KeyCode> keyMap;
    private BlockingQueue<Character> blockingQueue;

    private KeyManager() {
        init();
    }

    synchronized public static KeyManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new KeyManager();
        }
        return INSTANCE;
    }

    public BlockingQueue<Character> getBlockingQueue() {
        return blockingQueue;
    }

    public HashMap<Character, KeyCode> getKeyMap() {
        return keyMap;
    }

    private void init() {
        blockingQueue = new ArrayBlockingQueue<>(30);
        keyMap = new HashMap<>();

        keyMap.put(' ', new KeyCode("VK_SPACE", false, 32));
        keyMap.put('\n', new KeyCode("VK_ENTER", false, KeyEvent.VK_ENTER));
        keyMap.put('\t', new KeyCode("VK_TAB", false, KeyEvent.VK_TAB));

        keyMap.put('a', new KeyCode("VK_A", false, 65));
        keyMap.put('b', new KeyCode("VK_B", false, 66));
        keyMap.put('c', new KeyCode("VK_C", false, 67));
        keyMap.put('d', new KeyCode("VK_D", false, 68));
        keyMap.put('e', new KeyCode("VK_E", false, 69));
        keyMap.put('f', new KeyCode("VK_F", false, 70));
        keyMap.put('g', new KeyCode("VK_G", false, 71));
        keyMap.put('h', new KeyCode("VK_H", false, 72));
        keyMap.put('i', new KeyCode("VK_I", false, 73));
        keyMap.put('j', new KeyCode("VK_J", false, 74));
        keyMap.put('k', new KeyCode("VK_K", false, 75));
        keyMap.put('l', new KeyCode("VK_L", false, 76));
        keyMap.put('m', new KeyCode("VK_M", false, 77));
        keyMap.put('n', new KeyCode("VK_N", false, 78));
        keyMap.put('o', new KeyCode("VK_O", false, 79));
        keyMap.put('p', new KeyCode("VK_P", false, 80));
        keyMap.put('q', new KeyCode("VK_Q", false, 81));
        keyMap.put('r', new KeyCode("VK_R", false, 82));
        keyMap.put('s', new KeyCode("VK_S", false, 83));
        keyMap.put('t', new KeyCode("VK_T", false, 84));
        keyMap.put('u', new KeyCode("VK_U", false, 85));
        keyMap.put('v', new KeyCode("VK_V", false, 86));
        keyMap.put('w', new KeyCode("VK_W", false, 87));
        keyMap.put('x', new KeyCode("VK_X", false, 88));
        keyMap.put('y', new KeyCode("VK_Y", false, 89));
        keyMap.put('z', new KeyCode("VK_Z", false, 90));

        keyMap.put('A', new KeyCode("VK_A", true, 65));
        keyMap.put('B', new KeyCode("VK_B", true, 66));
        keyMap.put('C', new KeyCode("VK_C", true, 67));
        keyMap.put('D', new KeyCode("VK_D", true, 68));
        keyMap.put('E', new KeyCode("VK_E", true, 69));
        keyMap.put('F', new KeyCode("VK_F", true, 70));
        keyMap.put('G', new KeyCode("VK_G", true, 71));
        keyMap.put('H', new KeyCode("VK_H", true, 72));
        keyMap.put('I', new KeyCode("VK_I", true, 73));
        keyMap.put('J', new KeyCode("VK_J", true, 74));
        keyMap.put('K', new KeyCode("VK_K", true, 75));
        keyMap.put('L', new KeyCode("VK_L", true, 76));
        keyMap.put('M', new KeyCode("VK_M", true, 77));
        keyMap.put('N', new KeyCode("VK_N", true, 78));
        keyMap.put('O', new KeyCode("VK_O", true, 79));
        keyMap.put('P', new KeyCode("VK_P", true, 80));
        keyMap.put('Q', new KeyCode("VK_Q", true, 81));
        keyMap.put('R', new KeyCode("VK_R", true, 82));
        keyMap.put('S', new KeyCode("VK_S", true, 83));
        keyMap.put('T', new KeyCode("VK_T", true, 84));
        keyMap.put('U', new KeyCode("VK_U", true, 85));
        keyMap.put('V', new KeyCode("VK_V", true, 86));
        keyMap.put('W', new KeyCode("VK_W", true, 87));
        keyMap.put('X', new KeyCode("VK_X", true, 88));
        keyMap.put('Y', new KeyCode("VK_Y", true, 89));
        keyMap.put('Z', new KeyCode("VK_Z", true, 90));

        keyMap.put('ㅁ', new KeyCode("VK_A", false, 65));
        keyMap.put('ㅠ', new KeyCode("VK_B", false, 66));
        keyMap.put('ㅊ', new KeyCode("VK_C", false, 67));
        keyMap.put('ㅇ', new KeyCode("VK_D", false, 68));
        keyMap.put('ㄷ', new KeyCode("VK_E", false, 69));
        keyMap.put('ㄸ', new KeyCode("VK_E", true, 69));
        keyMap.put('ㄹ', new KeyCode("VK_F", false, 70));
        keyMap.put('ㅎ', new KeyCode("VK_G", false, 71));
        keyMap.put('ㅗ', new KeyCode("VK_H", false, 72));
        keyMap.put('ㅑ', new KeyCode("VK_I", false, 73));
        keyMap.put('ㅓ', new KeyCode("VK_J", false, 74));
        keyMap.put('ㅏ', new KeyCode("VK_K", false, 75));
        keyMap.put('ㅣ', new KeyCode("VK_L", false, 76));
        keyMap.put('ㅡ', new KeyCode("VK_M", false, 77));
        keyMap.put('ㅜ', new KeyCode("VK_N", false, 78));
        keyMap.put('ㅐ', new KeyCode("VK_O", false, 79));
        keyMap.put('ㅒ', new KeyCode("VK_O", true, 79));
        keyMap.put('ㅔ', new KeyCode("VK_P", false, 80));
        keyMap.put('ㅖ', new KeyCode("VK_P", true, 80));
        keyMap.put('ㅂ', new KeyCode("VK_Q", false, 81));
        keyMap.put('ㅃ', new KeyCode("VK_Q", true, 81));
        keyMap.put('ㄱ', new KeyCode("VK_R", false, 82));
        keyMap.put('ㄲ', new KeyCode("VK_R", true, 82));
        keyMap.put('ㄴ', new KeyCode("VK_S", false, 83));
        keyMap.put('ㅅ', new KeyCode("VK_T", false, 84));
        keyMap.put('ㅆ', new KeyCode("VK_T", true, 84));
        keyMap.put('ㅕ', new KeyCode("VK_U", false, 85));
        keyMap.put('ㅍ', new KeyCode("VK_V", false, 86));
        keyMap.put('ㅈ', new KeyCode("VK_W", false, 87));
        keyMap.put('ㅉ', new KeyCode("VK_W", true, 87));
        keyMap.put('ㅌ', new KeyCode("VK_X", false, 88));
        keyMap.put('ㅛ', new KeyCode("VK_Y", false, 89));
        keyMap.put('ㅋ', new KeyCode("VK_Z", false, 90));

        keyMap.put('0', new KeyCode("VK_0", false, 48));
        keyMap.put('1', new KeyCode("VK_1", false, 49));
        keyMap.put('2', new KeyCode("VK_2", false, 50));
        keyMap.put('3', new KeyCode("VK_3", false, 51));
        keyMap.put('4', new KeyCode("VK_4", false, 52));
        keyMap.put('5', new KeyCode("VK_5", false, 53));
        keyMap.put('6', new KeyCode("VK_6", false, 54));
        keyMap.put('7', new KeyCode("VK_7", false, 55));
        keyMap.put('8', new KeyCode("VK_8", false, 56));
        keyMap.put('9', new KeyCode("VK_9", false, 57));
        keyMap.put(')', new KeyCode("VK_0", true, 48));
        keyMap.put('!', new KeyCode("VK_1", true, 49));
        keyMap.put('@', new KeyCode("VK_2", true, 50));
        keyMap.put('#', new KeyCode("VK_3", true, 51));
        keyMap.put('$', new KeyCode("VK_4", true, 52));
        keyMap.put('%', new KeyCode("VK_5", true, 53));
        keyMap.put('^', new KeyCode("VK_6", true, 54));
        keyMap.put('&', new KeyCode("VK_7", true, 55));
        keyMap.put('*', new KeyCode("VK_8", true, 56));
        keyMap.put('(', new KeyCode("VK_9", true, 57));
        keyMap.put('+', new KeyCode("VK_-", true, 61));
        keyMap.put('=', new KeyCode("VK_-", false, 61));
        keyMap.put('-', new KeyCode("VK_OEM_MINUS", false, 45));
        keyMap.put('_', new KeyCode("VK_OEM_MINUS", true, 45));
        keyMap.put('[', new KeyCode("VK_OEM_4", false, 91));
        keyMap.put('{', new KeyCode("VK_OEM_4", true, 91));
        keyMap.put(']', new KeyCode("VK_OEM_6", false, 93));
        keyMap.put('}', new KeyCode("VK_OEM_6", true, 93));
        keyMap.put('|', new KeyCode("VK_OEM_102", true, 92));
        keyMap.put('\\', new KeyCode("VK_OEM_102", false, 92));
        keyMap.put(';', new KeyCode("VK_SEMICOLON", false, 59));
        keyMap.put(':', new KeyCode("VK_SEMICOLON", true, 59));
        keyMap.put('\'', new KeyCode("VK_OEM_7", false, 222));
        keyMap.put('"', new KeyCode("VK_OEM_7", true, 222));
        keyMap.put(',', new KeyCode("VK_COMMA", false, 44));
        keyMap.put('<', new KeyCode("VK_COMMA", true, 44));
        keyMap.put('.', new KeyCode("VK_PERIOD", false, 46));
        keyMap.put('>', new KeyCode("VK_PERIOD", true, 46));
        keyMap.put('/', new KeyCode("VK_SLASH", false, 47));
        keyMap.put('?', new KeyCode("VK_SLASH", true, 47));
        keyMap.put('`', new KeyCode("VK_SLASH", false, 192));
        keyMap.put('~', new KeyCode("VK_SLASH", true, 192));
    }
}
