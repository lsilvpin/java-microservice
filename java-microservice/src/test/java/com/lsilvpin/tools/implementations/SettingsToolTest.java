package com.lsilvpin.tools.implementations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.lsilvpin.domain.interfaces.tools.IEnvironmentTool;
import com.lsilvpin.domain.interfaces.tools.IFileTool;
import com.lsilvpin.domain.interfaces.tools.IPathTool;
import com.lsilvpin.domain.interfaces.tools.ISettingsTool;
import com.lsilvpin.tools.implementation.FileTool;
import com.lsilvpin.tools.implementation.PathTool;
import com.lsilvpin.tools.implementation.SettingsTool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SettingsToolTest {

    private IEnvironmentTool _environmentTool;
    private ISettingsTool _settingsTool;
    private IFileTool _fileTool;
    private IPathTool _pathTool;

    @BeforeEach
    public void setUp() {
        _environmentTool = mock(IEnvironmentTool.class);
        when(_environmentTool.get("environment")).thenReturn("dev");
        _fileTool = new FileTool();
        _pathTool = new PathTool();
        _settingsTool = new SettingsTool(_environmentTool, _fileTool, _pathTool);
    }

    @Test
    public void testShouldGetSetting_ExistingKeyInEnvironment_ReturnsValue()
            throws IllegalArgumentException, IOException {
        // Arrange
        String key = "example.key";
        String expectedValue = "example.value";
        when(_environmentTool.get(key)).thenReturn(expectedValue);

        // Act
        String actualValue = _settingsTool.getSetting(key);

        // Assert
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testShouldGetSetting_ExistingKeyInSettingsFile_ReturnsValue() throws IOException {
        // Arrange
        String jsonContentSample = "{\"example.key\":\"example.value\"}";
        var tmpFile = File.createTempFile("settings.", ".json");
        try (FileWriter writer = new FileWriter(tmpFile)) {
            writer.write(jsonContentSample);
        } catch (IOException e) {
            e.printStackTrace();
        }
        _pathTool = mock(IPathTool.class);
        when(_pathTool.getRootPath()).thenReturn(tmpFile.getParent());
        String middleName = tmpFile.getName().replace("settings.", "").replace(".json", "");
        when(_environmentTool.get("environment")).thenReturn(middleName);
        _settingsTool = new SettingsTool(_environmentTool, _fileTool, _pathTool);

        // Act
        String actualValue = _settingsTool.getSetting("example.key");

        // Assert
        assertEquals("example.value", actualValue);
    }

    @Test
    public void testShouldGetSetting_NonExistingKey_ReturnsNull() throws IOException {
        // Arrange
        String key = "non.existing.key";
        when(_environmentTool.get(key)).thenReturn(null);

        // Act
        String actualValue = _settingsTool.getSetting(key);

        // Assert
        assertNull(actualValue);
    }
}