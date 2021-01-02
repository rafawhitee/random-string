package br.com.rafawhitee.random.string.ascii;

import java.io.Serializable;

public class AsciiDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String caractere;
    private Short index;

    public AsciiDTO (String caractere, Short index){
        this.caractere = caractere;
        this.index = index;
    }

    public AsciiDTO (String caractere, Integer index){
        this.caractere = caractere;
        this.index = (index != null) ? index.shortValue() : null;
    }

    public String getCaractere() {
        return caractere;
    }

    public void setCaractere(String caractere) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caractere == null) ? 0 : caractere.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		return result;
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

}