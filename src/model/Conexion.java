/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;

/**
 *
 * @author Emilio
 */
public class Conexion {
    private Connection con;
    private Statement sen; 
    private ResultSet rs;

    public Conexion(String bd) throws SQLException{
        String dbURL = "jdbc:sqlserver://localhost:1433"; //copiar url de la conexion ya creada
        
        con = DriverManager.getConnection(dbURL,"sa", "123456"); //dbURL, usuario, contraseña 
        System.out.println(dbURL);
        
        if (con != null) {
            System.out.println("Conectado");
        }else{
            System.out.println("No se ha podido inicializar conexion ");
        }         
    }
    
    public void ejecutar(String query) throws SQLException{
        sen=con.createStatement();
        sen.executeUpdate(query);
        sen.close();
    }    
    
    public ResultSet ejecutarSelect(String query) throws SQLException{
        sen=con.createStatement();
        rs=sen.executeQuery(query);
        return rs;        
    }

    public void desconectar() throws SQLException{
        sen.close();
    }
}
