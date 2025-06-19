package revisao;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;


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
    private DefaultTableModel model;

    Process process = new Process();
    
    public Tela(){

    setTitle("revisao prova");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(500, 400);
    setLayout(new BorderLayout());
    

    jpTable = new JPanel();
    txtEstado = new JLabel("Estado");
    listaEstado = new JComboBox<>(Constante.ESTADOS);
    btnLocalizar = new JButton("Localizar");
    btnLocalizar.addActionListener(e -> buscaPorEstado(e));
    
    jpTable.add(txtEstado);
    jpTable.add(listaEstado);
    jpTable.add(btnLocalizar);
    add(jpTable, BorderLayout.NORTH);
    
    //Criar o modelo de tabela
    model = new DefaultTableModel();
    model.addColumn("Nome");
    model.addColumn("Idade");
    model.addColumn("Cidade");
    tblInfos = new JTable(model);
    
    tblInfos.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
            gravarRegistros(e);
        }
    });
    
    JScrollPane jScrollPane = new JScrollPane(tblInfos);
    add(jScrollPane, BorderLayout.CENTER);
    
    jpInfos = new JPanel();
    jpInfos.setLayout(new GridLayout(4, 3, 10, 10));
    jpInfos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    txtNome = new JLabel("Nome:");
    regNome = new JLabel();
    txtTelefone = new JLabel("Telefone:");
    regTelefone = new JLabel();
    txtCid = new JLabel("Cidade");
    regCidade = new JLabel();
    btnNovoRegistro = new JButton("Novo registro");
    btnNovoRegistro.addActionListener(e -> adicionarRegistro(e));
    jpInfos.add(txtNome);
    jpInfos.add(regNome);
    jpInfos.add(txtTelefone);
    jpInfos.add(regTelefone);
    jpInfos.add(txtCid);
    jpInfos.add(regCidade);
    jpInfos.add(btnNovoRegistro);
    add(jpInfos, BorderLayout.SOUTH);
    }
    
    public void adicionarRegistro(ActionEvent e){
        
        try {
            TelaAdd telaAdd = new TelaAdd(model);
            telaAdd.setVisible(true);
        } catch (Exception ev) {
            ev.printStackTrace();
        }
        
    }
    
    public void buscaPorEstado(ActionEvent e){
        String estado = listaEstado.getSelectedItem().toString();
        
        try {
            
            process.carregarDadosTabelaPorEstado(model, estado);
           
        } catch (Exception ev) {
            ev.printStackTrace();
        }
    }
    
    public void gravarRegistros(MouseEvent e){
        int linhaSelecionada = tblInfos.getSelectedRow();
        
        if (linhaSelecionada != -1) {
            Object valorCol0 = tblInfos.getValueAt(linhaSelecionada, 0);
            Object valorCol1 = tblInfos.getValueAt(linhaSelecionada, 1);
            Object valorCol2 = tblInfos.getValueAt(linhaSelecionada, 2);
            
            regNome.setText(valorCol0.toString());
            regTelefone.setText(valorCol1.toString());
            regCidade.setText(valorCol2.toString());
        }
        
        
    }
}