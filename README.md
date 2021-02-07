# Random String
Biblioteca que gera string aleatórias a partir de configurações, tais como: tamanho, uuid, caracteres especiais, números, pode repetir, entre outras.


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
private int maximoDeRepeticoesPermitidas; // Se poderá repetir algum caractere (Default 0).
```

Os caracteres especiais que RandomString pode incluir no resultado são: <b> ! # $ % & * + / ? _ | ~ </b>

### Todas as configurações
Caso você inicialize o Random String e chame direto o random, ele irá colocar todas as configurações como true.
```java
RandomString rs = new RandomString();
String resultWithAllConfigs = rs.random();
```

### Tamanho
```java
RandomString rs = new RandomString();
String resultWithSize5 = rs.tamanho(5).random();
String resultWithSize12 = rs.tamanho(12).random();
```

### Maiúsculas e Minúsculas
```java
RandomString rs = new RandomString();
String resultUpperCase = rs.maiusculas().random();
String resultLowerCase = rs.minusculas().random();
```

### UUID
Cria um Identificador Único Global 
```java
RandomString rs = new RandomString();
String resultUuid = rs.uuid().random();
```

### Caracteres Especiais
```java
RandomString rs = new RandomString();
String resultWithSpecialChars = rs.caracteresEspeciais().random();
```

### Podendo Repetir
O método repetir da classe RandomString recebe um inteiro que é o número de repetições permitidos.
```java
RandomString rs = new RandomString();
// Pode repetir até 1 vez cada caractere
String resultThatCanBeRepeatOneTimeChars = rs.repetir(1).random();

// Pode repetir até 3 vezes cada caractere
String resultThatCanBeRepeatThreeTimesChars = rs.repetir(3).random();
```

### Agrupando várias configurações
Você pode juntar várias configurações, como por exemplo: mudar o tamanho para 12, colocar para poder repetir 2 vezes, etc.
```java
RandomString rs = new RandomString();
String resultWithSpecialCharsSize12AndCanRepeatTwice = rs.tamanho(12).repetir(2).caracteresEspeciais().random();
String resultWithSpecialCharsAndSize8 = rs.tamanho(8).caracteresEspeciais().random();
String resultLowerCaseSize15AndSpecialChars = rs.minusculas().tamanho(15).caracteresEspeciais().random();
```

### Restrições
Você pode alterar os caracteres especiais, minúsculos ou maiúsculas, um exemplo: se você quiser criar uma string que contenha somente os caracteres especiais <b> # e $ </b> ou as letras maiúsculas <b> A, B, C e D </b> .
```java
RandomString rs = new RandomString();
String randomWithRestrictionOne = rs.maiusculas(Arrays.asList('A', 'B', 'C', 'D')).caracteresEspeciais(Arrays.asList('#', '$')).repetir(2).random();

List<Character> restrictionsUpperCase = Arrays.asList('A', 'B', 'C', 'D');
List<Character> restrictionsLowerCase = Arrays.asList('z', 'b', 'k', 'l', 'x');
List<Character> restrictionsSpecialChars = Arrays.asList('&');
String randomWithRestrictionTwo = rs.maiusculas(restrictionsUpperCase).minusculas(restrictionsLowerCase).caracteresEspeciais(restrictionsSpecialChars).random();
```

<b> Observação:</b> como já mencionado o default do tamanho é 6, se você passar uma lista com restrições menor que o tamanho FINAL e sem repetição, irá ser lançado uma Exception falando que não é possível randomizar por falta de caractere.

Exemplos que irão lançar Exception
```java
RandomString rs = new RandomString();
// Irá lançar Exception pois está passando 3 maiusculas e 2 especiais, totalizando 5, mas por o default é tamanho 6, logo não será possível randomizar.
String randomExceptionOne = rs.maiusculas(Arrays.asList('A', 'B', 'C')).caracteresEspeciais(Arrays.asList('#', '$')).random();

// Irá lançar também Exception, pois você está passando uma lista com um único caractere e o tamanho 2.
String randomExceptionTwo = rs.maiusculas(Arrays.asList('A')).tamanho(2).random();

// Irá lançar também Exception, pois está passando o caractere minúsculo 'a' como parâmetro de restrição para maiusculas, irá lançar que é um Caractere Inválido.
String randomExceptionThree = rs.maiusculas(Arrays.asList('a')).tamanho(1).random();
```

# License
[MIT](https://github.com/rafawhitee/random-string/blob/main/LICENSE.txt)
