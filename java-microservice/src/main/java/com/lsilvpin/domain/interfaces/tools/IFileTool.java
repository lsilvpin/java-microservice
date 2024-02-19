package com.lsilvpin.domain.interfaces.tools;

import java.io.IOException;
import java.util.HashMap;

import com.lsilvpin.domain.interfaces.tools.common.IMyTool;

/**
 * This interface represents a file tool that provides methods for reading the
 * content of a file.
 */
public interface IFileTool extends IMyTool {

    /**
     * Reads the content of a file specified by the given path.
     * 
     * @param path    the path of the file to be read
     * @param typeOfT the class representing the type of the content to be read from
     *                the file
     * @return the content of the file
     * @throws IOException              if an I/O error occurs while reading the
     *                                  file
     * @throws IllegalArgumentException if the type T is not a class
     * @param <T> the type of the content to be read from the file
     */
    public <T> T readJson(String path, Class<T> typeOfT) throws IOException, IllegalArgumentException;

    public HashMap<String, String> readJsonAsMap(String path) throws IOException;
}
