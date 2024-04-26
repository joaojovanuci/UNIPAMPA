package trabalho_poo;

public class Ingrediente {
	private String nome;
    private double quantidadeEstoque;
    private String unidade;

    public Ingrediente(String nome, double quantidadeEstoque, String unidade) {
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
        this.unidade = unidade;
    }

    public String getNome() {
        return nome;
    }

    public double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getUnidade() {
        return unidade;
    }

    @Override
    public String toString() {
        return nome + ": " + quantidadeEstoque + " " + unidade;
    }
}
