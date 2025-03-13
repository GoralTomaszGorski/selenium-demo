package goral.yamReader;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.openqa.selenium.By;
import org.yaml.snakeyaml.Yaml;

public class YamlReader {

    YamlData yamlData = new YamlData();

    public YamlReader() {
        try (InputStream inputStream = new FileInputStream("src/test/java/goral/resources/config.yaml")) {
            Yaml yaml = new Yaml();

            Map<String, Object> yamlReader = yaml.load(inputStream);

            Map<String, String> credentialsMap = (Map<String, String>) yamlReader.get("credentials");
            yamlData.setUsername(credentialsMap.get("username"));
            yamlData.setPassword(credentialsMap.get("password"));


        } catch (Exception e) {
            System.err.println("Input stream error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public YamlData getYamlData() {
        return yamlData;
    }

    public static void main(String[] args) {
        YamlReader reader = new YamlReader();
        YamlData data = reader.getYamlData();

        System.out.println(data.getPassword());
        System.out.println(data.getUsername());
    }

}
