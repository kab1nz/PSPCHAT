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
import java.util.Scanner;

/**
 *
 * @author usuario-16
 */
public class HiloHablar implements Runnable{
    Scanner escuchado = new Scanner(System.in);
    String cad="";
    ArrayList<Usuarios>ausuarios;
    Usuarios usuario;
    
    Usuarios usu;
    ArrayList<Usuarios>listUsuarios = new ArrayList<>();
    public HiloHablar(ArrayList<Usuarios>ausuarios){
        this.ausuarios=ausuarios;
    }
    @Override
    public void run() {
        
        
        
        while(true){
              
              cad=escuchado.nextLine();
             
            for(Usuarios usu: ausuarios){
                usu.getPw().println("Servidor > "+cad);
                
        }
            
            
        }
    }
    
}
