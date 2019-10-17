import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class WrappingPannel extends JPanel {

    boolean isDisableIndent = true;

    public WrappingPannel() {
        this.setLayout(new BorderLayout());
        this.add(new ToolBar(changeIndentState), BorderLayout.NORTH);
        this.add(new CopyToolPanel(getIndentState), BorderLayout.CENTER);
    }

    public Consumer<Void> changeIndentState = (a) -> { this.isDisableIndent = !this.isDisableIndent; };
    public Supplier<Boolean> getIndentState = () -> this.isDisableIndent;


}
