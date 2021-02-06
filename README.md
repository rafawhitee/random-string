# Random String
Biblioteca que gera string aleatórias a partir de configuração, como por exmeplo: tamanho, uuid, caracteres especiais, números, etc.


# Usage
Por padrão a configuração do RandomString inicia com tamanho 6 e podendo repetir até 1 vez algum caractere.

Configurações Disponíveis
```java
private boolean maiusculas; // Se irá incluir letras maiúsculas no resultado
private boolean minusculas; // Se irá incluir letras minúsculas no resultado
private boolean caracteresEspeciais; // Se irá incluir caracteres especiais no resultado
private boolean numeros; // Se irá incluir números no resultado
private boolean uuid; // Se irá gerar um Identificador Único Global (irá ignorar as outras configurações)
private int tamanho; // Tamanho que irá ser gerado (Default 6)
private int maximoDeRepeticoesPermitidas; // Se poderá repetir algum caractere (Default 1).
```

Os caracteres especiais que RandomString pode incluir no resultado são: <b> ! # $ % & * + / ? _ | ~ </b>

## Todas as configurações
Caso você inicialize o Random String e chame direto o random, ele irá colocar todas as configurações como true.
```java
RandomString rs = new RandomString();
String resultWithAllConfigs = rs.random();
```

## Tamanho
```java
RandomString rs = new RandomString();
String resultWithSize5 = rs.tamanho(5).random();
String resultWithSize12 = rs.tamanho(12).random();
```

## Maiúsculas e Minúsculas
```java
RandomString rs = new RandomString();
String resultUpperCase = rs.maiusculas().random();
String resultLowerCase = rs.minusculas().random();
```

## UUID
Vai criar um Identificador Único Global (UUID da classe java.util) no formato em String, ele irá ignorar as outras configurações (tamanho mínimo, tamanho máximo, etc).
```java
RandomString rs = new RandomString();
String resultUuid = rs.uuid().random();
```

## Caracteres Especiais
```java
RandomString rs = new RandomString();
String resultWithSpecialChars = rs.caracteresEspeciais().random();
```

## Agrupando várias configurações
Você pode juntar várias configurações, como por exemplo
```java
RandomString rs = new RandomString();
String resultWithSpecialCharsAndSize8 = rs.tamanho(8).caracteresEspeciais().random();
String resultWithSpecialCharsAndSize8 = rs.tamanho(8).caracteresEspeciais().random();
 String resultUpperCaseSize15AndSpecialChars = rs.maiusculas().tamanho(15).caracteresEspeciais().random();
```
