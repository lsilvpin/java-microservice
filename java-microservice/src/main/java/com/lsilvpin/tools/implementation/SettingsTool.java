package com.lsilvpin.tools.implementation;

import com.lsilvpin.domain.interfaces.tools.IEnvironmentTool;
import com.lsilvpin.domain.interfaces.tools.IFileTool;
import com.lsilvpin.domain.interfaces.tools.IPathTool;
import com.lsilvpin.domain.interfaces.tools.ISettingsTool;
import com.lsilvpin.domain.interfaces.tools.common.MyTool;

import java.io.IOException;
import java.util.HashMap;

public class SettingsTool extends MyTool implements ISettingsTool {

    private final IEnvironmentTool _environmentTool;
    private final IFileTool _fileTool;
    private final IPathTool _pathTool;

    public SettingsTool(
            IEnvironmentTool environmentTool,
            IFileTool fileTool,
            IPathTool pathTool) {
        _environmentTool = environmentTool;
        _fileTool = fileTool;
        _pathTool = pathTool;
    }

    @Override
    public String getSetting(String key) throws IOException {
        String value = _environmentTool.get(key);
        if (value == null) {
            String rootDir = _pathTool.getRootPath();
            String env = _environmentTool.get("environment");
            String settingsFilePath = rootDir + "/" + "settings." + env + ".json";
            HashMap<String, String> settings = _fileTool.readJsonAsMap(settingsFilePath);
            value = settings.get(key);
        }
        return value;
    }
}
