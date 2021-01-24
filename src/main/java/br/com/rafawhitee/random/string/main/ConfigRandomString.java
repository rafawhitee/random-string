package br.com.rafawhitee.random.string.main;

public class ConfigRandomString {

	private boolean maiusculas;
	private boolean minusculas;
	private boolean caracteresEspeciais;
	private boolean numeros;
	private boolean uuid;
	private int tamanho;
	private int maximoDeRepeticoesPermitidas;

	public ConfigRandomString() {
		popularDefaults();
	}

	public void zerarDefaults() {
		popularDefaults();
	}

	private void popularDefaults() {
		this.tamanho = 6;
		this.maximoDeRepeticoesPermitidas = 1;
	}

	public boolean isMaiusculas() {
		return maiusculas;
	}

	public void setMaiusculas(boolean maiusculas) {
		this.maiusculas = maiusculas;
	}

	public boolean isMinusculas() {
		return minusculas;
	}

	public void setMinusculas(boolean minusculas) {
		this.minusculas = minusculas;
	}

	public boolean isCaracteresEspeciais() {
		return caracteresEspeciais;
	}

	public void setCaracteresEspeciais(boolean caracteresEspeciais) {
		this.caracteresEspeciais = caracteresEspeciais;
	}

	public boolean isNumeros() {
		return numeros;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
		validarTamanho();
	}

	private void validarTamanho() {
		if (tamanho <= 0)
			throw new RuntimeException("O tamanho da não pode ser igual ou menor que 0");
	}

	public void setNumeros(boolean numeros) {
		this.numeros = numeros;
	}

	public int getMaximoDeRepeticoesPermitidas() {
		return maximoDeRepeticoesPermitidas;
	}

	public void setMaximoDeRepeticoesPermitidas(int maximoDeRepeticoesPermitidas) {
		if (maximoDeRepeticoesPermitidas < 0)
			throw new RuntimeException("maximoDeRepeticoesPermitidas tem que ser maior ou igual a 0");

		this.maximoDeRepeticoesPermitidas = maximoDeRepeticoesPermitidas;
	}

	public boolean isUuid() {
		return uuid;
	}

	public void setUuid(boolean uuid) {
		this.uuid = uuid;
	}

}