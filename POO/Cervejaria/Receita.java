package trabalho_poo;

import java.io.Serializable;
import java.util.List;

public class Receita implements Serializable{
	private String nome;
    private String descricao;
    private List<Ingrediente> ingredientes;

    public Receita(String nome, String descricao, List<Ingrediente> ingredientes) {
        this.nome = nome;
        this.descricao = descricao;
        this.ingredientes = ingredientes;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return "Receita: " + nome + " - Descrição: " + descricao;
    }
}
