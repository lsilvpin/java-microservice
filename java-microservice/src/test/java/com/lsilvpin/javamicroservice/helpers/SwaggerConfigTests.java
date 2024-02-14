package com.lsilvpin.javamicroservice.helpers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import springfox.documentation.service.ApiInfo;

public class SwaggerConfigTests {

    @Test
    public void testShouldReturnApiInfo() {
        // Arrange
        SwaggerConfig swaggerConfig = new SwaggerConfig();
        
        // Act
        ApiInfo apiInfo = swaggerConfig.apiInfo();
        
        // Assert
        assertNotNull(apiInfo);
        // Add additional assertions if needed
    }
}
