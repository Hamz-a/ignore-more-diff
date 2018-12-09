import javax.swing.*;
import java.util.Arrays;

public class IgnoreMoreDiffConfigurableGui {
    private JPanel rootPanel;
    private JCheckBox whitespaceToggle;
    private JCheckBox commentToggle;
    private JCheckBox importToggle;
    private JCheckBox annotationsToggle;
    private JTextField annotationsList;
    private IgnoreMoreDiffConfiguration ignoreMoreDiffConfiguration;

    public IgnoreMoreDiffConfigurableGui() {
        ignoreMoreDiffConfiguration = IgnoreMoreDiffConfiguration.getInstance();
        init();
    }

    private void init() {
        whitespaceToggle.setSelected(ignoreMoreDiffConfiguration.isWhitespaceToggle());
        commentToggle.setSelected(ignoreMoreDiffConfiguration.isCommentToggle());
        importToggle.setSelected(ignoreMoreDiffConfiguration.isImportToggle());
        annotationsToggle.setSelected(ignoreMoreDiffConfiguration.isAnnotationsToggle());
        annotationsList.setText(String.join(", ", ignoreMoreDiffConfiguration.getAnnotations()));
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public boolean isModified() {
        return true;
    }

    public void apply() {
        ignoreMoreDiffConfiguration.setWhitespaceToggle(whitespaceToggle.isSelected());
        ignoreMoreDiffConfiguration.setCommentToggle(commentToggle.isSelected());
        ignoreMoreDiffConfiguration.setImportToggle(importToggle.isSelected());
        ignoreMoreDiffConfiguration.setAnnotationsToggle(annotationsToggle.isSelected());
        ignoreMoreDiffConfiguration.setAnnotations(Arrays.asList(annotationsList.getText().trim().split("\\s*,\\s*")));
    }

    public void reset() {
        init();
    }
}
