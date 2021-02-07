package br.com.rafawhitee.random.string.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import br.com.rafawhitee.random.string.ascii.AsciiUtil;

public class RandomString {

	private static final String NOME_MINUSCULA = "Letra minúscula";
	private static final String NOME_MAIUSCULA = "Letra maiúscula";
	private static final String NOME_CHAR_ESPECIAL = "Caractere especial";
	private static final String NOME_NUMERO = "Número";

	private ConfigRandomString configuracao;
	private List<Character> caracteres;
	private List<Character> caracteresDisponiveis;
	private List<Integer> indexesJaInseridos;

	// Listas para restrições
	private List<Character> caracteresEspeciaisRestricoes;
	private List<Character> numerosRestricoes;
	private List<Character> maiusculasRestricoes;
	private List<Character> minusculasRestricoes;

	// Construtor
	public RandomString() {
		inicializarValoresPadroes();
	}

	public RandomString(int tamanho) {
		inicializarValoresPadroes();
		configuracao.setTamanho(tamanho);
	}

	private void inicializarValoresPadroes() {
		this.configuracao = new ConfigRandomString();
		this.caracteres = new ArrayList<Character>();
		this.indexesJaInseridos = new ArrayList<Integer>();
	}

	/* Métodos para manipular a Config */
	public RandomString caracteresEspeciais() {
		this.configuracao.setCaracteresEspeciais(true);
		return this;
	}

	public RandomString caracteresEspeciais(List<Character> caracteresEspeciais) {
		this.configuracao.setCaracteresEspeciais(true);
		this.caracteresEspeciaisRestricoes = caracteresEspeciais;
		validarCaracteresEspeciais();
		return this;
	}

	private void validarCaracteresEspeciais() {
		if (Objects.isNull(caracteresEspeciaisRestricoes) || caracteresEspeciaisRestricoes.isEmpty())
			return;
		verificarCaractereNaListaAsciiDisponivel(AsciiUtil.getCaracteresEspeciais(), caracteresEspeciaisRestricoes,
				NOME_CHAR_ESPECIAL);
	}
	
	public RandomString repetir(int maximoDeRepeticoes) {
		this.configuracao.setMaximoDeRepeticoesPermitidas(maximoDeRepeticoes);
		return this;
	}
	
	public RandomString uuid() {
		this.configuracao.setUuid(true);
		return this;
	}

	public RandomString tamanho(int tamanho) {
		this.configuracao.setTamanho(tamanho);
		return this;
	}

	public RandomString maiusculas() {
		this.configuracao.setMaiusculas(true);
		return this;
	}

	public RandomString maiusculas(List<Character> maiusculas) {
		this.configuracao.setMaiusculas(true);
		this.maiusculasRestricoes = maiusculas;
		validarMaiusculas();
		return this;
	}

	private void validarMaiusculas() {
		if (Objects.nonNull(maiusculasRestricoes) || !maiusculasRestricoes.isEmpty())
			verificarCaractereNaListaAsciiDisponivel(AsciiUtil.getLetrasMaiusculas(), maiusculasRestricoes,
					NOME_MAIUSCULA);
	}

	public RandomString minusculas() {
		this.configuracao.setMinusculas(true);
		return this;
	}

	public RandomString minusculas(List<Character> minusculas) {
		this.configuracao.setMinusculas(true);
		this.minusculasRestricoes = minusculas;
		validarMinusculas();
		return this;
	}

	private void validarMinusculas() {
		if (Objects.isNull(minusculasRestricoes) || minusculasRestricoes.isEmpty())
			return;
		verificarCaractereNaListaAsciiDisponivel(AsciiUtil.getLetrasMinusculas(), minusculasRestricoes, NOME_MINUSCULA);
	}

	public RandomString numeros() {
		this.configuracao.setNumeros(true);
		return this;
	}

	public RandomString numeros(List<Character> numeros) {
		this.configuracao.setNumeros(true);
		numerosRestricoes = numeros;
		validarNumeros();
		return this;
	}

	private void validarNumeros() {
		if (Objects.isNull(numerosRestricoes) || numerosRestricoes.isEmpty())
			return;
		verificarCaractereNaListaAsciiDisponivel(AsciiUtil.getNumeros(), numerosRestricoes, NOME_NUMERO);
	}

	/* PRIVATE's */
	private void verificarCaractereNaListaAsciiDisponivel(List<Character> listaAscii, List<Character> listaEscolhida,
			String tipo) {
		for (Character currentCharEscolhida : listaEscolhida) {
			if (!listaAscii.contains(currentCharEscolhida))
				throw new RuntimeException(tipo + " inválido(a)");
		}
	}

	private UUID createUuid() {
		return UUID.randomUUID();
	}

	private String createUiidString() {
		UUID uuid = createUuid();
		return uuid.toString();
	}

	public String random() {
		if (configuracao.isUuid()) {
			inicializarValoresPadroes();
			return createUiidString();
		}

		int tamanhoSenha = configuracao.getTamanho();
		validarTamanhoSenha(tamanhoSenha);
		popularListaCaractere();
		validarSePodeFazerForParaRandomizar();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tamanhoSenha; i++) {
			int indexAleatorioAtual = randomizarIndex();
			if (indexAleatorioAtual >= 0) {
				indexesJaInseridos.add(indexAleatorioAtual);
				Character escolhido = getCaractere(indexAleatorioAtual);
				removerEscolhidoDosDisponiveis(escolhido);
				sb.append(escolhido);
			}
		}
		inicializarValoresPadroes();
		return sb.toString();
	}

	private void removerEscolhidoDosDisponiveis(Character escolhido) {
		if (Objects.nonNull(escolhido) && Objects.nonNull(caracteresDisponiveis) && !caracteresDisponiveis.isEmpty()) {
			caracteresDisponiveis.remove(escolhido);
		}
	}

	private void validarSePodeFazerForParaRandomizar() {
		int quantidadeQuePodeRepetir = configuracao.getMaximoDeRepeticoesPermitidas();
		int tamanhoRandomEscolhido = configuracao.getTamanho();
		int tamanhoDaLista = caracteres.size();
		int tamanhoFinalDaLista = (quantidadeQuePodeRepetir <= 0) ? tamanhoDaLista
				: (tamanhoDaLista * (quantidadeQuePodeRepetir + 1));
		if (tamanhoFinalDaLista < tamanhoRandomEscolhido)
			throw new RuntimeException(
					"Lista escolhida pequena, escolha: mais configuração / diminuir o tamanho da string / colocar quantidade para repetição maior");
	}

	private void popularListaCaractere() {
		caracteres = new ArrayList<Character>();
		popularMaiusculasSeSelecionado();
		popularMinusculasSeSelecionado();
		popularCaracteresEspeciaisSeSelecionado();
		popularNumerosSeSelecionado();
		validarListaCaracteres();
		popularListaCaracteresDisponiveis();
	}

	private void popularListaCaracteresDisponiveis() {
		caracteresDisponiveis = new ArrayList<>();
		if (Objects.nonNull(caracteres) && !caracteres.isEmpty()) {
			caracteresDisponiveis.addAll(caracteres);
			inserirQuantidadeDisponivieisParaRepeticao();
		}
	}
	
	private void inserirQuantidadeDisponivieisParaRepeticao() {
		if(podeRepetir()) {
			for(int i = 0 ; i < configuracao.getMaximoDeRepeticoesPermitidas() ; i++) {
				caracteresDisponiveis.addAll(caracteres);
			}
		}
	}

	private void popularMaiusculasSeSelecionado() {
		if (configuracao.isMaiusculas()) {
			if (Objects.nonNull(maiusculasRestricoes) && !maiusculasRestricoes.isEmpty())
				caracteres.addAll(maiusculasRestricoes);
			else
				caracteres.addAll(AsciiUtil.getLetrasMaiusculas());
		}
	}

	private void popularMinusculasSeSelecionado() {
		if (configuracao.isMinusculas()) {
			if (Objects.nonNull(minusculasRestricoes) && !minusculasRestricoes.isEmpty())
				caracteres.addAll(minusculasRestricoes);
			else
				caracteres.addAll(AsciiUtil.getLetrasMinusculas());
		}
	}

	private void popularCaracteresEspeciaisSeSelecionado() {
		if (configuracao.isCaracteresEspeciais()) {
			if (Objects.nonNull(caracteresEspeciaisRestricoes) && !caracteresEspeciaisRestricoes.isEmpty())
				caracteres.addAll(caracteresEspeciaisRestricoes);
			else
				caracteres.addAll(AsciiUtil.getCaracteresEspeciais());
		}
	}

	private void popularNumerosSeSelecionado() {
		if (configuracao.isNumeros()) {
			if (Objects.nonNull(numerosRestricoes) && !numerosRestricoes.isEmpty())
				caracteres.addAll(numerosRestricoes);
			else
				caracteres.addAll(AsciiUtil.getNumeros());
		}
	}

	private void validarListaCaracteres() {
		if (Objects.nonNull(caracteres) && caracteres.isEmpty())
			caracteres.addAll(AsciiUtil.getTodos());
	}

	private Integer randomizarIndex() {
		int indexFinal = caracteresDisponiveis.size() - 1;
		Integer numeroAleatorio = fazerLoopParaRandom(indexFinal);
		return numeroAleatorio;
	}

	private Integer fazerLoopParaRandom(int indexFinal) {
		Integer numeroAleatorio = null;
		while (true) {
			int indexFinalMaisUm = indexFinal + 1;
			numeroAleatorio = ThreadLocalRandom.current().nextInt(0, indexFinalMaisUm);
			boolean continuaLoop = continuaLoopParaRandom(numeroAleatorio);
			if (!continuaLoop)
				break;
		}
		return numeroAleatorio;
	}

	private boolean continuaLoopParaRandom(int numeroAleatorio) {
		boolean podeRepetir = podeRepetir();
		if (podeRepetir) {
			int quantidadeJaInserida = retornaQuantidadeJaInseridaDoIndex(numeroAleatorio);
			if (quantidadeJaInserida < this.configuracao.getMaximoDeRepeticoesPermitidas())
				return false;
		}
		return podeRepetir;
	}

	private boolean podeRepetir() {
		return Objects.nonNull(configuracao) && configuracao.getMaximoDeRepeticoesPermitidas() > 0;
	}

	private int retornaQuantidadeJaInseridaDoIndex(int numeroAleatorio) {
		if (Objects.nonNull(indexesJaInseridos))
			return (int) indexesJaInseridos.stream().filter(index -> index.intValue() == numeroAleatorio).count();

		return -1;
	}

	private void validarTamanhoSenha(int tamanhoSenha) {
		if (tamanhoSenha <= 0)
			throw new RuntimeException("O tamanho da senha deve ser maior que 0");
	}

	private Character getCaractere(int index) {
		return (Objects.nonNull(caracteresDisponiveis) && !caracteresDisponiveis.isEmpty())
				? caracteresDisponiveis.get(index)
				: null;
	}

	public List<Character> getCaracteresDisponiveis() {
		return caracteresDisponiveis;
	}

	public void setCaracteresDisponiveis(List<Character> caracteresDisponiveis) {
		this.caracteresDisponiveis = caracteresDisponiveis;
	}

}