package appmultimatri.utilidades.src;

import java.awt.Color;
import javax.swing.*;


public class Formato {

	FuentePersonalizada fuente;

	public Formato() {
		fuente = new FuentePersonalizada();
	}

	public void formato(JLabel l, int estilo, float tamanio) {
		l.setFont(fuente.MyFont(estilo, tamanio));
		l.setOpaque(false);
		l.setBorder(BorderFactory.createEmptyBorder());
		l.setForeground(new Color(255, 255, 255));
	}

	public void formato(JTextField t, int estilo, float tamanio) {
		t.setFont(fuente.MyFont(estilo, tamanio));
		t.setOpaque(false);
		t.setBorder(BorderFactory.createEmptyBorder());
		t.setForeground(new Color(255, 255, 255));
	}

	public void formato(JComboBox<String> b, int estilo, float tamanio) {
		b.setFont(fuente.MyFont(estilo, tamanio));
		b.setOpaque(false);
		b.setBorder(BorderFactory.createEmptyBorder());
		b.setForeground(new Color(0, 0, 0));
	}

	public void formato(JTextArea ta) {
		ta.setFont(fuente.MyFont(0, 30f));
		ta.setOpaque(true);
		ta.setEditable(false);
		ta.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
		ta.setForeground(new Color(0, 0, 0));
		ta.setBackground(new Color(255, 255, 255));
	}

	public void formato(Boton b, int estilo, float tamanio, int radius, int grosor) {
		b.setFont(fuente.MyFont(estilo, tamanio));
		b.setRadius(radius);
		b.setColor(new Color(204, 204, 204));
		b.setColorOver(new Color(255, 255, 255));
		b.setColorClick(new Color(204, 204, 204));
		b.setBorderColor(new Color(204, 204, 204));
		b.setGrosor(grosor);
	}
}