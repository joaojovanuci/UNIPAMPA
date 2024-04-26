package trabalho_poo;

import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CervejariaGUI extends JFrame implements Observador {
    private CervejariaManager cervejariaManager;
    private JTextArea ingredientesTextArea;
    private JTextArea receitasTextArea;
    private JTextArea cervejasTextArea;

    public CervejariaGUI() {
        this.cervejariaManager = new CervejariaManager();
        this.cervejariaManager.adicionarObservador(this);
        initComponents();
    }

    private void initComponents() {
        setTitle("Cervejaria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 3, 1, 1));

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem salvarCervejasItem = new JMenuItem("Salvar Cervejas");
        fileMenu.add(salvarCervejasItem);

        salvarCervejasItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu.salvarCervejas(cervejariaManager);
            }
        });

        JButton adicionarIngredienteButton = new JButton("Adicionar Ingrediente");
        JButton adicionarReceitaButton = new JButton("Adicionar Receita");
        JButton adicionarProducaoButton = new JButton("Adicionar Cerveja");
        
        adicionarIngredienteButton.setFocusable(false);
        
        adicionarReceitaButton.setFocusable(false);
        
        adicionarProducaoButton.setFocusable(false);
        
        ingredientesTextArea = new JTextArea();
        JScrollPane ingredientesScrollPane = new JScrollPane(ingredientesTextArea);
        ingredientesTextArea.setEditable(false);
        
        receitasTextArea = new JTextArea();
        JScrollPane receitasScrollPane = new JScrollPane(receitasTextArea);
        receitasTextArea.setEditable(false);
        
        cervejasTextArea = new JTextArea();
        JScrollPane cervejasScrollPane = new JScrollPane(cervejasTextArea);
        cervejasTextArea.setEditable(false);
        
        panel.add(adicionarIngredienteButton);
        panel.add(adicionarReceitaButton);
        panel.add(adicionarProducaoButton);
        panel.add(ingredientesScrollPane);
        panel.add(receitasScrollPane);
        panel.add(cervejasScrollPane);

        atualizarIngredientesTextArea();
        atualizarReceitasTextArea();
        atualizarCervejasTextArea();

        adicionarIngredienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MenuHandler.adicionarIngredienteOpcoes(cervejariaManager);
            }
        });

        adicionarReceitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MenuHandler.adicionarReceita(cervejariaManager);
            }
        });

        adicionarProducaoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MenuHandler.adicionarProducaoCerveja(cervejariaManager);
            }
        });

        add(panel);
        setVisible(true);
    }
    
    public void atualizarIngredientesTextArea() {
        List<Ingrediente> ingredientes = cervejariaManager.getIngredientes();
        StringBuilder ingredientesText = new StringBuilder();

        if (ingredientes.isEmpty()) {
            ingredientesText.append("Não há ingredientes no estoque.");
        } else {
            ingredientesText.append("===== Ingredientes no Estoque =====\n");
            for (Ingrediente ingrediente : ingredientes) {
                ingredientesText.append(ingrediente).append("\n");
            }
            ingredientesText.append("============================");
        }

        ingredientesTextArea.setText(ingredientesText.toString());
    }


    public void atualizarReceitasTextArea() {
        List<Receita> receitas = cervejariaManager.getReceitas();
        StringBuilder receitasText = new StringBuilder();

        if (receitas.isEmpty()) {
            receitasText.append("Não há receitas cadastradas.");
        } else {
            receitasText.append("===== Receitas Cadastradas =====\n");
            for (Receita receita : receitas) {
                receitasText.append(receita.getNome()).append(": ").append(obterNomesIngredientes(receita)).append("\n");
            }
            receitasText.append("===============================");
        }

        receitasTextArea.setText(receitasText.toString());
    }

    public String obterNomesIngredientes(Receita receita) {
        List<Ingrediente> ingredientes = receita.getIngredientes();
        StringBuilder nomesIngredientes = new StringBuilder();

        for (Ingrediente ingrediente : ingredientes) {
            nomesIngredientes.append(ingrediente.getNome()).append(", ");
        }

        // Remover a vírgula extra no final, se houver ingredientes
        if (nomesIngredientes.length() > 0) {
            nomesIngredientes.setLength(nomesIngredientes.length() - 2);
        }

        return nomesIngredientes.toString();
    }

    public void atualizarCervejasTextArea() {
        List<Cerveja> cervejasProduzidas = cervejariaManager.getCervejas();
        StringBuilder cervejasText = new StringBuilder();

        if (cervejasProduzidas.isEmpty()) {
            cervejasText.append("Não há cervejas produzidas em estoque.");
        } else {
            cervejasText.append("===== Cervejas Produzidas =====\n");
            for (Cerveja cerveja : cervejasProduzidas) {
                cervejasText.append(cerveja).append("\n");
            }
            cervejasText.append("===============================");
        }

        cervejasTextArea.setText(cervejasText.toString());
    }
    public void atualizar() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                atualizarIngredientesTextArea();
                atualizarReceitasTextArea();
                atualizarCervejasTextArea();
            }
        });
    }
}
