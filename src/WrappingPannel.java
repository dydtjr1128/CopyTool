import javax.swing.*;
import java.awt.*;
import java.util.function.Function;

public class WrappingPannel extends JPanel {

    boolean isDisableIndent = true;

    public WrappingPannel() {
        this.setLayout(new BorderLayout());
        this.add(new ToolBar(changeIndentState), BorderLayout.NORTH);
        this.add(new CopyToolPanel(getIndentState), BorderLayout.CENTER);
    }

    public Function<Void, Void> changeIndentState = this::changeDisableIndent;
    public Function<Void, Boolean> getIndentState = this::getIsDisableIndent;

    private Boolean getIsDisableIndent(Void f) {
        return this.isDisableIndent;
    }

    private Void changeDisableIndent(Void f) {
        System.out.println(this.isDisableIndent);
        return null;
    }

}
