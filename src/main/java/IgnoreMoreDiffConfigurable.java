import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class IgnoreMoreDiffConfigurable implements SearchableConfigurable {
    private IgnoreMoreDiffConfigurableGui ignoreMoreDiffConfigurableGui;

    @NotNull
    @Override
    public String getId() {
        return "me.bhamza.IgnoreMoreDiffConfigurable";
    }

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Ignore More Diff";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        ignoreMoreDiffConfigurableGui = new IgnoreMoreDiffConfigurableGui();
        return ignoreMoreDiffConfigurableGui.getRootPanel();
    }

    @Override
    public void disposeUIResources() {
        ignoreMoreDiffConfigurableGui = null;
    }

    @Override
    public boolean isModified() {
        return ignoreMoreDiffConfigurableGui.isModified();
    }

    @Override
    public void apply() throws ConfigurationException {
        ignoreMoreDiffConfigurableGui.apply();
    }

    @Override
    public void reset() {
        ignoreMoreDiffConfigurableGui.reset();
    }
}
