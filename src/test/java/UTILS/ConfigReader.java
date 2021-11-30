package UTILS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;
    public static Properties readProperties(String filepath)  {
        try {
            FileInputStream file= new FileInputStream(filepath);
            prop=new Properties();
            prop.load(file);
            file.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
       return prop;

    }
    public static String getPropertyValue(String key){
        return prop.getProperty(key);
    }
}
