package br.com.rafawhitee.random.string.ascii;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AsciiUtil {

    private static final Integer DIFERENCA_INDEX_MAIUSCULAS_PARA_MINUSCULAS = 32;

    public static List<AsciiDTO> getCaracteresEspeciais() {
        List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
        retorno.add(new AsciiDTO("!", 33));
        retorno.add(new AsciiDTO("#", 35));
        retorno.add(new AsciiDTO("$", 36));
        retorno.add(new AsciiDTO("%", 37));
        retorno.add(new AsciiDTO("&", 38));
        return retorno;
    }

    public static List<AsciiDTO> getVogaisMaiusculas(){
        List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
        retorno.add(new AsciiDTO("A", 65));
        retorno.add(new AsciiDTO("E", 69));
        retorno.add(new AsciiDTO("I", 73));
        retorno.add(new AsciiDTO("O", 79));
        retorno.add(new AsciiDTO("U", 85));
        return retorno;
    }

    public static List<AsciiDTO> getConsoantesMaiusculas(){
        List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
        retorno.add(new AsciiDTO("B", 66));
        retorno.add(new AsciiDTO("C", 67));
        retorno.add(new AsciiDTO("D", 68));
        retorno.add(new AsciiDTO("F", 70));
        retorno.add(new AsciiDTO("G", 71));
        retorno.add(new AsciiDTO("H", 72));
        retorno.add(new AsciiDTO("J", 74));
        retorno.add(new AsciiDTO("K", 75));
        retorno.add(new AsciiDTO("L", 76));
        retorno.add(new AsciiDTO("M", 77));
        retorno.add(new AsciiDTO("N", 78));
        retorno.add(new AsciiDTO("P", 80));
        retorno.add(new AsciiDTO("Q", 81));
        retorno.add(new AsciiDTO("R", 82));
        retorno.add(new AsciiDTO("S", 83));
        retorno.add(new AsciiDTO("T", 84));
        retorno.add(new AsciiDTO("V", 86));
        retorno.add(new AsciiDTO("W", 87));
        retorno.add(new AsciiDTO("X", 88));
        retorno.add(new AsciiDTO("Y", 89));
        retorno.add(new AsciiDTO("Z", 90));
        return retorno;
    }

    public static List<AsciiDTO> getLetrasMaiusculas(){
        List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
        retorno.addAll(getConsoantesMaiusculas());
        retorno.addAll(getVogaisMaiusculas());
        fazerSortPeloIndex(retorno);
        return retorno;
    }

    public static List<AsciiDTO> getLetrasMinusculas(){
        List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
        List<AsciiDTO> letrasMaiusculas = getLetrasMaiusculas();
        for(AsciiDTO asciiDTO : letrasMaiusculas)
            retorno.add(new AsciiDTO(asciiDTO.getCaractere().toLowerCase(), asciiDTO.getIndex() + DIFERENCA_INDEX_MAIUSCULAS_PARA_MINUSCULAS));

        return retorno;
    }

    public static List<AsciiDTO> getVogaisMinusculas(){
        List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
        List<AsciiDTO> vogaisMaiusculas = getVogaisMaiusculas();
        for(AsciiDTO asciiDTO : vogaisMaiusculas)
            retorno.add(new AsciiDTO(asciiDTO.getCaractere().toLowerCase(), asciiDTO.getIndex() + DIFERENCA_INDEX_MAIUSCULAS_PARA_MINUSCULAS));

        return retorno;
    }

    public static List<AsciiDTO> getConsontasMinusculas(){
        List<AsciiDTO> retorno = new ArrayList<AsciiDTO>();
        List<AsciiDTO> consoantesMaiusculas = getConsoantesMaiusculas();
        for(AsciiDTO asciiDTO : consoantesMaiusculas)
            retorno.add(new AsciiDTO(asciiDTO.getCaractere().toLowerCase(), asciiDTO.getIndex() + DIFERENCA_INDEX_MAIUSCULAS_PARA_MINUSCULAS));

        return retorno;
    }

    private static void fazerSortPeloIndex(List<AsciiDTO> listaAsciiDTO){
        if(listaAsciiDTO != null && listaAsciiDTO.size() > 0)
            listaAsciiDTO.sort(Comparator.comparingInt(AsciiDTO::getIndex));
    }


}