/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revisao;
import javax.swing.table.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
;

/**
 *
 * @author douglas
 */
public class TelaAdd extends JFrame {

    private JPanel jPanel;
    private JLabel txtNome;
    private JTextField jtfNome;
    private JLabel txtTelefone;
    private JTextField jtfTelefone;
    private JLabel txtCid;
    private JTextField jtfCid;
    private JLabel txtEstado;
    private JComboBox<String> listaEstado;
    private JButton btnSalvar;
    private DefaultTableModel model;
    
    Process process = new Process();
            
    public TelaAdd(DefaultTableModel model) {
        this.model = model;
    
        setTitle("Adicionar");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(5,2));
        txtNome = new JLabel("Nome:");
        jtfNome = new JTextField(20);
        txtTelefone = new JLabel("Telefone:");
        jtfTelefone = new JTextField(20);
        txtCid = new JLabel("Cidade:");
        jtfCid = new JTextField(20);
        txtEstado = new JLabel("Estado:");
        listaEstado = new JComboBox<>(Constante.ESTADOS);
        btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> btnsalvarAdiciona(e));
        jPanel.add(txtNome);
        jPanel.add(jtfNome);
        jPanel.add(txtTelefone);
        jPanel.add(jtfTelefone);
        jPanel.add(txtCid);
        jPanel.add(jtfCid);
        jPanel.add(txtEstado);
        jPanel.add(listaEstado);
        jPanel.add(btnSalvar);
        add(jPanel, BorderLayout.CENTER);
    }
    
    public void btnsalvarAdiciona(ActionEvent e){
        
        String nome = jtfNome.getText();
        String telefone = jtfTelefone.getText();
        String cidade = jtfCid.getText();
        String estado = listaEstado.getSelectedItem().toString();
        try {
            process.AddAgenda(nome, telefone, cidade, estado);
            process.carregarDadosTabela(model);
            dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
