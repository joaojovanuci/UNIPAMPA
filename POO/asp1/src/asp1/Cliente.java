package asp1;

public class Cliente {
	private String nome;
    private String CPF;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.CPF = cpf;
    }

    public String getCPF() {
        return CPF;
    }
    public String getNome() {
        return nome;
    }
}
