package trabalho_poo;

import java.io.Serializable;

public class Adjunto extends Ingrediente implements Serializable {
	 private String descricao;

	    public Adjunto(String nome, double quantidadeEstoque, String unidade, String descricao) {
	        super(nome, quantidadeEstoque, unidade);
	        this.descricao = descricao;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

	    @Override
	    public String toString() {
	        return super.toString() + " - Descrição: " + descricao;
	    }
}
