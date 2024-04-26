package asp3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CriptografiaCesarGUI extends JFrame {
	private JTextArea textoOriginalArea;
    private JTextArea textoResultadoArea;

    public CriptografiaCesarGUI() {
        super("Cifra de César - Criptografia");

        // Configurações da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Componentes
        textoOriginalArea = new JTextArea(10, 30);
        textoResultadoArea = new JTextArea(10, 30);
        JButton criptografarButton = new JButton("Criptografar");
        JButton descriptografarButton = new JButton("Descriptografar");
        JButton salvarCriptografadoButton = new JButton("Salvar Criptografado");
        JButton salvarDescriptografadoButton = new JButton("Salvar Descriptografado");
        JButton abrirArquivoButton = new JButton("Abrir Arquivo");

        // Layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Texto Original:"));
        add(new JScrollPane(textoOriginalArea));
        add(criptografarButton);
        add(descriptografarButton);
        add(abrirArquivoButton);
        add(new JLabel("Texto Resultado:"));
        add(new JScrollPane(textoResultadoArea));
        add(salvarCriptografadoButton);
        add(salvarDescriptografadoButton);

        // Listeners
        abrirArquivoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirArquivo();
            }
        });

        criptografarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CriptografiaCesar criptografia = new CriptografiaCesar();
                String textoCriptografado = criptografia.cifrar(textoOriginalArea.getText(), 5);
                textoResultadoArea.setText(textoCriptografado);
            }
        });

        descriptografarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CriptografiaCesar criptografia = new CriptografiaCesar();
                String textoDescriptografado = criptografia.decifrar(textoResultadoArea.getText(), 5);
                textoOriginalArea.setText(textoDescriptografado);
            }
        });

        salvarCriptografadoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManipuladorArquivo.salvarArquivo(textoResultadoArea.getText(), "arquivo_criptografado.txt");
            }
        });

        salvarDescriptografadoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManipuladorArquivo.salvarArquivo(textoOriginalArea.getText(), "arquivo_descriptografado.txt");
            }
        });

        // Chame setVisible aqui
        setVisible(true);
    }

    private void abrirArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Texto", "txt");
        fileChooser.setFileFilter(filter);

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File arquivoSelecionado = fileChooser.getSelectedFile();
            try {
                String conteudoArquivo = ManipuladorArquivo.lerArquivo(arquivoSelecionado);
                textoOriginalArea.setText(conteudoArquivo);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao ler o arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
