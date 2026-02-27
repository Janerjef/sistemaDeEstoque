/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;


import connection.ConectionFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@WebServlet("/login") // caminho
public class Login extends HttpServlet {

    private static final long serialVersionUID = 1L;  

    protected void doPost(HttpServletRequest request, HttpServletResponse response)// fazemos uma requisição e uma resposta no servidor local
            throws ServletException, IOException {
        String usuario = request.getParameter("user"); // aqui falo qual parametro( name ) que uso no html 
        String senha = request.getParameter("passw");//aqui falo qual parametro( name ) que uso no html
        
        response.setContentType("text/html");// eu estou setando de que forma ele vai me responder ( em texto html ) 
        PrintWriter out = response .getWriter(); // escreve no html, fazendo o get do que será escrito 
                
                
        try (var con = ConectionFactory.getConnection()){
            String sql = "SELECT * FROM users WHERE username= ? AND psw= ?";
            
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
