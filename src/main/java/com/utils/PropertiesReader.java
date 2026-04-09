package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class PropertiesReader {

	private static Properties properties;
	public static WebDriver driver;

	public static void loadProperties() {
		properties = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");

			properties.load(fis);
		} catch (IOException e) {
			throw new RuntimeException("Failed  to load config.properties", e);

		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static int getIntProperty(String key) {
		return Integer.parseInt(properties.getProperty(key));
	}

}
