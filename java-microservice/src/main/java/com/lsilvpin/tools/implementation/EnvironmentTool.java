package com.lsilvpin.tools.implementation;

import com.lsilvpin.domain.interfaces.tools.IEnvironmentTool;
import com.lsilvpin.domain.interfaces.tools.common.MyTool;

public class EnvironmentTool extends MyTool implements IEnvironmentTool {

    @Override
    public String get(String key) {
        return System.getenv(key);
    }
    
}
