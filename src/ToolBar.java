import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.function.Consumer;

public class ToolBar extends JToolBar {
    private JTextField timerTextField;

    private boolean isCorrectNumber() {
        String temp = timerTextField.getText();
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            if (!(c > '0' && c < '9'))
                return false;
        }
        return true;
    }

    private void validationTextField() {

        Runnable doHighlight = () -> {
            if (!isCorrectNumber()) {
                timerTextField.setText("");
            }
        };
        SwingUtilities.invokeLater(doHighlight);

    }

    public ToolBar(Consumer changeIndentState) {
        super("Copy Tool Menu");
        this.setBackground(Color.LIGHT_GRAY);
        JCheckBox isDisableIndent = new JCheckBox("Disable Indent");
        isDisableIndent.setBackground(Color.LIGHT_GRAY);
        isDisableIndent.setSelected(true);
        isDisableIndent.addItemListener(e -> {
            changeIndentState.accept(null);
        });
        timerTextField = new JTextField();
        timerTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validationTextField();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validationTextField();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validationTextField();
            }
        });

        add(isDisableIndent);
        add(new JLabel("Timer"));
        add(timerTextField);
        add((new JLabel("ms")));
    }

}
