/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;

/**
 *
 * @author Emilio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Conexion c=new Conexion("proyectoCA");
        } catch (SQLException ex) {
            System.out.println("No se ha establecido conexion con el servidor");
            System.out.println(ex.getMessage());
            
        }
        
    }
    
}
