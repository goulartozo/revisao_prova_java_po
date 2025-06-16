package revisao;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;


/**
*
* @author m132175
*/
public class Tela extends JFrame{

    private JPanel jpTable;
    private JLabel txtEstado;
    private JComboBox<String> listaEstado;
    private JButton btnLocalizar;
    private JTable tblInfos;

    private JPanel jpInfos;
    private JLabel txtNome;
    private JLabel regNome;
    private JLabel txtTelefone;
    private JLabel regTelefone;
    private JLabel txtCid;
    private JLabel regCidade;
    private JButton btnNovoRegistro;

    public Tela(){

    setTitle("revisao prova");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(500, 400);
    setLayout(new BorderLayout());
    

    jpTable = new JPanel();
    txtEstado = new JLabel("Estado");
    listaEstado = new JComboBox<>(Constante.ESTADOS);
    btnLocalizar = new JButton("Localizar");
    tblInfos = new JTable();

    jpTable.add(txtEstado);
    jpTable.add(listaEstado);
    jpTable.add(btnLocalizar);
    jpTable.add(tblInfos);
    add(jpTable, BorderLayout.NORTH);
    
    jpInfos = new JPanel();
    jpInfos.setLayout(new GridLayout(4, 3));
    txtNome = new JLabel("Nome:");
    regNome = new JLabel("Eu");
    txtTelefone = new JLabel("Telefone:");
    regTelefone = new JLabel("999999999");
    txtCid = new JLabel("Cidade:");
    regCidade = new JLabel("SANTA CITY");
    btnNovoRegistro = new JButton("Novo registro");
    btnNovoRegistro.addActionListener(e -> adicionarRegistro(e));
    jpInfos.add(txtNome);
    jpInfos.add(regNome);
    jpInfos.add(txtTelefone);
    jpInfos.add(regTelefone);
    jpInfos.add(txtCid);
    jpInfos.add(regCidade);
    jpInfos.add(btnNovoRegistro);
    add(jpInfos, BorderLayout.CENTER);

    }
    
    public void adicionarRegistro(ActionEvent e){
        
        try {
            TelaAdd telaAdd = new TelaAdd();
            telaAdd.setVisible(true);
        } catch (Exception ev) {
        }
        
    }
    
}