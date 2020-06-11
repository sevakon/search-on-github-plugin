package ru.seva.actions;

import ru.seva.utils.BrowserRunner;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SearchAction extends AnAction {
    private String urlPrefix;
    private String urlPostfix;

    public SearchAction(@NotNull String text,
                        @Nullable String description,
                        @Nullable Icon icon,
                        @NotNull String urlPrefix,
                        @Nullable String urlPostfix) {
        super(text, description, icon);
        this.urlPrefix = urlPrefix;
        this.urlPostfix = urlPostfix;
    }

    @Override
    public void actionPerformed(@org.jetbrains.annotations.NotNull AnActionEvent e) {
        final Project project = e.getProject();

        if (project == null || !project.isInitialized() || project.isDisposed()) {
            return;
        }

        final Editor editor = CommonDataKeys.EDITOR.getData(e.getDataContext());
        String selectedCode = editor == null ? "" : editor.getSelectionModel().getSelectedText();
        String selectedText = StringUtil.isEmptyOrSpaces(selectedCode) ? "" : selectedCode.trim();

        System.out.println(selectedText);
        BrowserRunner.go(urlPrefix, selectedText, urlPostfix);
    }
}
