package com.esporte.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class TelaInicialPageObject extends PageObjectBase {

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/produtos")
    private static WebElement viewInicial;

    public TelaInicialPageObject(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public static boolean estaNaTelaInicial() {
        return waitForElementToBeVisible(viewInicial).isDisplayed();
    }
    
}
