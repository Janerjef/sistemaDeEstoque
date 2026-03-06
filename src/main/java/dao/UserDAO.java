/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import connection.ConectionFactory;
import model.UserModel;

/**
 *
 * @author 232.005495
 */
public class UserDAO {
    public boolean validarLogin(UserModel userModel){
        String sql = "SELECT * FROM users WHERE username= ? AND psw= ?";
    }
    
    
    try (var con = ConectionFactory.getConnection()){
           
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2,senha);
            
            ResultSet rs = stmt.executeQuery(); 
            if(rs.next()){
                response.sendRedirect("Pages/dashBoard.html");
                        
            }else{
                out.println("<h2>Usuario ou senha invalidos</h2>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Erro ao conectar com o banco de dados</h2>");
        }
        
    }
}
