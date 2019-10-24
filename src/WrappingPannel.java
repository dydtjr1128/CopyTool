import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class WrappingPannel extends JPanel {

    private ToolBar toolBar;
    private boolean isDisableIndent = true;
    private int timer;

    public WrappingPannel() {
        this.setLayout(new BorderLayout());
        toolBar = new ToolBar(changeIndentState);
        this.add(toolBar, BorderLayout.NORTH);
        this.add(new CopyToolPanel(getIndentState, getTimer), BorderLayout.CENTER);
        //setTimer.accept(null);
    }

    public Consumer<Void> changeIndentState = (a) -> {
        this.isDisableIndent = !this.isDisableIndent;
    };
    public Supplier<Boolean> getIndentState = () -> this.isDisableIndent;

    /*private Consumer<Integer> setTimer = (a) -> {
        this.timer = toolBar.getTimer();
    };*/
    private Supplier<Integer> getTimer = () -> toolBar.getTimer();


}
