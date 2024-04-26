package asp1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clientes clientes = new Clientes();
        Contas contas = new Contas();
        LogDeTransacoes logDeTransacoes = new LogDeTransacoes();

        while (true) {
        	System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Conta");
            System.out.println("3. Realizar Transação");
            System.out.println("4. Mostrar Log de Transações");
            System.out.println("5. Buscar Conta por CPF");
            System.out.println("6. Mostrar Todas as Contas");
            System.out.println("7. Mostrar Todos os Clientes");
            System.out.println("8. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = scanner.nextLine();
                    System.out.println("Digite o CPF do cliente:");
                    String cpfCliente = scanner.nextLine();
                    Cliente novoCliente = new Cliente(nomeCliente, cpfCliente);
                    clientes.adicionarCliente(novoCliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("Digite o número da conta:");
                    String numeroConta = scanner.nextLine();
                    System.out.println("Digite o saldo inicial da conta:");
                    double saldoInicial = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer do scanner
                    System.out.println("Digite o CPF do titular da conta:");
                    String cpfTitular = scanner.nextLine();
                    Cliente titular = clientes.encontrarCliente(cpfTitular);

                    if (titular != null) {
                        Conta novaConta = new Conta(numeroConta, saldoInicial, titular);
                        contas.adicionarConta(novaConta);
                        System.out.println("Conta cadastrada com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado. Cadastre o cliente primeiro.");
                    }
                    break;

                case 3:
                    System.out.println("Digite o número da conta de origem:");
                    String numContaOrigem = scanner.nextLine();
                    Conta contaOrigem = contas.encontrarConta(numContaOrigem);

                    System.out.println("Digite o valor da transação:");
                    double valorTransacao = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    System.out.println("Escolha o tipo de transação:");
                    System.out.println("1. Depósito");
                    System.out.println("2. Retirada");
                    System.out.println("3. Transferência");

                    int tipoTransacaoEscolha = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer do scanner

                    TipoTransacao tipoTransacao = TipoTransacao.values()[tipoTransacaoEscolha - 1];

                    if (tipoTransacao == TipoTransacao.TRANSFERENCIA) {
                        System.out.println("Digite o número da conta de destino:");
                        String numContaDestino = scanner.nextLine();
                        Conta contaDestino = contas.encontrarConta(numContaDestino);

                        if (contaOrigem != null && contaDestino != null) {
                            Transacao transferencia = new Transacao(contaOrigem, contaDestino, valorTransacao);
                            logDeTransacoes.adicionar(transferencia);
                            System.out.println("Transferência realizada com sucesso!");
                        } else {
                            System.out.println("Conta de origem ou destino não encontrada.");
                        }
                    } else {
                        if (contaOrigem != null) {
                            Transacao transacaoSimples = new Transacao(contaOrigem, valorTransacao, tipoTransacao);
                            logDeTransacoes.adicionar(transacaoSimples);
                            System.out.println("Transação realizada com sucesso!");
                        } else {
                            System.out.println("Conta de origem não encontrada.");
                        }
                    }
                    break;

                case 4:
                	logDeTransacoes.listarTransacoes();
                    break;
                    
                case 5:
                    System.out.println("Digite o CPF do titular da conta:");
                    String cpfTitularBusca = scanner.nextLine();
                    Cliente titularBusca = clientes.encontrarCliente(cpfTitularBusca);

                    if (titularBusca != null) {
                        System.out.println("Contas do titular " + titularBusca.getCPF() + ":");
                        for (Conta conta : contas.getContas()) {
                            if (conta.getTitular().getCPF().equals(cpfTitularBusca)) {
                                System.out.println("Número da Conta: " + conta.numeroConta());
                                System.out.println("Saldo Atual: " + conta.saldoAtual());
                            }
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 6:
                    contas.mostrarTodasContas();
                    break;
                case 7:
                    clientes.mostrarTodosClientes();
                    break;
                case 8:
                    System.out.println("Saindo do programa. Obrigado!");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}