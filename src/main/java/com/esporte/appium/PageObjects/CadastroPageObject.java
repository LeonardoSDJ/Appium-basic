package com.esporte.appium.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CadastroPageObject extends PageObjectBase {

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_nome")
    private WebElement campoNome;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_senha")
    private WebElement campoSenha;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_confirmar_senha")
    private WebElement campoConfirmarSenha;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar")
    private WebElement botaoCadastrar;

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/erro_cadastro")
    private WebElement mensagemErro;

    public CadastroPageObject(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void preencherFormulario(String usuario, String senha, String confirmacao) {
        waitForElementToBeVisible(campoNome).sendKeys(usuario);
        waitForElementToBeVisible(campoSenha).sendKeys(senha);
        waitForElementToBeVisible(campoConfirmarSenha).sendKeys(confirmacao);
    }

    public void cadastrar(String usuario, String senha, String confirmacao) {
        preencherFormulario(usuario, senha, confirmacao);
        waitForElementToBeClickable(botaoCadastrar).click();
    }

    public String getMensagemErro() {
        return waitForElementToBeVisible(mensagemErro).getText();
    }
}