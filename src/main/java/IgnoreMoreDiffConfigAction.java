import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.options.ShowSettingsUtil;

public class IgnoreMoreDiffConfigAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent event) {
        ShowSettingsUtil.getInstance().showSettingsDialog(null, IgnoreMoreDiffConfigurable.class);
    }
}
