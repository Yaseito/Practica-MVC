/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.entity.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hijos
 */
public class ModeloUsuario extends Model {

    static ArrayList<Usuario> luser = new ArrayList<>();

    static public boolean logIn(String correo, String contra) {
        boolean band = false;
        for (Usuario users : luser) {
            if (correo.equals(users.getEmail()) && contra.equals(users.getClave())) {
                band = true;
                break;
            } else {
                return band;
            }
        }
        return band;
    }

    static public boolean logUp(Usuario user) {
        boolean band = false;
        boolean control = false;
        for (Usuario users : luser) {
            if (user.getEmail().equals(users.getEmail())) {
                JOptionPane.showMessageDialog(null, "Este usuario ya existe");
                control = true;
                break;
            }
        }
        if (false == control) {
            luser.add(user);
            band = true;
        }
        return band;
    }

    static public boolean recupera(String correo, String contra) {
        boolean band = false;
        for (Usuario users : luser) {
            if (correo.equals(users.getEmail())) {
                users.setClave(contra);
                band = true;
                break;
            } else {
                return band;
            }
        }

        return band;
    }
}
