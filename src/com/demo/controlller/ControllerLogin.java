package com.demo.controlller;

import com.demo.model.ModeloUsuario;
import com.demo.model.entity.Usuario;
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
        if(ModeloUsuario.logIn(usuario,clave)){
            //Login correcto
            JOptionPane.showMessageDialog(null, "Login Correcto");
        } else {
            //login incorrecto
            JOptionPane.showMessageDialog(null, "Login Incorrecto");
        }     
    }

    public void logUp(int id, String email, String clave, String apellidos, String nombres, int tipo) {
        Usuario user = new Usuario(id, email, clave, apellidos, nombres, tipo);
        if(ModeloUsuario.logUp(user)){
            JOptionPane.showMessageDialog(null, "Registro Correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Registro incorrecto");
        }
    }

    public void recuperarClave(String usuario, String clave, String claver) {
        if(clave.equals(claver)){
            if(ModeloUsuario.recupera(usuario, clave)){
                JOptionPane.showMessageDialog(null, "Usuario recuperado");
            } else {
                JOptionPane.showMessageDialog(null, "Usuario No Existe");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
        }
        
    }

}
