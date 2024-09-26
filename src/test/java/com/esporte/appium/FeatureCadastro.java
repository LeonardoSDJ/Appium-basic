package com.esporte.appium;

import io.appium.java_client.AppiumDriver;
import org.junit.*;

import com.esporte.appium.PageObjects.CadastroPageObject;
import com.esporte.appium.PageObjects.LoginPageObject;

public class FeatureCadastro {

    private static AppiumDriver driver;
    private LoginPageObject telaLogin;
    private CadastroPageObject telaCadastro;

    @BeforeClass
    public static void setUpClass() {
        driver = AppiumDriverConfig.getDriver();
    }

    @AfterClass
    public static void tearDownClass() {
        AppiumDriverConfig.quitDriver();
    }

    @Before
    public void setUp() {
        telaLogin = new LoginPageObject(driver);
        telaCadastro = new CadastroPageObject(driver);
    }

    @Test
    public void naoDeveCadastrarUsuarioComSenhasDiferentes() {
        telaLogin.navegarParaTelaCadastro();
        telaCadastro.cadastrar("main", "123", "456");

        Assert.assertEquals("Senhas não conferem", telaCadastro.getMensagemErro());
        driver.navigate().back();
    }

    @Test
    public void deveCadastrarUsuarioComSenhasIguais() {
        telaLogin.navegarParaTelaCadastro();
        telaCadastro.cadastrar("main", "123", "123");

        Assert.assertTrue("Usuário deveria estar na tela de login após cadastro bem-sucedido",
                telaLogin.estaNaTelaLogin());
    }
}
