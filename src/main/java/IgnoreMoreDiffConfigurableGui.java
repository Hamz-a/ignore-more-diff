import javax.swing.*;

public class IgnoreMoreDiffConfigurableGui {
    private JPanel rootPanel;
    private JCheckBox whitespaceToggle;
    private JCheckBox commentToggle;
    private JCheckBox importToggle;
    private IgnoreMoreDiffConfiguration ignoreMoreDiffConfiguration;

    public IgnoreMoreDiffConfigurableGui() {
        ignoreMoreDiffConfiguration = IgnoreMoreDiffConfiguration.getInstance();
        whitespaceToggle.setSelected(ignoreMoreDiffConfiguration.isWhitespaceToggle());
        commentToggle.setSelected(ignoreMoreDiffConfiguration.isCommentToggle());
        importToggle.setSelected(ignoreMoreDiffConfiguration.isImportToggle());
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
    }

    public void reset() {
        whitespaceToggle.setSelected(ignoreMoreDiffConfiguration.isWhitespaceToggle());
        commentToggle.setSelected(ignoreMoreDiffConfiguration.isCommentToggle());
        importToggle.setSelected(ignoreMoreDiffConfiguration.isImportToggle());
    }
}
