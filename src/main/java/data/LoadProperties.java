package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    public static Properties userInfo = loadProperties(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\userinfo.properties");

    private static Properties loadProperties(String path) {
        Properties prop = new Properties();

        // reading Data file
        try {
            FileInputStream stream = new FileInputStream(path);
            prop.load(stream);
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        }

        return prop;
    }

}