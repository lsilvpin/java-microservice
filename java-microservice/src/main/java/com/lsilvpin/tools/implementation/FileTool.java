package com.lsilvpin.tools.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.lsilvpin.domain.interfaces.tools.IFileTool;
import com.lsilvpin.domain.interfaces.tools.common.MyTool;

public class FileTool extends MyTool implements IFileTool {

    @Override
    public <T> T readJson(String path, Class<T> typeOfT) throws IOException, IllegalArgumentException {
        if (path == null || !path.endsWith(".json")) {
            throw new IOException("Invalid file path or format");
        }

        File file = new File(path);
        if (!file.exists()) {
            throw new IOException("File does not exist");
        }

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file))) {
            Gson gson = new Gson();
            return gson.fromJson(reader, typeOfT);
        } catch (JsonSyntaxException ex) {
            throw new IllegalArgumentException("Invalid JSON content", ex);
        }
    }

    @Override
    public HashMap<String, String> readJsonAsMap(String path) throws IOException {
        if (path == null || !path.endsWith(".json")) {
            throw new IOException("Invalid file path or format");
        }

        File file = new File(path);
        if (!file.exists()) {
            throw new IOException("File does not exist");
        }

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file))) {
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<String, String>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (JsonSyntaxException ex) {
            throw new IllegalArgumentException("Invalid JSON content", ex);
        }
    }
}