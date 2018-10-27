import java.awt.AWTException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class CopyToolFrame extends JFrame {
	class CopyToolPanel extends JPanel {
		JButton startBtn, stopBtn;
		GlobalKeyListener globalKeyListener;

		public CopyToolPanel() {
			setLayout(new GridLayout(1, 2));
			try {
				globalKeyListener = new GlobalKeyListener();
			} catch (AWTException e1) {
				e1.printStackTrace();
			}
			startBtn = new JButton("Start");
			stopBtn = new JButton("Stop");
			startBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					startBtn.setEnabled(false);
					try {
						GlobalScreen.registerNativeHook();
						Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
						logger.setLevel(Level.WARNING);

						// Don't forget to disable the parent handlers.
						logger.setUseParentHandlers(false);
						GlobalScreen.addNativeKeyListener(globalKeyListener);
					} catch (Exception ex) {
						System.err.println("There was a problem registering the native hook.");
						System.err.println(ex.getMessage());
						System.exit(1);
					}

				}
			});
			stopBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {					
					
					try {
						GlobalScreen.removeNativeKeyListener(globalKeyListener);
						GlobalScreen.unregisterNativeHook();
					} catch (NativeHookException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(1);
				}
			});
			add(startBtn);
			add(stopBtn);

		}
	}

	public CopyToolFrame() {
		super("CopyTool-by YS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new CopyToolPanel());
		setSize(400, 200);
		setVisible(true);
	}

}
