package br.com.rafawhitee.random.string.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConfigRandomString {

	private boolean maiusculas;
	private boolean minusculas;
	private boolean caracteresEspeciais;
	private boolean numeros;
	private boolean uuid;
	private int tamanho;
	private int maximoDeRepeticoesPermitidas;
	private List<Integer> numerosDisponiveis;

	public ConfigRandomString() {
		popularDefaults();
	}

	public void zerarDefaults() {
		popularDefaults();
	}

	private void popularDefaults() {
		this.tamanho = 6;
		this.numerosDisponiveis = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		this.maximoDeRepeticoesPermitidas = 1;
	}

	public List<String> retornaNumerosDisponiveisComoString() {
		if (numerosDisponiveis != null && numerosDisponiveis.size() > 0) {
			List<String> numerosComoString = numerosDisponiveis.stream().map(numero -> String.valueOf(numero))
					.collect(Collectors.toList());
			return numerosComoString;
		}
		return new ArrayList<String>();
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

	public List<Integer> getNumerosDisponiveis() {
		return numerosDisponiveis;
	}

	public void setNumerosDisponiveis(List<Integer> numerosDisponiveis) {
		this.numerosDisponiveis = numerosDisponiveis;
	}

	public void setNumeros(boolean numeros) {
		this.numeros = numeros;
	}

	public int getMaximoDeRepeticoesPermitidas() {
		return maximoDeRepeticoesPermitidas;
	}

	public void setMaximoDeRepeticoesPermitidas(int maximoDeRepeticoesPermitidas) {
		if (maximoDeRepeticoesPermitidas <= 0)
			throw new RuntimeException("maximoDeRepeticoesPermitidas can't be 0 or less");

		this.maximoDeRepeticoesPermitidas = maximoDeRepeticoesPermitidas;
	}

	public boolean isUuid() {
		return uuid;
	}

	public void setUuid(boolean uuid) {
		this.uuid = uuid;
	}

}