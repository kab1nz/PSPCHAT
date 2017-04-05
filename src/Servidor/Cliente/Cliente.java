package Servidor.Cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author usuario-16
 */
public class Cliente {
    public static void main(String[]args){
    InetAddress ip=null;
    Scanner teclado = new Scanner(System.in);
    String cad="";
    HiloCliente hiloCliente;
    try{
        ip=InetAddress.getByName("localhost");
        
    
    }catch(Exception e){}
    try(
            Socket conex = new Socket(ip, 15000);
            PrintWriter salida = new PrintWriter(conex.getOutputStream(),true);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(conex.getInputStream()));
            )
    {
            hiloCliente=new HiloCliente(entrada);
            Thread hilo= new Thread(hiloCliente);
            hilo.start();
            while(true){
                cad=teclado.nextLine();
                 if(cad.trim().equalsIgnoreCase("exit")){
                     System.out.println("SALIENDO A PETICIÓN DEL USUARIO");
                     salida.println("SALIENDO");
                     salida.println(cad);
                     System.exit(0);
                 }

                salida.println(cad);
            }
    }catch(Exception es){}
    }
}
