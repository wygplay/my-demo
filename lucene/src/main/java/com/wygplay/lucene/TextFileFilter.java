package com.wygplay.lucene;

import java.io.File;
import java.io.FileFilter;

/**
 * @author wyg
 * @version 1.0
 * @date 2021/12/20 19:52
 */
public class TextFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.getName().toLowerCase().endsWith(".txt");
    }
}
