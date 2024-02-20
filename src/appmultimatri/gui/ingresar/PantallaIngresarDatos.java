package appmultimatri.gui.ingresar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import appmultimatri.gui.resultado.PantallaMostrarResultado;
import appmultimatri.utilidades.src.CargaImagen;
import appmultimatri.utilidades.src.Formato;

public class PantallaIngresarDatos {

	private JFrame ventana;
	private JPanel panelFondo;
	private JLabel imagenFondo, tituloLabel, tituloLabel2, guardarLabel, iconoLabel, backLabel;
	private JLabel matrizALabel, matrizBLabel, matrizColumnaALabel, matrizColumnaBLabel, matrizFilaALabel,
			matrizFilaBLabel;
	private JTextField matrizColumnaATextField, matrizColumnaBTextField, matrizFilaATextField, matrizFilaBTextField;
	private Formato formato;
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;

	public PantallaIngresarDatos(JFrame ventana) {
		this.panelFondo = new JPanel();
		this.ventana = ventana;
		formato = new Formato();
		initVentana();
		initComponentes();
		ventana.getContentPane().revalidate();
		ventana.getContentPane().repaint();
	}

	private void initVentana() {
		ventana.setSize(WIDTH, HEIGHT);
		ventana.setLocationRelativeTo(null);
		panelFondo.setLayout(null);
		ventana.getContentPane().add(panelFondo);
	}

	private void initComponentes() {
		labelTitulo();
		matrizColumnaA();
		matrizColumnaB();
		matrizFilaA();
		matrizFilaB();
		botonCalcular();
		logoImage();
		botonBack();
		imagenFondo();
	}

	private void labelTitulo() {
		tituloLabel = new JLabel("<html><body style='text-align: center'>MULTIPLICACIÓN DE MATRICES</html>");
		tituloLabel2 = new JLabel("<html><body style='text-align: center'>Programación paralela y secuencial</html>");
		Font font = new Font("Georgia", Font.BOLD, 25);
		Font font2 = new Font("Georgia", Font.PLAIN, 20);

		tituloLabel.setForeground(Color.BLACK);
		tituloLabel2.setForeground(Color.BLACK);

		tituloLabel.setFont(font);
		tituloLabel2.setFont(font2);

		tituloLabel.setBounds((int) (WIDTH * 0.3), (int) (HEIGHT * 0.02), (int) (WIDTH * 0.5), (int) (HEIGHT * 0.15));
		tituloLabel2.setBounds((int) (WIDTH * 0.345), (int) (HEIGHT * 0.08), (int) (WIDTH * 0.5),
				(int) (HEIGHT * 0.15));

		JLabel lineaHorizontal = new JLabel();
		lineaHorizontal.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
		lineaHorizontal.setBounds(60, 100, 300, 1);
		panelFondo.add(lineaHorizontal);

		JLabel lineaHorizontal2 = new JLabel();
		lineaHorizontal2.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
		lineaHorizontal2.setBounds(850, 100, 240, 1);
		panelFondo.add(lineaHorizontal2);

		panelFondo.add(tituloLabel);
		panelFondo.add(tituloLabel2);
	}

	private void matrizColumnaA() {
		matrizALabel = new JLabel("MATRIZ  A");
		matrizALabel.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.22), (int) (WIDTH * 0.35),
				(int) (HEIGHT * 0.05));
		formato.formato(matrizALabel, 0, 28f);
		panelFondo.add(matrizALabel);

		matrizColumnaALabel = new JLabel("Numero de Columnas :");
		matrizColumnaALabel.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.32), (int) (WIDTH * 0.35),
				(int) (HEIGHT * 0.05));
		formato.formato(matrizColumnaALabel, 0, 28f);
		panelFondo.add(matrizColumnaALabel);

		matrizColumnaATextField = new JTextField();
		matrizColumnaATextField.setBounds((int) (WIDTH * 0.35), (int) (HEIGHT * 0.32), (int) (WIDTH * 0.23),
				(int) (HEIGHT * 0.05));
		formato.formato(matrizColumnaATextField, 0, 28f);
		matrizColumnaATextField.setForeground(Color.black);
		matrizColumnaATextField.setOpaque(true);
		panelFondo.add(matrizColumnaATextField);
	}

	private void matrizFilaA() {
		matrizFilaALabel = new JLabel("Numero de Filas :");
		matrizFilaALabel.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.42), (int) (WIDTH * 0.35),
				(int) (HEIGHT * 0.05));
		formato.formato(matrizFilaALabel, 0, 28f);
		panelFondo.add(matrizFilaALabel);

		matrizFilaATextField = new JTextField();
		matrizFilaATextField.setBounds((int) (WIDTH * 0.35), (int) (HEIGHT * 0.42), (int) (WIDTH * 0.23),
				(int) (HEIGHT * 0.05));
		formato.formato(matrizFilaATextField, 0, 28f);
		matrizFilaATextField.setForeground(Color.black);
		matrizFilaATextField.setOpaque(true);
		panelFondo.add(matrizFilaATextField);
	}
	
	private void matrizColumnaB() {
		matrizBLabel = new JLabel("MATRIZ  B");
		matrizBLabel.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.52), (int) (WIDTH * 0.35),
				(int) (HEIGHT * 0.05));
		formato.formato(matrizBLabel, 0, 28f);
		panelFondo.add(matrizBLabel);

		matrizColumnaBLabel = new JLabel("Numero de Columnas :");
		matrizColumnaBLabel.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.62), (int) (WIDTH * 0.35),
				(int) (HEIGHT * 0.05));
		formato.formato(matrizColumnaBLabel, 0, 28f);
		panelFondo.add(matrizColumnaBLabel);

		matrizColumnaBTextField = new JTextField();
		matrizColumnaBTextField.setBounds((int) (WIDTH * 0.35), (int) (HEIGHT * 0.62), (int) (WIDTH * 0.23),
				(int) (HEIGHT * 0.05));
		formato.formato(matrizColumnaBTextField, 0, 28f);
		matrizColumnaBTextField.setForeground(Color.black);
		matrizColumnaBTextField.setOpaque(true);
		panelFondo.add(matrizColumnaBTextField);
	}

	private void matrizFilaB() {
		matrizFilaBLabel = new JLabel("Numero de Filas :");
		matrizFilaBLabel.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.72), (int) (WIDTH * 0.35),
				(int) (HEIGHT * 0.075));
		formato.formato(matrizFilaBLabel, 0, 26f);
		panelFondo.add(matrizFilaBLabel);

		matrizFilaBTextField = new JTextField();
		matrizFilaBTextField.setBounds((int) (WIDTH * 0.35), (int) (HEIGHT * 0.72), (int) (WIDTH * 0.23),
				(int) (HEIGHT * 0.05));
		formato.formato(matrizFilaBTextField, 0, 28f);
		matrizFilaBTextField.setForeground(Color.black);
		matrizFilaBTextField.setOpaque(true);
		panelFondo.add(matrizFilaBTextField);
	}

	private void botonCalcular() {
		guardarLabel = new JLabel();
		guardarLabel.setBounds((int) (WIDTH * 0.66), (int) (HEIGHT * 0.83), (int) (WIDTH * 0.23),
				(int) (HEIGHT * 0.07));
		CargaImagen.setImagen(guardarLabel, "buttonCalcularMultiplicacionUnclicked.png");
		MouseAdapter accion = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!matrizColumnaBTextField.getText().equals(matrizFilaATextField.getText())) {
					JOptionPane.showMessageDialog(null,
							"El numero de columnas de A debe ser igual al numero de filas de B", "Datos inadmisibles",
							JOptionPane.ERROR_MESSAGE, null);
				}else if(!verificarDatos()) {
					JOptionPane.showMessageDialog(null, "Debe llenar todas las áreas!", "Llenado de datos",
							JOptionPane.ERROR_MESSAGE, null);
				}else{

					int columnaA = Integer.parseInt(matrizColumnaATextField.getText());
					int columnaB = Integer.parseInt(matrizColumnaBTextField.getText());
					int filaA = Integer.parseInt(matrizFilaATextField.getText());
					int filaB = Integer.parseInt(matrizFilaBTextField.getText());
					ventana.remove(panelFondo);
					PantallaMostrarResultado mostrarRe = new PantallaMostrarResultado(ventana, columnaA, columnaB,
							filaA, filaB);
					//System.out.println("Columna A: " + columnaA);
					//System.out.println("Columna B: " + columnaB);
					//System.out.println("Fila A: " + filaA);
					//System.out.println("Fila B: " + filaB);
				}
			}

			public void mouseEntered(MouseEvent e) {
				CargaImagen.setImagen(guardarLabel, "buttonCalcularMultiplicacionClicked.png");
			}

			public void mouseExited(MouseEvent e) {
				CargaImagen.setImagen(guardarLabel, "buttonCalcularMultiplicacionUnclicked.png");
			}
		};
		guardarLabel.addMouseListener(accion);
		panelFondo.add(guardarLabel);
	}

	private boolean verificarDatos() {
		if (matrizColumnaATextField.getText().equals(""))
			return false;
		if (matrizColumnaBTextField.getText().equals(""))
			return false;
		if (matrizFilaATextField.getText().equals(""))
			return false;
		if (matrizFilaBTextField.getText().equals(""))
			return false;
		return true;
	}

	private void logoImage() {
		iconoLabel = new JLabel("LOGO");
		iconoLabel.setBounds((int) (WIDTH * 0.86), (int) (HEIGHT * 0.01), (int) (WIDTH * 0.1025),
				(int) (HEIGHT * 0.19));
		CargaImagen.setImagen(iconoLabel, "logoUNMSM.png");
		panelFondo.add(iconoLabel);
	}

	private void botonBack() {
		backLabel = new JLabel("REGRESAR");
		backLabel.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.85), (int) (WIDTH * 0.12),
				(int) (HEIGHT * 0.06));
		formato.formato(backLabel, 0, 55f);
		CargaImagen.setImagen(backLabel, "buttonRegresarUnclicked.png");
		MouseAdapter accion = new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.remove(panelFondo);
				int option = JOptionPane.showConfirmDialog(ventana, "¿Estás seguro de que quieres salir?",
						"Confirmar salida", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					System.out.println("Cerrando programa");
					System.exit(0);
				}
			}

			public void mouseEntered(MouseEvent e) {
				CargaImagen.setImagen(backLabel, "buttonRegresar.png");
			}

			public void mouseExited(MouseEvent e) {
				CargaImagen.setImagen(backLabel, "buttonRegresarUnclicked.png");
			}
		};
		backLabel.addMouseListener(accion);
		panelFondo.add(backLabel);
	}

	private void imagenFondo() {
		imagenFondo = new JLabel();
		imagenFondo.setBounds(0, 0, WIDTH, HEIGHT);
		CargaImagen.setImagen(imagenFondo, "fondo.png");
		panelFondo.add(imagenFondo);
	}

}