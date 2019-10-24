import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

class CopyToolPanel extends JPanel {
    private JButton startBtn, stopBtn;
    private GlobalKeyListener globalKeyListener;
    private KeyTypingThread keyTypingThread;

    public CopyToolPanel(Supplier getIndentState, Supplier getTimer) {
        setLayout(new GridLayout(1, 2));
        try {
            globalKeyListener = new GlobalKeyListener(getIndentState);
            keyTypingThread =  new KeyTypingThread(getTimer);
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");
        startBtn.addActionListener(e -> {
            startBtn.setEnabled(false);
            try {
                GlobalScreen.registerNativeHook();
                Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
                logger.setLevel(Level.WARNING);

                // Don't forget to disable the parent handlers.
                logger.setUseParentHandlers(false);
                GlobalScreen.addNativeKeyListener(globalKeyListener);
                keyTypingThread.start();
            } catch (Exception ex) {
                System.err.println("There was a problem registering the native hook.");
                System.err.println(ex.getMessage());
                System.exit(1);
            }

        });
        stopBtn.addActionListener(e -> {

            try {
                GlobalScreen.removeNativeKeyListener(globalKeyListener);
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            System.exit(1);
        });
        add(startBtn);
        add(stopBtn);
    }
}