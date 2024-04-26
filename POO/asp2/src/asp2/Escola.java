package asp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Escola {
	private String nome;
    private String telefone;
    private List<Aluno> alunos;
    private List<Instrutor> instrutores;
    private List<Turma> turmas;

    public Escola(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.alunos = new ArrayList<>();
        this.instrutores = new ArrayList<>();
        this.turmas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Instrutor> getInstrutores() {
        return instrutores;
    }

    public void setInstrutores(List<Instrutor> instrutores) {
        this.instrutores = instrutores;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public Aluno buscarAluno(long mat) throws ExcecaoAlunoNaoEncontrado {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula() == mat) {
                return aluno;
            }
        }
        throw new ExcecaoAlunoNaoEncontrado();
    }

    public void adicionarInstrutor(Instrutor instrutor) {
        instrutores.add(instrutor);
    }

    public Instrutor buscarInstrutor(long cod) throws ExcecaoInstrutorNaoEncontrado {
        for (Instrutor instrutor : instrutores) {
            if (instrutor.getCodigo() == cod) {
                return instrutor;
            }
        }
        throw new ExcecaoInstrutorNaoEncontrado();
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public Turma buscarTurma(long codTurma) throws ExcecaoTurmaNaoEncontrada {
        for (Turma turma : turmas) {
            if (turma.getCodTurma() == codTurma) {
                return turma;
            }
        }
        throw new ExcecaoTurmaNaoEncontrada();
    }

    public void listarTurma() {
        Collections.sort(turmas);
        for (Turma turma : turmas) {
            System.out.println(turma);
        }
    }
}
