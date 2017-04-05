package Servidor;

import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 *
 * @author usuario-16
 */
public class Usuarios {
    private String nombre;
    private BufferedReader bf;
    private PrintWriter pw;
    private int id_usu;
    public Usuarios(int id_usu,BufferedReader bf,PrintWriter pw){
        this.id_usu=id_usu;
        this.bf=bf;
        this.pw=pw;
        generarNombre();
    }
    public void generarNombre(){
        nombre="Usuario["+id_usu+"]";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BufferedReader getBf() {
        return bf;
    }

    public void setBf(BufferedReader bf) {
        this.bf = bf;
    }

    public PrintWriter getPw() {
        return pw;
    }

    public void setPw(PrintWriter pw) {
        this.pw = pw;
    }

    public int getId_usu() {
        return id_usu;
    }

    
}
