/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CadastroUsersDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.CadastroUsuarioModel;

/**
 *
 * @author 232.004390
 */
@WebServlet("/cadastro")
public class CadastroController extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        CadastroUsuarioModel user = new CadastroUsuarioModel();
        
        user.setNome(request.getParameter("nameFirst"));
        user.setSobrenome(request.getParameter("sobrenome"));
        user.setMatricula(request.getParameter("matricula"));
        user.setCpf(request.getParameter("cpf"));
        user.setSexo(request.getParameter("sexo"));
        user.setDtaNascimento(request.getParameter("dtaNascimento"));
        user.setEmail(request.getParameter("email"));
        user.setNome(request.getParameter("telefone"));
        user.setNome(request.getParameter("usuario"));
        user.setNome(request.getParameter("senha"));
        user.setNome(request.getParameter("funcao"));
        user.setNome(request.getParameter("cep"));
        user.setNome(request.getParameter("endereco"));
        user.setNome(request.getParameter("cidade"));
        user.setNome(request.getParameter("bairro"));
        user.setNome(request.getParameter("estado"));
        user.setNome(request.getParameter("numero"));
        user.setNome(request.getParameter("complemento"));  
        
        CadastroUsersDAO dao = new CadastroUsersDAO();
        
        if (dao.cadastrar(user)) {
            response.sendRedirect("pages/projeto.html");
        } else {
            response.sendRedirect("pages/cadastro.html");
        }
    }
}
