/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.conexion.Conexion;
import com.demo.model.entity.Usuario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hijos
 */
public class ModeloUsuario extends Model {

    static private PreparedStatement ps;
    static private ResultSet rs;

    static public boolean logIn(String usuario, String contra) {
        boolean band = false;
        Connection con = Conexion.getConexion();
        try {
            ps = con.prepareStatement("select * from Usuario where Email=?;");

            ps.setString(1, usuario);

            rs = ps.executeQuery();
            if (rs.next()) {
                if (contra.equals(rs.getString("Clave"))) {
                    band = true;
                }
            }
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return band;
    }

    static public boolean logUp(Usuario user) {
        boolean band = false;
        Connection con = Conexion.getConexion();
        try {
            ps = con.prepareStatement("insert into Usuario(id_Usuario, Email,\n"
                    + "Clave, Apellidos ,Nombres,Tipo) values\n"
                    + "(?,?,?,?,?,?);");

            ps.setInt(1, (int) user.getId());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getClave());
            ps.setString(4, user.getApellidos());
            ps.setString(5, user.getNombres());
            ps.setInt(6, user.getTipo());

            ps.executeUpdate();
            band = true;
            con.close();
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return band;
    }

    static public boolean recupera(String correo, String contra) {
        boolean band = false;
        Connection con = Conexion.getConexion();       
        
        try {
            ps = con.prepareStatement("update Usuario set Clave=? where Email=?;");
            ps.setString(1, contra);
            ps.setString(2, correo);
            ps.executeUpdate();
            band=true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }
}
