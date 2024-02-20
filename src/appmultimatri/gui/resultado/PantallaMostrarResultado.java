package appmultimatri.gui.resultado;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import appmultimatri.gui.ingresar.PantallaIngresarDatos;
import appmultimatri.logica.GeneradorMatrices;
import appmultimatri.logica.MultiMatriParalela;
import appmultimatri.logica.MultiMatriSecuencial;
import appmultimatri.utilidades.src.CargaImagen;
import appmultimatri.utilidades.src.Formato;

public class PantallaMostrarResultado {

	private JFrame ventana;
	private JPanel panelFondo;
	private JLabel imagenFondo, tituloLabel, tituloLabel2, iconoLabel, backLabel;
	private JLabel tiempoSecuProm, tiempoParalProm, aceleracion, eficiencia;
	private Formato formato;

	private final int WIDTH = 1280;
	private final int HEIGHT = 720;
	final int NumEvalua = 5;
	final int[][] A, B;
	int[][] resultadoSecuencial, resultadoParalelo;

	public PantallaMostrarResultado(JFrame ventana, int CA, int CB, int FA, int FB) {
		this.panelFondo = new JPanel();
		this.ventana = ventana;
		this.A = GeneradorMatrices.generarMatrizAleatoria(FA, CA);
		this.B = GeneradorMatrices.generarMatrizAleatoria(FB, CB);
		MultiMatriSecuencial mms = new MultiMatriSecuencial(A, B);
		this.resultadoSecuencial = mms.calcularProducto();
		MultiMatriParalela mmp = new MultiMatriParalela(A, B);
		this.resultadoParalelo = mmp.calcularProducto();
		if (!Arrays.deepEquals(resultadoSecuencial, resultadoParalelo)) {
			System.out.println("ERROR: Resultados diferentes");
			throw new Error("ERROR:¡ El resultado secuencial y paralelo no coinciden!");
		}
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
		comparacionResultados();
		logoImage();
		botonBack();
		imagenFondo();
	}

	private void labelTitulo() {
		tituloLabel = new JLabel("<html><body style='text-align: center'>MULTIPLICACIÓN DE MATRICES</html>");
		tituloLabel2 = new JLabel("<html><body style='text-align: center'>Programación paralela y secuencial</html>");
		Font font = new Font("Georgia", Font.BOLD, 25);
		Font font2 = new Font("Georgia", Font.PLAIN, 20);

		tituloLabel.setForeground(Color.WHITE);
		tituloLabel2.setForeground(Color.WHITE);

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

	private void comparacionResultados() {

		System.out.println("Evaluando Implementacion Secuencial...");
		MultiMatriSecuencial mms = new MultiMatriSecuencial(A, B);
		resultadoSecuencial = mms.calcularProducto();
		double tiempoSecuencial = 0;
		for (int i = 0; i < NumEvalua; i++) {
			long inicio = System.currentTimeMillis();
			mms.calcularProducto();
			tiempoSecuencial += System.currentTimeMillis() - inicio;
		}
		tiempoSecuencial /= NumEvalua;

		System.out.println("Evaluando Implementacion Paralela...");
		MultiMatriParalela mmp = new MultiMatriParalela(A, B);
		resultadoParalelo = mmp.calcularProducto();
		double tiempoParalela = 0;
		for (int i = 0; i < NumEvalua; i++) {
			long inicio = System.currentTimeMillis();
			mmp.calcularProducto();
			tiempoParalela += System.currentTimeMillis() - inicio;
		}
		tiempoParalela /= NumEvalua;
		double result01 = tiempoSecuencial / tiempoParalela;
		double result02 = (100 * (tiempoSecuencial / tiempoParalela) / Runtime.getRuntime().availableProcessors());

		DecimalFormat df = new DecimalFormat("###.##");
		// resultados secuenciales y paralelos para comparar
		System.out.format("Tiempo secuencial promedio: %.1f ms\n", tiempoSecuencial);
		System.out.format("Tiempo paralelo promedio: %.1f ms\n", tiempoParalela);
		System.out.format("Aceleracion: %.2f \n", result01);
		System.out.format("Eficiencia: %.2f%%\n", result02);

		tiempoSecuProm = new JLabel("Tiempo secuencial promedio:    " + tiempoSecuencial + " ms");
		tiempoSecuProm.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.30), (int) (WIDTH * 0.6),
				(int) (HEIGHT * 0.05));
		formato.formato(tiempoSecuProm, 0, 32f);
		panelFondo.add(tiempoSecuProm);

		tiempoParalProm = new JLabel("Tiempo paralelo promedio:    " + tiempoParalela + " ms");
		tiempoParalProm.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.40), (int) (WIDTH * 0.6),
				(int) (HEIGHT * 0.05));
		formato.formato(tiempoParalProm, 0, 32f);
		panelFondo.add(tiempoParalProm);

		aceleracion = new JLabel("SpeedUp:    " + df.format(result01));
		aceleracion.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.50), (int) (WIDTH * 0.6), (int) (HEIGHT * 0.05));
		formato.formato(aceleracion, 0, 32f);
		panelFondo.add(aceleracion);

		eficiencia = new JLabel("Eficiencia:    " + df.format(result02) + " %");
		eficiencia.setBounds((int) (WIDTH * 0.05), (int) (HEIGHT * 0.60), (int) (WIDTH * 0.6), (int) (HEIGHT * 0.05));
		formato.formato(eficiencia, 0, 32f);
		panelFondo.add(eficiencia);

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
				int option = JOptionPane.showConfirmDialog(ventana,
						"¿Estás seguro de que quieres regresar a la pantalla anterior?",
						"Confirmar regreso", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					ventana.remove(panelFondo);
					PantallaIngresarDatos ingreso = new PantallaIngresarDatos(ventana);
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