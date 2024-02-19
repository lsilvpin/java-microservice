package com.lsilvpin.domain.interfaces.tools;

import com.lsilvpin.domain.interfaces.tools.common.IMyTool;

/**
 * This interface represents a tool for working with paths.
 * It extends the IMyTool interface.
 */
public interface IPathTool extends IMyTool {
    
    /**
     * Returns the root path.
     * 
     * @return the root path as a string.
     */
    public String getRootPath();    
}
