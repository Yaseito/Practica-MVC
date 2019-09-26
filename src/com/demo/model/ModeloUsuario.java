/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.entity.Usuario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Hijos
 */
public class ModeloUsuario extends Model {

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
        FileWriter flwriter = null;
        try {
            //crea el flujo para escribir en el archivo
            flwriter = new FileWriter("G:\\DemoMVC\\Usuario.txt");
            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            //escribe los datos en el archivo
            bfwriter.write("Id: " + user.getId() + "\n Email: " + user.getEmail() + "\n  Clave:" + user.getClave()
                    + "\n Apellidos: " + user.getApellidos() + "\n Nombres: " + user.getNombres() + "\n Tipo:" + user.getTipo() + "\n");

            //cierra el buffer intermedio
            bfwriter.close();
            band=true;
        } catch (IOException e) {
            e.printStackTrace();
        }
          return band;
    }

    static public boolean recupera(Usuario user) {
        boolean band = false;
            FileWriter flwriter = null;
        try {
            //crea el flujo para escribir en el archivo
            flwriter = new FileWriter("\\Usuario.txt");
            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            BufferedWriter bfwriter = new BufferedWriter(flwriter);

            //Modifica datos en el archivo
            bfwriter.write("Se modifica la contraseña de: " + user.getEmail() + " por: " + user.getClave()
                    + "\n");

            //cierra el buffer intermedio
            bfwriter.close();
            band = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return band;
    }
}
