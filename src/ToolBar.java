import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class ToolBar extends JToolBar {

    JCheckBox isDisableIndent = new JCheckBox("Disable Indent");

    public ToolBar(Consumer changeIndentState) {
        super("Copy Tool Menu");
        this.setBackground(Color.LIGHT_GRAY);
        isDisableIndent.setSelected(true);
        isDisableIndent.addItemListener(e -> {
            changeIndentState.accept(null);
        });

        this.add(isDisableIndent);
    }

}
