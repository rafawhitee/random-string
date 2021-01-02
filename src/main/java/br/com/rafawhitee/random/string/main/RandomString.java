package br.com.rafawhitee.random.string.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import br.com.rafawhitee.random.string.ascii.AsciiDTO;
import br.com.rafawhitee.random.string.ascii.AsciiUtil;

public class RandomString {

	private ConfigRandomString configuracao;
	private List<String> caracteres;
	private List<AsciiDTO> tabelaAsciiDTO;
	private List<Integer> indexesJaInseridos;

	// Construtor
	public RandomString(ConfigRandomString configuracao) {
		this.configuracao = configuracao;
		validarConfiguracao();
		this.tabelaAsciiDTO = retornaTabelaAsciiDTO();
		this.indexesJaInseridos = new ArrayList<Integer>();
		popularListaCaractere(configuracao.isNumeros());
	}

	private void validarConfiguracao() {
		if (configuracao == null)
			throw new RuntimeException("Configuração do RandomPassword está nulo");
	}

	public ConfigRandomString getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(ConfigRandomString configuracao) {
		this.configuracao = configuracao;
	}

	private void popularListaCaractere(boolean numeros) {
		caracteres = new ArrayList<String>();
		List<String> asciiDTOCaracteres = tabelaAsciiDTO.stream().map(a -> a.getCaractere())
				.collect(Collectors.toList());
		caracteres.addAll(asciiDTOCaracteres);

		if (numeros)
			caracteres.addAll(configuracao.retornaNumerosDisponiveisComoString());
	}

	public String random() {
		return random(configuracao.getTamanhoSenha());
	}

	public String random(int tamanhoSenha) {
		validarTamanhoSenha(tamanhoSenha);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tamanhoSenha; i++) {
			int indexAleatorioAtual = randomizarIndex();
			indexesJaInseridos.add(indexAleatorioAtual);
			sb.append(getCaractere(indexAleatorioAtual));
		}
		return sb.toString();
	}

	private List<AsciiDTO> retornaTabelaAsciiDTO() {
		List<AsciiDTO> tabelaAsciiDTO = new ArrayList<AsciiDTO>();
		if (configuracao.isMaiusculas())
			tabelaAsciiDTO.addAll(AsciiUtil.getLetrasMaiusculas());

		if (configuracao.isMinusculas())
			tabelaAsciiDTO.addAll(AsciiUtil.getLetrasMinusculas());

		if (configuracao.isCaracteresEspeciais())
			tabelaAsciiDTO.addAll(AsciiUtil.getCaracteresEspeciais());

		return tabelaAsciiDTO;
	}

	private int randomizarIndex() {
		int indexFinal = caracteres.size() - 1;
		boolean contains = true;
		int numeroAleatorio = -1;
		while (contains) {
			numeroAleatorio = ThreadLocalRandom.current().nextInt(0, indexFinal);
			contains = indexesJaInseridos.contains(numeroAleatorio);
		}
		return numeroAleatorio;
	}

	private void validarTamanhoSenha(int tamanhoSenha) {
		if (tamanhoSenha <= 0)
			throw new RuntimeException("O tamanho da senha não pode ser igual ou menor que 0");
	}

	private String getCaractere(int index) {
		return (caracteres != null && caracteres.size() > 0) ? caracteres.get(index) : null;
	}

	public List<String> getCaracteres() {
		return caracteres;
	}

	public void setCaracteres(List<String> caracteres) {
		this.caracteres = caracteres;
	}

	public List<AsciiDTO> getTabelaAsciiDTO() {
		return tabelaAsciiDTO;
	}

	public void setTabelaAsciiDTO(List<AsciiDTO> tabelaAsciiDTO) {
		this.tabelaAsciiDTO = tabelaAsciiDTO;
	}

	public List<Integer> getIndexesJaInseridos() {
		return indexesJaInseridos;
	}

	public void setIndexesJaInseridos(List<Integer> indexesJaInseridos) {
		this.indexesJaInseridos = indexesJaInseridos;
	}

}