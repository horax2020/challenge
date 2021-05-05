package com.cucumberBaby.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFiles {

    static FileInputStream ip;
    static Properties prop;
    public String valueProperty;

    public ReadPropertyFiles(String region) {
        prop=new Properties();
        try {
            ip = new FileInputStream("./src/test/java/com/cucumberBaby/Config/regions");
            prop.load(ip);
            valueProperty = prop.getProperty(region);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String changeProperty(String property){
        try {
            ip = new FileInputStream("./src/test/java/com/cucumberBaby/Config/regions");
            prop.load(ip);
            valueProperty = prop.getProperty(property);
            return valueProperty;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Not found";
    }

}
