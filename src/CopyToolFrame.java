import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class CopyToolFrame extends JFrame {

	public CopyToolFrame() {
		super("CopyTool-by YS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new WrappingPannel());
		setSize(400, 200);
		setVisible(true);
	}

}
