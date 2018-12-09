import com.intellij.openapi.components.*;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

@State(
    name="IgnoreMoreDiffConfiguration",
    storages = {
        @Storage("IgnoreMoreDiffConfiguration.xml")
    }
)
public class IgnoreMoreDiffConfiguration implements PersistentStateComponent<IgnoreMoreDiffConfiguration> {
    public boolean whitespaceToggle = true;
    public boolean commentToggle = true;
    public boolean importToggle = true;
    public boolean annotationsToggle = true;
    public List<String> annotations = Arrays.asList("Deprecated", "Nullable", "NonNull");

    @Nullable
    @Override
    public IgnoreMoreDiffConfiguration getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull IgnoreMoreDiffConfiguration state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    @Nullable
    public static IgnoreMoreDiffConfiguration getInstance() {
        return ServiceManager.getService(IgnoreMoreDiffConfiguration.class);
    }

    public boolean isWhitespaceToggle() {
        return whitespaceToggle;
    }

    public void setWhitespaceToggle(boolean whitespaceToggle) {
        this.whitespaceToggle = whitespaceToggle;
    }

    public boolean isCommentToggle() {
        return commentToggle;
    }

    public void setCommentToggle(boolean commentToggle) {
        this.commentToggle = commentToggle;
    }

    public boolean isImportToggle() {
        return importToggle;
    }

    public void setImportToggle(boolean importToggle) {
        this.importToggle = importToggle;
    }

    public boolean isAnnotationsToggle() {
        return annotationsToggle;
    }

    public void setAnnotationsToggle(boolean annotationsToggle) {
        this.annotationsToggle = annotationsToggle;
    }

    public List<String> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<String> annotations) {
        this.annotations = annotations;
    }
}
