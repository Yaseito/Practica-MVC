package com.demo.controlller;

import com.demo.model.ModeloUsuario;
import com.demo.model.entity.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hijos
 */
public class ControllerLogin extends Controller {
//operaciones logicas

    public ControllerLogin() {
    }

    public void logIn(String usuario, String clave) {
        if (ModeloUsuario.logIn(usuario, clave)) {
            JOptionPane.showMessageDialog(null, "Login Exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecto");
        }
    }

    public void logUp(int id, String email, String clave, String apellidos, String nombres, int tipo) {
        Usuario usuario = new Usuario(id, email, clave, apellidos, nombres, tipo);
        if (ModeloUsuario.logUp(usuario)==true) {
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "Registro Fallido");
        }
    }

    public void recuperarClave(String usuario, String clave, String claver) {
        //devuelve diferentes estados
        
        if (clave.equals(claver)) {
            if(ModeloUsuario.recupera(usuario, clave)){
                JOptionPane.showMessageDialog(null, "Usuario Recuperado");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario No Existe");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las claves no coinciden");
        }
    }

}
