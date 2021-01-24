package br.com.rafawhitee.random.string.ascii;

import java.io.Serializable;
import java.util.Objects;

public class AsciiDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Character caractere;
    private Short index;

    public AsciiDTO (Character caractere, Short index){
        this.caractere = caractere;
        this.index = index;
    }

    public AsciiDTO (Character caractere, Integer index){
        this.caractere = caractere;
        this.index = (index != null) ? index.shortValue() : null;
    }

    public Character getCaractere() {
        return caractere;
    }

    public void setCaractere(Character caractere) {
        this.caractere = caractere;
    }

    public Short getIndex() {
        return index;
    }

    public void setIndex(Short index) {
        this.index = index;
    }

	@Override
	public int hashCode() {
		return Objects.hash(caractere, index);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AsciiDTO other = (AsciiDTO) obj;
		if (caractere == null) {
			if (other.caractere != null)
				return false;
		} else if (!caractere.equals(other.caractere))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Caractere : " + caractere);
		sb.append(" - ");
		sb.append("Index Ascii: " + index);
		return sb.toString();
	}

}