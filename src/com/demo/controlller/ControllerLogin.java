package com.demo.controlller;

import com.demo.model.ModeloUsuario;
import com.demo.model.entity.Usuario;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Hijos
 */
public class ControllerLogin extends Controller {
//operaciones logicas

    public ControllerLogin() {
    }

    public void logIn(String usuario, String clave){
        if (ModeloUsuario.logIn(usuario, clave)) {
            JOptionPane.showMessageDialog(null, "Login Exitoso");

        } else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña Incorrecto");

        }
    }

    public void logUp(int id, String email, String clave, String apellidos, String nombres, int tipo) {
    
        Usuario user = new Usuario(id, email, clave, apellidos, nombres, tipo);
        if(ModeloUsuario.logUp(user)){
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        }else{
             JOptionPane.showMessageDialog(null, "Registro Incorrecto");           
        }
    }

    public void recuperarClave(String usuario, String clave, String claver) {

        if(clave.equals(claver)){
            if(ModeloUsuario.recupera(usuario, clave)){
                JOptionPane.showMessageDialog(null, "Usuario Recuperado");
            } else{
                JOptionPane.showMessageDialog(null, "Usuario No Existe");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Las contraseñas No Coinciden");
        }
    }

}
