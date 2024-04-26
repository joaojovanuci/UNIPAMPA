package asp2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Main {

    public static void main(String[] args) {
        Escola escola = new Escola("ECCD School", "123456789");

        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar/Buscar Aluno");
            System.out.println("2. Adicionar/Buscar Instrutor");
            System.out.println("3. Criar/Buscar Turma");
            System.out.println("4. Listar Turmas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    menuAluno(escola, scanner);
                    break;
                case 2:
                    menuInstrutor(escola, scanner);
                    break;
                case 3:
                    menuTurma(escola, scanner);
                    break;
                case 4:
                    escola.listarTurma();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 0);
    }

    private static void menuAluno(Escola escola, Scanner scanner) {
        System.out.println("\n--- Menu Aluno ---");
        System.out.println("1. Adicionar Aluno");
        System.out.println("2. Buscar Aluno");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (escolha) {
            case 1:
                System.out.print("Digite o nome do aluno: ");
                String nomeAluno = scanner.nextLine();
                System.out.print("Digite a matrícula do aluno: ");
                long matriculaAluno = scanner.nextLong();
                escola.adicionarAluno(new Aluno(nomeAluno, matriculaAluno));
                System.out.println("Aluno adicionado com sucesso!");
                break;
            case 2:
                System.out.print("Digite a matrícula do aluno a ser buscado: ");
                long matriculaBusca = scanner.nextLong();
                try {
                    Aluno alunoBuscado = escola.buscarAluno(matriculaBusca);
                    System.out.println("Aluno encontrado: " + alunoBuscado.getNome());
                } catch (ExcecaoAlunoNaoEncontrado e) {
                    System.out.println("Aluno não encontrado.");
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void menuInstrutor(Escola escola, Scanner scanner) {
        System.out.println("\n--- Menu Instrutor ---");
        System.out.println("1. Adicionar Instrutor");
        System.out.println("2. Buscar Instrutor");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (escolha) {
            case 1:
                System.out.print("Digite o nome do instrutor: ");
                String nomeInstrutor = scanner.nextLine();
                System.out.print("Digite o código do instrutor: ");
                long codigoInstrutor = scanner.nextLong();
                escola.adicionarInstrutor(new Instrutor(nomeInstrutor, codigoInstrutor));
                System.out.println("Instrutor adicionado com sucesso!");
                break;
            case 2:
                System.out.print("Digite o código do instrutor a ser buscado: ");
                long codigoBusca = scanner.nextLong();
                try {
                    Instrutor instrutorBuscado = escola.buscarInstrutor(codigoBusca);
                    System.out.println("Instrutor encontrado: " + instrutorBuscado.getNome());
                } catch (ExcecaoInstrutorNaoEncontrado e) {
                    System.out.println("Instrutor não encontrado.");
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void menuTurma(Escola escola, Scanner scanner) {
        System.out.println("\n--- Menu Turma ---");
        System.out.println("1. Adicionar Turma");
        System.out.println("2. Buscar Turma");
        System.out.print("Escolha uma opção: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        switch (escolha) {
            case 1:
                System.out.print("Digite o código da turma: ");
                long codTurma = scanner.nextLong();
                scanner.nextLine(); // Limpar o buffer do scanner
                System.out.print("Digite a data de início (formato YYYY-MM-DD): ");
                String dataInicioStr = scanner.nextLine();

                Date dataInicio = null;
                try {
                    dataInicio = new SimpleDateFormat("yyyy-MM-dd").parse(dataInicioStr);
                } catch (ParseException e) {
                    System.out.println("Formato de data inválido. Use o formato YYYY-MM-DD.");
                    return;
                }

                System.out.print("Digite a data de fim (formato YYYY-MM-DD): ");
                String dataFimStr = scanner.nextLine();

                Date dataFim = null;
                try {
                    dataFim = new SimpleDateFormat("yyyy-MM-dd").parse(dataFimStr);
                } catch (ParseException e) {
                    System.out.println("Formato de data inválido. Use o formato YYYY-MM-DD.");
                    return;
                }

                escola.adicionarTurma(new Turma(codTurma, dataInicio, dataFim));
                System.out.println("Turma adicionada com sucesso!");
                break;
            case 2:
                System.out.print("Digite o código da turma a ser buscada: ");
                long codTurmaBusca = scanner.nextLong();
                try {
                    Turma turmaBuscada = escola.buscarTurma(codTurmaBusca);
                    System.out.println("Turma encontrada: " + turmaBuscada.getCodTurma());
                } catch (ExcecaoTurmaNaoEncontrada e) {
                    System.out.println("Turma não encontrada.");
                }
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }
}

class ExcecaoAlunoNaoEncontrado extends Exception {
}

class ExcecaoInstrutorNaoEncontrado extends Exception {
}

class ExcecaoTurmaNaoEncontrada extends Exception {
}