package server;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;

public class VentanaPrincipal extends JFrame {

	private JDesktopPane jdpDesktop;
	private HiloEscuchador escuchador;
	private HashMap<Long, VentanaCliente> ventanasInternas;
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		super("Servidor TPV");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		jdpDesktop = new JDesktopPane();
		VentanaCliente cliente = new VentanaCliente();
		cliente.setLocation(50, 26);
		cliente.setVisible(true);
		jdpDesktop.add(cliente);
		setContentPane(jdpDesktop);
		jdpDesktop.putClientProperty("JDesktopPane.dragMode", "outline");
		ventanasInternas = new HashMap<Long, VentanaCliente>();
		escuchador = new HiloEscuchador(this);
		escuchador.start();
	}
	
	public void añadirVentana(long id){
		VentanaCliente cliente = new VentanaCliente();
		ventanasInternas.put(id, cliente);
		cliente.setLocation(50, 26);
		cliente.setVisible(true);
		jdpDesktop.add(cliente);
	}
	
	public void removerVentana(long id){
		VentanaCliente cliente = ventanasInternas.get(id);
		jdpDesktop.remove(cliente);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
