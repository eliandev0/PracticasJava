package pruebas;

import javax.swing.JOptionPane;

public class numerosAleatorios {

	public static void main(String[] args) {
		
		int elementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero mayor o igual a uno."));
		int num_aleat[] = new int[elementos];
		for (int i = 0; i < num_aleat.length;i++) {
			num_aleat[i] = (int) Math.random()* 100;
		}
		for (int elem : num_aleat) {
			System.out.println(elem);
		}
	}
}