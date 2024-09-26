# Projeto de testes Appium com Java

Este projeto contém testes automatizados utilizando Appium e JUnit. O projeto é estruturado usando o padrão Page Object Model (POM) para melhor organização e manutenção dos testes.

O projeto utiliza as seguintes dependências principais:

- JUnit 4.13.2
- Appium Java Client 9.3.0
- Selenium Java 4.15.0

## Configuração

1. Certifique-se de ter o JDK 8 ou superior instalado.
2. Instale o Maven para gerenciamento de dependências.
3. Configure o Appium Server em sua máquina.
4. Coloque o arquivo APK do aplicativo.

## Executando os Testes

Existem várias maneiras de executar os testes neste projeto:

### Usando Maven na linha de comando

1. Para compilar o projeto e executar todos os testes:
   mvn clean test
   
2. Para executar uma classe de teste específica:
   mvn clean test -Dtest=NomeDaClasseDeTeste
   Por exemplo:
   mvn clean test -Dtest=FeatureLogin

3. Para executar um método de teste específico:
   mvn clean test -Dtest=NomeDaClasseDeTeste#nomeDoMetodoDeTeste
   Por exemplo:
   mvn clean test -Dtest=FeatureLogin#deveFazerLoginComCredenciaisValidas

### Usando uma IDE

1. Abra o projeto em sua IDE.
2. Navegue até a classe de teste desejada (por exemplo, `FeatureLogin.java` ou `FeatureCadastro.java`).
3. Clique com o botão direito na classe ou em um método de teste específico.
4. Selecione a opção "Run" para executar os testes.

## Classes Principais

- `AppiumDriverConfig`: Configura e gerencia o driver do Appium.
- `PageObjectBase`: Classe base para todos os Page Objects, fornecendo métodos utilitários comuns.
- `CadastroPageObject`: Representa a tela de cadastro do aplicativo.
- `LoginPageObject`: Representa a tela de login do aplicativo.
- `TelaInicialPageObject`: Representa a tela inicial do aplicativo após o login.

## Testes

O projeto inclui dois conjuntos principais de testes:

1. `FeatureCadastro`: Testes relacionados ao processo de cadastro de usuários.
2. `FeatureLogin`: Testes relacionados ao processo de login de usuários.

## Configuração do Maven

O arquivo `pom.xml` está configurado com o plugin Maven Surefire para executar os testes. Ele inclui as seguintes configurações:

<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-surefire-plugin</artifactId>
      <version>3.0.0-M5</version>
      <configuration>
        <includes>
          <include>**/*Test.java</include>
          <include>**/*Feature*.java</include>
        </includes>
      </configuration>
    </plugin>
  </plugins>
</build>

Esta configuração garante que todos os arquivos de teste com nomes terminando em "Test" ou contendo "Feature" sejam executados.

## Notas Adicionais

- O projeto utiliza o UiAutomator2 como motor de automação para Android.
- A URL de conexão do Appium está configurada para `http://127.0.0.1:4723`.
- Certifique-se de que o emulador Android ou dispositivo físico esteja conectado e configurado corretamente antes de executar os testes.
- Verifique se o Appium Server está em execução antes de iniciar os testes.

## Solução de Problemas

Se você encontrar problemas ao executar os testes, verifique:

1. Se o Appium Server está em execução.
2. Se o emulador Android ou dispositivo físico está conectado e configurado corretamente.
3. Se o arquivo APK do aplicativo está no local correto (`src/main/resources`).
4. Se todas as dependências do Maven foram baixadas corretamente.
