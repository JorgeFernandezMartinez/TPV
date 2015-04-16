package client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import comunicacion.InformacionTPV;

public class Cliente {
	private static final int PUERTO = 2000;
	private long ID = System.currentTimeMillis();
	private Socket cliente;
	
	public Cliente() {
		super();
		try {
			cliente = new Socket("127.0.0.1", PUERTO);
			System.out.println("Conexion establecida");
			InformacionTPV informacionTPV = new InformacionTPV(ID, true);
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
            oos.writeObject(informacionTPV);
            
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void cerrar(){
		Scanner entrada = new Scanner(System.in);
		entrada.nextLine();
		InformacionTPV informacionTPV = new InformacionTPV(ID, false);
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(cliente.getOutputStream());
			 oos.writeObject(informacionTPV);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entrada.close();
		System.out.println("Cliente cerrado");
       
	}
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.cerrar();
	}
}
