import javax.swing.*;

public class CopyToolFrame extends JFrame {

    public CopyToolFrame() {
        super("CopyTool-by YS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new WrappingPannel());
        setSize(400, 200);
        setVisible(true);
    }
}