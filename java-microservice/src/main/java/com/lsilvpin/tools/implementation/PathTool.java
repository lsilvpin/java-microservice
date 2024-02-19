package com.lsilvpin.tools.implementation;

import java.io.File;

import com.lsilvpin.domain.interfaces.tools.IPathTool;

public class PathTool implements IPathTool {
    @Override
    public String getRootPath() {
        File currentDirectory = new File(
                PathTool.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        File pomFile = new File(currentDirectory, "pom.xml");
        while (!pomFile.exists()) {
            File parentDirectory = currentDirectory.getParentFile();
            if (parentDirectory == null) {
                throw new IllegalStateException("Could not find pom.xml file.");
            }
            currentDirectory = parentDirectory;
            pomFile = new File(currentDirectory, "pom.xml");
        }
        return currentDirectory.getAbsolutePath();
    }
}
