package com.esporte.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfig {
    private static AndroidDriver driver;

    private AppiumDriverConfig() {}

    public static AndroidDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    private static void createDriver() {
        File apk = new File("src/main/resources/alura_esporte.apk");

        UiAutomator2Options options = new UiAutomator2Options()
            .setApp(apk.getAbsolutePath())
            .setPlatformName("Android")
            .setAutomationName("UiAutomator2");

        URL urlConexao;
        try {
            urlConexao = new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Erro ao criar URL de conexão com o Appium", e);
        }

        driver = new AndroidDriver(urlConexao, options);
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}