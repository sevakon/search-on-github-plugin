package ru.seva.actions;

import ru.seva.utils.IconUtil;

public class GitHubSearchAction extends SearchAction {
    private static final String TEXT = "Search on GitHub";
    private static final String DESCRIPTION = "Search selected code on GitHub";

    private static final String URL_PREFIX = "https://www.github.com/search?q=";
    private static final String URL_POSTFIX = "&type=Code";

    public GitHubSearchAction() {
        super(TEXT, DESCRIPTION, IconUtil.GITHUB_LOGO, URL_PREFIX, URL_POSTFIX);
    }
}
