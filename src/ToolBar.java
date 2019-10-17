import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.function.Function;

public class ToolBar extends JToolBar {

    JCheckBox isDisableIndent = new JCheckBox("Disable Indent");

    public ToolBar(Function changeIndentState) {
        super("Copy Tool Menu");
        this.setBackground(Color.LIGHT_GRAY);
        isDisableIndent.setSelected(true);
        isDisableIndent.addItemListener(e -> {
            changeIndentState.apply(null);
        });

        this.add(isDisableIndent);
    }

}
