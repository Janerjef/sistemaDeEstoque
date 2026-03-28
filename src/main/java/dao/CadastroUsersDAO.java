/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import model.CadastroUsuarioModel;

/**
 *
 * @author 232.004390
 */
public class CadastroUsersDAO {
    
    public boolean cadastrar(CadastroUsuarioModel user) {
        String sql = "INSERT INTO users" +
                "(username, psw, nameFirst, sobrenome, dtaNascimento, matricula, cpf, sexo, email, telefone, função, cep, endereço, bairro, cidade, estado, numero, complemento)" +
                "VALUE(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (var con = ConnectionFactory.getConnection()){
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSobrenome());
            stmt.setString(3, user.getCpf());
            stmt.setLong(4, user.getCep());
            stmt.setString(5, user.getEndereco());
            stmt.setString(6, user.getEstado());
            stmt.setString(7, user.getBairro());
            stmt.setString(8, user.getCidade());
            stmt.setLong(9, user.getNumero());
            stmt.setString(10, user.getComplemento());
            stmt.setString(11, user.getNomeUsuario());
            stmt.setString(12, user.getSenha());
            stmt.setString(13, user.getFuncao());
            
            stmt.executeUpdate();
            
            return true;
   
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
