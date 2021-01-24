package br.com.rafawhitee.random.string.ascii;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AsciiUtil {

	private static final Integer DIFERENCA_INDEX_MAIUSCULAS_PARA_MINUSCULAS = 32;

	public static AsciiDTO findAsciiDTOByIndex(Short index) {
		List<AsciiDTO> todosAscii = getTodosAscii();
		Optional<AsciiDTO> optAsciiDTO = todosAscii.stream().filter(t -> t.getIndex().equals(index)).findFirst();
		return (optAsciiDTO.isPresent()) ? optAsciiDTO.get() : null;
	}

	public static AsciiDTO findAsciiDTOByIndex(String indexStr) {
		if (Objects.nonNull(indexStr)) {
			Short shortIndex = Short.valueOf(indexStr);
			return findAsciiDTOByIndex(shortIndex);
		}
		return null;
	}

	public static AsciiDTO findAsciiDTOByIndex(Integer index) {
		if (Objects.nonNull(index))
			return findAsciiDTOByIndex(index.toString());

		return null;
	}

	public static AsciiDTO findAsciiDTOByCharacter(Character character) {
		List<AsciiDTO> todosAscii = getTodosAscii();
		Optional<AsciiDTO> optAsciiDTO = todosAscii.stream().filter(t -> t.getCaractere().equals(character))
				.findFirst();
		return (optAsciiDTO.isPresent()) ? optAsciiDTO.get() : null;
	}

	public static AsciiDTO findAsciiDTOByCharacter(String stringOfCharacter) {
		if (Objects.nonNull(stringOfCharacter)) {
			char[] charArray = stringOfCharacter.toCharArray();
			if (Objects.nonNull(charArray) && charArray.length > 0) {
				Character character = charArray[0];
				return findAsciiDTOByCharacter(character);
			}
		}
		return null;
	}

	public static List<AsciiDTO> getTodosAscii() {
		List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
		List<AsciiDTO> numeros = getNumerosAscii();
		List<AsciiDTO> especiais = getCaracteresEspeciaisAscii();
		List<AsciiDTO> letras = getLetrasAscii();
		retorno.addAll(numeros);
		retorno.addAll(especiais);
		retorno.addAll(letras);
		return retorno;
	}

	public static List<Character> getTodos() {
		List<AsciiDTO> todos = getTodosAscii();
		List<Character> retorno = todos.stream().map(nu -> nu.getCaractere()).collect(Collectors.toList());
		return retorno;
	}

	public static List<AsciiDTO> getNumerosAscii() {
		List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
		adicionar(retorno, '0', 48);
		adicionar(retorno, '1', 49);
		adicionar(retorno, '2', 50);
		adicionar(retorno, '3', 51);
		adicionar(retorno, '4', 52);
		adicionar(retorno, '5', 53);
		adicionar(retorno, '6', 54);
		adicionar(retorno, '7', 55);
		adicionar(retorno, '8', 56);
		adicionar(retorno, '9', 57);
		return retorno;
	}

	public static List<Character> getNumeros() {
		List<AsciiDTO> numeros = getNumerosAscii();
		List<Character> retorno = numeros.stream().map(nu -> nu.getCaractere()).collect(Collectors.toList());
		return retorno;
	}

	public static List<AsciiDTO> getCaracteresEspeciaisAscii() {
		List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
		adicionar(retorno, '!', 33);
		adicionar(retorno, '#', 35);
		adicionar(retorno, '$', 36);
		adicionar(retorno, '%', 37);
		adicionar(retorno, '&', 38);
		adicionar(retorno, '*', 42);
		adicionar(retorno, '+', 43);
		adicionar(retorno, '/', 47);
		adicionar(retorno, '?', 63);
		adicionar(retorno, '_', 95);
		adicionar(retorno, '|', 124);
		adicionar(retorno, '~', 126);
		return retorno;
	}

	public static List<Character> getCaracteresEspeciais() {
		List<AsciiDTO> especiais = getCaracteresEspeciaisAscii();
		List<Character> retorno = especiais.stream().map(nu -> nu.getCaractere()).collect(Collectors.toList());
		return retorno;
	}

	public static List<AsciiDTO> getVogaisMaiusculasAscii() {
		List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
		adicionar(retorno, 'A', 65);
		adicionar(retorno, 'E', 69);
		adicionar(retorno, 'I', 73);
		adicionar(retorno, 'O', 79);
		adicionar(retorno, 'U', 85);
		return retorno;
	}

	public static List<Character> getVogaisMaiusculas() {
		List<AsciiDTO> vogaisMaiusculas = getVogaisMaiusculasAscii();
		List<Character> retorno = vogaisMaiusculas.stream().map(nu -> nu.getCaractere()).collect(Collectors.toList());
		return retorno;
	}

	public static List<AsciiDTO> getConsoantesMaiusculasAscii() {
		List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
		adicionar(retorno, 'B', 66);
		adicionar(retorno, 'C', 67);
		adicionar(retorno, 'D', 68);
		adicionar(retorno, 'F', 70);
		adicionar(retorno, 'G', 71);
		adicionar(retorno, 'H', 72);
		adicionar(retorno, 'J', 74);
		adicionar(retorno, 'K', 75);
		adicionar(retorno, 'L', 76);
		adicionar(retorno, 'M', 77);
		adicionar(retorno, 'N', 78);
		adicionar(retorno, 'P', 80);
		adicionar(retorno, 'Q', 81);
		adicionar(retorno, 'R', 82);
		adicionar(retorno, 'S', 83);
		adicionar(retorno, 'T', 84);
		adicionar(retorno, 'V', 86);
		adicionar(retorno, 'W', 87);
		adicionar(retorno, 'X', 88);
		adicionar(retorno, 'Y', 89);
		adicionar(retorno, 'Z', 90);
		return retorno;
	}

	public static List<Character> getConsoantesMaiusculas() {
		List<AsciiDTO> consoantesMaiusculas = getConsoantesMaiusculasAscii();
		List<Character> retorno = consoantesMaiusculas.stream().map(nu -> nu.getCaractere())
				.collect(Collectors.toList());
		return retorno;
	}

	public static List<AsciiDTO> getLetrasMaiusculasAscii() {
		List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
		retorno.addAll(getConsoantesMaiusculasAscii());
		retorno.addAll(getVogaisMaiusculasAscii());
		fazerSortPeloIndex(retorno);
		return retorno;
	}

	public static List<Character> getLetrasMaiusculas() {
		List<AsciiDTO> todos = getLetrasMaiusculasAscii();
		List<Character> retorno = todos.stream().map(nu -> nu.getCaractere()).collect(Collectors.toList());
		return retorno;
	}

	public static List<AsciiDTO> getLetrasMinusculasAscii() {
		List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
		List<AsciiDTO> letrasMaiusculas = getLetrasMaiusculasAscii();
		for (AsciiDTO asciiDTO : letrasMaiusculas)
			retorno.add(new AsciiDTO(parseToLower(asciiDTO.getCaractere()),
					asciiDTO.getIndex() + DIFERENCA_INDEX_MAIUSCULAS_PARA_MINUSCULAS));

		return retorno;
	}

	public static List<Character> getLetrasMinusculas() {
		List<AsciiDTO> minusculas = getLetrasMinusculasAscii();
		List<Character> retorno = minusculas.stream().map(nu -> nu.getCaractere()).collect(Collectors.toList());
		return retorno;
	}

	public static List<AsciiDTO> getLetrasAscii() {
		List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
		List<AsciiDTO> maiusculas = getLetrasMaiusculasAscii();
		List<AsciiDTO> minusculas = getLetrasMinusculasAscii();
		retorno.addAll(maiusculas);
		retorno.addAll(minusculas);
		return retorno;
	}

	public static List<Character> getLetras() {
		List<AsciiDTO> letras = getLetrasAscii();
		List<Character> retorno = letras.stream().map(nu -> nu.getCaractere()).collect(Collectors.toList());
		return retorno;
	}

	public static List<AsciiDTO> getVogaisMinusculasAscii() {
		List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
		List<AsciiDTO> vogaisMaiusculas = getVogaisMaiusculasAscii();
		for (AsciiDTO asciiDTO : vogaisMaiusculas)
			retorno.add(new AsciiDTO(parseToLower(asciiDTO.getCaractere()),
					asciiDTO.getIndex() + DIFERENCA_INDEX_MAIUSCULAS_PARA_MINUSCULAS));

		return retorno;
	}

	public static List<Character> getVogaisMinusculas() {
		List<AsciiDTO> vogaisMinusculas = getVogaisMinusculasAscii();
		List<Character> retorno = vogaisMinusculas.stream().map(nu -> nu.getCaractere()).collect(Collectors.toList());
		return retorno;
	}

	public static List<AsciiDTO> getConsontasMinusculasAscii() {
		List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
		List<AsciiDTO> consoantesMaiusculas = getConsoantesMaiusculasAscii();
		for (AsciiDTO asciiDTO : consoantesMaiusculas)
			retorno.add(new AsciiDTO(parseToLower(asciiDTO.getCaractere()),
					asciiDTO.getIndex() + DIFERENCA_INDEX_MAIUSCULAS_PARA_MINUSCULAS));

		return retorno;
	}

	public static List<Character> getConsontasMinusculas() {
		List<AsciiDTO> consoantesMinusculas = getConsontasMinusculasAscii();
		List<Character> retorno = consoantesMinusculas.stream().map(nu -> nu.getCaractere())
				.collect(Collectors.toList());
		return retorno;
	}

	/*** PRIVATE STATIC METHODS ***/
	private static Character parseToLower(Character character) {
		if (Objects.nonNull(character))
			return Character.toLowerCase(character);

		return null;
	}

	private static void fazerSortPeloIndex(List<AsciiDTO> listaAsciiDTO) {
		if (listaAsciiDTO != null && listaAsciiDTO.size() > 0)
			listaAsciiDTO.sort(Comparator.comparingInt(AsciiDTO::getIndex));
	}

	private static void adicionar(List<AsciiDTO> listaAsciiDTO, Character character, int index) {
		if (Objects.isNull(listaAsciiDTO))
			listaAsciiDTO = new ArrayList<AsciiDTO>();

		listaAsciiDTO.add(new AsciiDTO(character, index));
	}

}