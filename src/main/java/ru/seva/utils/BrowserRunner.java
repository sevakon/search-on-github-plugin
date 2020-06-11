package ru.seva.utils;

import com.intellij.ide.BrowserUtil;
import com.intellij.util.io.URLUtil;

public class BrowserRunner {

    public static void go(String prefixUrl, String query, String postfixUrl) {
        BrowserUtil.browse(prefixUrl + URLUtil.encodeURIComponent(query) + postfixUrl);
    }
}
