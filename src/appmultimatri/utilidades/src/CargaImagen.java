package appmultimatri.utilidades.src;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class CargaImagen {

	private static boolean sistema() {
		String sSistemaOperativo = System.getProperty("os.name");
		return sSistemaOperativo.equals("Windows 11");
	}

	public static void setImagen(JLabel auxLabel, String cad) {
		String dir = System.getProperty("user.dir").replace("\\", "\\\\") + "\\\\Imagenes\\\\";
		if (!sistema())
			dir = dir.replace("\\\\", "////");
		ImageIcon a = new ImageIcon(dir + cad);
		auxLabel.setIcon(new ImageIcon(
				a.getImage().getScaledInstance(auxLabel.getWidth(), auxLabel.getHeight(), Image.SCALE_SMOOTH)));
	}

	public static void setLogo(JLabel auxLabel, ImageIcon img, int n) {
		ImageIcon a = img;
		auxLabel.setIcon(new ImageIcon(
				a.getImage().getScaledInstance(auxLabel.getWidth(), auxLabel.getHeight(), Image.SCALE_SMOOTH)));
	}
	
}
