/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.entity.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hijos
 */
public class ModeloUsuario extends Model {

    static File usuario = new File("Usuario.txt");

    static public boolean logIn(String user, String contra){
        boolean band = false;

        try {
            FileReader fread = new FileReader(usuario);
            //crea un buffer o flujo intermedio antes de leer el archivo
            BufferedReader bfreader = new BufferedReader(fread);
            // Lectura del fichero
            String linea;
            String[] campo;
            linea = bfreader.readLine();
            while (linea != null) {
                campo = linea.split("%");
                if (user.equals(campo[1]) && contra.equals(campo[2])) {
                    band = true;
                }
                linea = bfreader.readLine();
            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        return band;
    }

    static public boolean logUp(Usuario user) {
        boolean band = false;
        boolean aux = false;
        try {
            if (!usuario.exists()) {
                usuario.createNewFile();
            }

            FileReader fread = new FileReader(usuario);
            BufferedReader bfreader = new BufferedReader(fread);
            String linea;
            String[] campo;
            linea = bfreader.readLine();
            //Revisar los usuarios registrados
            while (linea != null) {
                campo = linea.split("%");
                //Condicion para que no existan usuarios con mismo id o email
                if (user.equals(campo[0]) && user.equals(campo[1])) {
                    aux = true;
                    break;
                }
                linea = bfreader.readLine();
            }

            if (!aux) {
                //crea el flujo para escribir en el archivo
                FileWriter fwriter = new FileWriter(usuario, true);
                //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
                BufferedWriter bfwriter = new BufferedWriter(fwriter);
                //escribe los datos en el archivo
                bfwriter.write(user.getId() + "%");
                bfwriter.write(user.getEmail() + "%");
                bfwriter.write(user.getClave() + "%");
                bfwriter.write(user.getApellidos() +"%");
                bfwriter.write(user.getNombres() + "%");
                bfwriter.write(user.getTipo()+"%");
                bfwriter.newLine();
                //cierra el buffer intermedio
                bfwriter.close();
                band = true;
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        return band;
    }

    static public boolean recupera(String correo, String contra) {
        boolean band = false;
        try {
            FileReader freader = new FileReader(usuario);
            BufferedReader breader = new BufferedReader(freader);
            String linea;
            ArrayList<String> recupera = new ArrayList<>();
            String[] campo;
            linea = breader.readLine();
            while (linea != null) {
                campo = linea.split("%");
                if (correo.equals(campo[1])) {
                    campo[2] = contra;
                    band = true;
                }
                recupera.add(campo[0] + "%" + campo[1] + "%" + campo[2] + "%" + campo[3] + "%" + campo[4] + "%" + campo[5]+"%");
                linea = breader.readLine();

            }
            FileWriter fwriter = new FileWriter(usuario);
            BufferedWriter bwriter = new BufferedWriter(fwriter);
            for (int i = 0; i < recupera.size(); i++) {
                bwriter.write(recupera.get(i));
                bwriter.newLine();
            }
            //cierra el buffer intermedio
            bwriter.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);

        }

        return band;
    }
}
