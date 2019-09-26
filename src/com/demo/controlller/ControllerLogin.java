package com.demo.controlller;

import com.demo.model.ModeloUsuario;
import com.demo.model.entity.Usuario;

/**
 *
 * @author Hijos
 */
public class ControllerLogin extends Controller {
//operaciones logicas

    public ControllerLogin() {
    }

    public boolean logIn(String usuario, String clave) {
        boolean band = false;
        Usuario user = new Usuario(usuario, clave);
        band = ModeloUsuario.logIn(user);
        return band;
    }

    public boolean logUp(int id, String email, String clave, String apellidos, String nombres, int tipo) {
        boolean band = false;
        Usuario user = new Usuario(id, email, clave, apellidos, nombres, tipo);
        band= ModeloUsuario.logUp(user);
        return band;
    }

    public boolean recuperarClave(String usuario, String clave, String claver) {
        //devuelve diferentes estados
        boolean band = false;
        
        if(clave.equals(claver)){
            
        Usuario user = new Usuario(usuario, clave);
        band = ModeloUsuario.recupera(user); 
        return band;
        }
        return band;
    }

}
