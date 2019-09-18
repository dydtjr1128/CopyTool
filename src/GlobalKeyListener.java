import key.KeyManager;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.util.concurrent.BlockingQueue;

public class GlobalKeyListener implements NativeKeyListener {
    private Clipboard clipboard;

    GlobalKeyListener() throws AWTException {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    public void nativeKeyPressed(NativeKeyEvent e) {
        System.out.println("pre "+e.getKeyChar() + " " + e.getKeyCode() + " " + e.getKeyLocation() + " " + e.getKeyLocation() + e.paramString());
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        System.out.println("rel "+e.getKeyChar() + " " + e.getKeyCode() + " " + e.getKeyLocation() + " " + e.getKeyLocation() + e.paramString());
        if (e.getKeyCode() == 60) {//f2
            runLogic();
        }
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        System.out.println("typed " + e.getKeyChar() + " " + e.getKeyCode() + " " + e.getKeyLocation() + " " + e.getKeyLocation());
    }

    public void runLogic(){
        Transferable contents = clipboard.getContents(clipboard);

        if (contents != null) {

            try {
                String pasteString = (String) (contents.getTransferData(DataFlavor.stringFlavor));
                BlockingQueue<Character> blockingQueue = KeyManager.getInstance().getBlockingQueue();
                for (int i = 0; i < pasteString.length(); i++) {
                    //System.out.println(pasteString.charAt(i) + " " + KeyEvent.getExtendedKeyCodeForChar(pasteString.charAt(i)) + " " + KeyEvent.getKeyText(pasteString.charAt(i)));
                    blockingQueue.put(pasteString.charAt(i));
                }

            } catch (Exception e2) {
                System.out.println("err");
            }
        }
    }

}
