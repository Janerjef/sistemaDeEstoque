/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

/**
 *
 * @author 232.004390
 */
public class ConnectionFactory {
    // Pra criar a conexão, preciso de 1. Dados da conexão
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL =
            "jdbc:mysql://localhost:3306/kids_store?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "cimatec";
    
    // 2.Métodos
    public static Connection getConnection() {
        Connection con = null;
        
        try {
            class.forName(DRIVER);
            con = DriverManeger.getconnection(URL, USER, PASSWORD);
            System.out.println("Banco de dados conectado.");
        } catch (Exception e) {
            System.out.println("Banco de dados não conectado.");
            e.printStackTrace();
        }
        return con;
    }
}
