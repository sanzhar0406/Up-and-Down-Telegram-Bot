package com.upndown.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BotConfig {

    private static final String propertiesFileName = "bot.config";
    private static BotConfig instance;

    private BotConfig(){

    }

    public static BotConfig getInstance(){
        if (instance == null){
            instance = new BotConfig();
        }
        return instance;
    }

    public Properties getBotProperties() throws IOException {
        Properties properties = new Properties();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propertiesFileName + "' not found in the classpath");
        }
        return properties;
    }
}
