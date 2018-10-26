import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class Main {//1234567890
	public static void main(String[] args) throws AWTException {
		try {
			GlobalScreen.registerNativeHook();
			Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
			logger.setLevel(Level.WARNING);

			// Don't forget to disable the parent handlers.
			logger.setUseParentHandlers(false);
		}
		catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.out.print("123123123\n");
			System.out.print("123123123\n");
			System.out.print("123123123\n");
			System.exit(1);
		}

		GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
	}
}
