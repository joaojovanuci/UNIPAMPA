package asp2;

public class Pessoa implements Comparable<Pessoa> {
	 protected String nome;

	    public Pessoa(String nome) {
	        this.nome = nome;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    @Override
	    public int compareTo(Pessoa outraPessoa) {
	        return this.nome.compareTo(outraPessoa.nome);
	    }
}
