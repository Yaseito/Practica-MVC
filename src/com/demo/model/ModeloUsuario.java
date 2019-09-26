/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.controlller.conexion.Conexion;
import com.demo.model.entity.Usuario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hijos
 */
public class ModeloUsuario extends Model {

    Conexion cn = new Conexion();
    Connection con = cn.getConexion();

    static public boolean logIn(Usuario user) {
        boolean band = false;
        if (user.getEmail().compareTo("admin@gmail.com") == 0 && user.getClave().compareTo("123456") == 0) {
            band = true;
        } else {
            return band;
        }
        return band;
    }

    static public boolean logUp(Usuario user) {
        boolean band = false;
        try {
            PreparedStatement ps = con.prepareStatement("insert into Usuario(id_Usuario, Email,\n"
                    + "Clave, Apellidos ,Nombres,Tipo) values\n"
                    + "(?,?,?,?,?,?);");

            ps.setInt(1, (int) user.getId());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getClave());
            ps.setString(4, user.getApellidos());
            ps.setString(5, user.getNombres());
            ps.setInt(6, user.getTipo());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Correcto");
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());

        }
        return band;
    }

    static public boolean recupera(Usuario user) {
        boolean band = false;
       try {
            PreparedStatement ps = con.prepareStatement("update Usuario set Email='" + user.getEmail() + "' , " + "Clave='" + user.getClave() + "';");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos actualizados");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return band;
    }
}
