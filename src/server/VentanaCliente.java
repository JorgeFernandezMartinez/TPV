package server;

import javax.swing.JInternalFrame;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class VentanaCliente extends JInternalFrame {
	static int openFrameCount = 0;
	static final int xPosition = 5, yPosition = 5;
	/**
	 * Create the frame.
	 */
	public VentanaCliente() {
		super("Terminal TPV " + (++openFrameCount), false, // resizable
				false, // closable
				false, // maximizable
				false);// iconifiable
		setSize(300, 300);
		
		// Set the window's location.
		setLocation(xPosition * openFrameCount, yPosition
				* openFrameCount);
		
		JList list = new JList();
		getContentPane().add(list, BorderLayout.CENTER);
		
		JLabel lblTicket = new JLabel("Ticket compra");
		getContentPane().add(lblTicket, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblVenta = new JLabel("Total venta");
		panel.add(lblVenta, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("0,00");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel_2, BorderLayout.CENTER);
	}

}

