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

    public long logUp() {
        long status = 0;
        return status;
    }

    public long recuperarClave() {
        //devuelve diferentes estados
        long status = 0;
        return status;
    }

}
