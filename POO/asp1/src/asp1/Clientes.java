package asp1;

import java.util.ArrayList;

public class Clientes {
	private ArrayList<Cliente> clientes;

    public Clientes() {
        this.clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente encontrarCliente(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCPF().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }
    public void mostrarTodosClientes() {
        System.out.println("Lista de Todos os Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCPF());
            System.out.println("-----------------------------");
        }
    }
}
