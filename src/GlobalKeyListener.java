import key.KeyManager;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.concurrent.BlockingQueue;
import java.util.function.Supplier;

public class GlobalKeyListener implements NativeKeyListener {
    private Clipboard clipboard;
    private boolean needStop = false;
    private Supplier<Boolean> getIndentState;

    GlobalKeyListener(Supplier getIndentState) throws AWTException {
        this.getIndentState = getIndentState;
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    public void nativeKeyPressed(NativeKeyEvent e) {
        //System.out.println("pre " + e.getKeyChar() + " " + e.getKeyCode() + " " + e.getKeyLocation() + " " + e.getKeyLocation() + e.paramString());
        if (e.getKeyCode() == 62) {
            needStop = true;
            KeyManager.getInstance().getBlockingQueue().clear();
        }
    }

    public void nativeKeyReleased(NativeKeyEvent e) {
        //System.out.println("rel " + e.getKeyChar() + " " + e.getKeyCode() + " " + e.getKeyLocation() + " " + e.getKeyLocation() + e.paramString());
        if (e.getKeyCode() == 60) {//f2
            runLogic();
        }
    }

    public void nativeKeyTyped(NativeKeyEvent e) {
        //System.out.println("typed " + e.getKeyChar() + " " + e.getKeyCode() + " " + e.getKeyLocation() + " " + e.getKeyLocation());
    }

    private void runLogic() {
        Transferable contents = clipboard.getContents(clipboard);

        if (contents != null) {

            try {
                String pasteString = (String) (contents.getTransferData(DataFlavor.stringFlavor));

                //programmers
                boolean isDisableIndent = this.getIndentState.get();
                if(isDisableIndent) {
                    pasteString = pasteString.replace("    ", "").replace("\t", "");
                }

                BlockingQueue<Character> blockingQueue = KeyManager.getInstance().getBlockingQueue();
                for (int i = 0; i < pasteString.length() && !needStop; i++) {
                    //System.out.println(pasteString.charAt(i) + " " + KeyEvent.getExtendedKeyCodeForChar(pasteString.charAt(i)) + " @@ " + KeyEvent.getKeyText(pasteString.charAt(i)));
                    blockingQueue.put(pasteString.charAt(i));
                }
                needStop = false;
            } catch (Exception e2) {
                System.out.println("err");
            }
        }
    }

}
