package com.esporte.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPageObject extends PageObjectBase {

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_usuario")
    private WebElement campoUsuario;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_senha")
    private WebElement campoSenha;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario")
    private WebElement botaoCadastro;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/login_botao_logar")
    private WebElement botaoLogar;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/mensagem_erro_login")
    private WebElement mensagemErro;

    public LoginPageObject(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void fazerLogin(String usuario, String senha) {
        waitForElementToBeVisible(campoUsuario).sendKeys(usuario);
        waitForElementToBeVisible(campoSenha).sendKeys(senha);
        waitForElementToBeClickable(botaoLogar).click();
    }

    public void navegarParaTelaCadastro() {
        waitForElementToBeClickable(botaoCadastro).click();
    }

    public boolean estaNaTelaLogin() {
        return waitForElementToBeVisible(botaoLogar).isDisplayed();
    }

    public String getMensagemErro() {
        return waitForElementToBeVisible(mensagemErro).getText();
    }
}