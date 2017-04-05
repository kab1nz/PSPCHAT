/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import java.net.ServerSocket;
import java.util.ArrayList;

/**
 *
 * @author usuario-16
 */
public class Servidor {
    public static void main(String[]args){
        int puerto=15000;
        System.out.println("------------SERVIDOR INICIADO----------");
        ArrayList<Usuarios> ausuarios= new ArrayList<>();
        int cli=1;
        try{
            ServerSocket sv = new ServerSocket(puerto);
            while(true){
                HiloServidor hs = new HiloServidor(sv.accept(), cli, ausuarios);
                Thread hilo = new Thread(hs);
                hilo.start();
                cli++;   
            }
            
        }catch(Exception e){}
        try{
            HiloHablar hh = new HiloHablar(ausuarios);
            Thread ha = new Thread(hh);
            ha.start();
            }catch(Exception a){}
    }
}
