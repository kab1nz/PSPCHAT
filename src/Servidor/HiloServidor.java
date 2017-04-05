/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author usuario-16
 */
public class HiloServidor implements Runnable{
    Socket micon;
    private int id_usu;
    private BufferedReader BR;
    private PrintWriter PW;
    ArrayList<Usuarios> ausuarios = new ArrayList<>();
    Usuarios esteUsuario;
    public HiloServidor(Socket micon,int id_usu,ArrayList<Usuarios>ausuarios){
        this.micon=micon;
        this.id_usu=id_usu;
        this.ausuarios=ausuarios;
    }
    @Override
    public void run() {
        try(
               BufferedReader br = new BufferedReader(new InputStreamReader(micon.getInputStream()));
               PrintWriter pw = new PrintWriter(micon.getOutputStream(),true);
                )
        {
        BR=br;
        PW=pw;
        mostrarBanner();
        generarUsuarios();
        String cad="";
        HiloHablar hiloh = new HiloHablar(ausuarios);
        Thread h = new Thread(hiloh);
        h.start();
        while(true){
                cad=BR.readLine();
                if(cad.equalsIgnoreCase("quit") || cad==null || cad.equalsIgnoreCase("exit")){
                    break;
                }
                  mandarMensaje(cad);

                }

        }catch(Exception e){}
    }
    public void mostrarBanner(){
        System.out.println("#######################");
        System.out.println("HAY CONECTADOS:");
        System.out.println(ausuarios.size() +", Clientes Activos");
        System.out.println("#######################");
        
    }
    public void generarUsuarios(){
        esteUsuario= new Usuarios(id_usu, BR, PW);
        ausuarios.add(esteUsuario);
        System.out.println(esteUsuario.getNombre()+"¡¡¡¡Conectado!!!!");
    }
    public void borrarUsuario(){
        ausuarios.remove(esteUsuario);
        System.out.println(esteUsuario.getNombre()+"¡¡¡¡Borrado!!!!");

    }
    public void mandarMensaje(String mensaje){
        for(Usuarios usu: ausuarios){
            if(!usu.equals(esteUsuario)){
                usu.getPw().println(usu.getNombre()+">"+mensaje);
            }
        }
    }
    
}
