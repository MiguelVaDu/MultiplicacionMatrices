package appmultimatri.gui;

import java.awt.event.*;

import javax.swing.*;

import appmultimatri.gui.ingresar.PantallaIngresarDatos;
import appmultimatri.utilidades.src.CargaImagen;


public class PantallaInicial {
	private JFrame ventana;
	private JPanel panelFondo;
	private JLabel imagenFondo;
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;

	// la función del java.awt.Toolkit.getDefaultToolKit().getScreenSize() es
	// extraer el ancho y largo de la pantalla que se encuentra ejecutando el código

	public PantallaInicial() {
		ventana = new JFrame();
		configVentana();
		iniciarComponentes();
		System.out.println("WIDTH: " + WIDTH + " HEIGHT: " + HEIGHT);
	}

	private void configVentana() {
		ventana.setSize(WIDTH, HEIGHT);
		ventana.setTitle("MULTIPLICACION DE MATRICES");
		ventana.setLocationRelativeTo(null); // Aparece al medio la ventana
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		confirmacionCerrar();
		ventana.setVisible(true);
	}

	private void iniciarComponentes() {
		iniciarFondo();
		pintarFondo();
		ventana.getContentPane().repaint();
		ventana.getContentPane().revalidate();
	}

	private void iniciarFondo() {
		panelFondo = new JPanel();
		panelFondo.setLayout(null);
		ventana.getContentPane().add(panelFondo);
	}

	private void pintarFondo() {
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, WIDTH, HEIGHT);
		CargaImagen.setImagen(imagenFondo, "fondo_temporal.png");
		MouseAdapter accion = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.remove(panelFondo);
				PantallaIngresarDatos ingreso = new PantallaIngresarDatos(ventana);
			}
		};
		imagenFondo.addMouseListener(accion);
		panelFondo.add(imagenFondo);
	}

	private void confirmacionCerrar() {
		ventana.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent windowEvent) {
				int option = JOptionPane.showConfirmDialog(ventana, "¿Estás seguro de que quieres salir?",
						"Confirmar salida", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					System.out.println("Cerrando programa");
					System.exit(0);
				}
			}
		});
	}
}
