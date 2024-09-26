package com.esporte.appium;

import com.esporte.appium.PageObjects.LoginPageObject;
import com.esporte.appium.PageObjects.TelaInicialPageObject;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FeatureLogin {

    private AppiumDriver driver;
    private LoginPageObject telaLogin;

    @Before
    public void setUp() {
        driver = AppiumDriverConfig.getDriver();
        telaLogin = new LoginPageObject(driver);
    }

    @After
    public void tearDown() {
        AppiumDriverConfig.quitDriver();
    }

    @Test
    public void deveFazerLoginComCredenciaisValidas() {
        telaLogin.fazerLogin("main", "123");
        Assert.assertTrue("Deveria estar na tela principal após login", TelaInicialPageObject.estaNaTelaInicial());
    }

    @Test
    public void naoDeveFazerLoginComCredenciaisInvalidas() {
        telaLogin.fazerLogin("usuarioInvalido", "senhaInvalida");
        Assert.assertEquals("Usuário ou senha inválidos", telaLogin.getMensagemErro());
    }

}
