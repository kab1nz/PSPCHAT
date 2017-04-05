/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor.Cliente;

import java.io.BufferedReader;

/**
 *
 * @author usuario-16
 */
public class HiloCliente implements Runnable{
    BufferedReader bf ;
    String cad="";
    public HiloCliente(BufferedReader bf){
        this.bf=bf;
    }
    @Override
    public void run() {
        try{
            while(true){
                cad=bf.readLine().trim();
                System.out.println(cad);
            }
        }catch(Exception e){}
    }
    
}
