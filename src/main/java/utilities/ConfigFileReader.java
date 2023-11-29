package utilities;

import constants.Constant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
    public static String propertyValue;
    public static String getPropertyValue(String propertyKey) {
        try {
            InputStream propertyFileInputStream = utilities.ConfigFileReader.class.getClassLoader()
                    .getResourceAsStream(Constant.PATH_TO_CONFIGURATION_PROPERTY_FILE);
            Properties prop = new Properties();
            prop.load(propertyFileInputStream);
            propertyValue = prop.getProperty(propertyKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (propertyValue != null) {
            return propertyValue;
        } else {
            throw new RuntimeException(String.format("Configuration Property not found %s", propertyKey));
        }
    }
}

