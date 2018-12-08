import com.intellij.diff.contents.DiffContent;
import com.intellij.diff.lang.LangDiffIgnoredRangeProvider;
import com.intellij.lang.Language;
import com.intellij.openapi.application.ReadAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IgnoreMoreDiff extends LangDiffIgnoredRangeProvider {
    IgnoreMoreDiffConfiguration diffConfig;
    String[] ignored_annotations = {"@Deprecated", "@Nullable", "@NonNull"};

    public IgnoreMoreDiff() {
        diffConfig = IgnoreMoreDiffConfiguration.getInstance();
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Ignore more";
    }

    @NotNull
    @Override
    protected boolean accepts(@NotNull Project project, @NotNull Language language) {
        return true; // Let's diff all the files!
    }

    @NotNull
    @Override
    public List<TextRange> getIgnoredRanges(@Nullable Project project, @NotNull CharSequence text, @NotNull DiffContent content) {
        return super.getIgnoredRanges(project, text, content);
    }

    @NotNull
    @Override
    protected List<TextRange> computeIgnoredRanges(@NotNull Project project, @NotNull CharSequence text, @NotNull Language language) {
        return ReadAction.compute(() -> {
            List<TextRange> result = new ArrayList<>();
            PsiFile psiFile = PsiFileFactory.getInstance(project).createFileFromText("", language, text);

            psiFile.accept(new PsiElementVisitor() {
                @Override
                public void visitElement(PsiElement element) {
                    if (element.getTextLength() == 0) return;

                    if (isIgnored(element)) {
                        result.add(element.getTextRange());
                    } else {
                        element.acceptChildren(this);
                    }
                }
            });
            return result;
        });
    }

    private boolean isIgnored(@NotNull PsiElement element) {
        if(element instanceof PsiWhiteSpace && diffConfig.isWhitespaceToggle()) return true;
        if(element instanceof PsiImportList && diffConfig.isImportToggle()) return true;
        if(element instanceof PsiComment && diffConfig.isCommentToggle()) return true;
        if(element instanceof PsiAnnotation) {
            return Arrays.stream(ignored_annotations).anyMatch(element.getText()::equals);
        }

        return false;
    }
}
