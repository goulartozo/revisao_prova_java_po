/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package revisao;

import java.sql.*;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author douglas
 */
public class Process {

    
    public void AddAgenda(String nome, String telefone, String cidade, String estado) {
        String sql = "insert into agenda(nome,telefone,cidade,uf) values (?, ?, ?, ?);";
        
        try (Connection conexao = ConexaoBanco.abreConexao();
             PreparedStatement pst = conexao.prepareStatement(sql)) {
            
            pst.setString(1, nome);
            pst.setString(2, telefone);
            pst.setString(3, cidade);
            pst.setString(4, estado);
            
            pst.executeUpdate();
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            
        }
    }
    
    public void carregarDadosTabela(DefaultTableModel model){
        String sql = "SELECT nome, telefone, cidade FROM agenda;";
        
        try (Connection conexao = ConexaoBanco.abreConexao();
             PreparedStatement pst = conexao.prepareStatement(sql)) {
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
                String nome = rs.getString("nome");
                String telefone = rs.getString("telefone");
                String cidade = rs.getString("cidade");
            
                model.addRow(new Object[]{nome, telefone, cidade});
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            
        }
        
    }
}
