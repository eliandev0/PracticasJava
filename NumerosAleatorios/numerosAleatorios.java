package pruebas;

import javax.swing.JOptionPane;

public class numerosAleatorios {

	public static void main(String[] args) {
		
		int elementos = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero mayor o igual a uno."));
		int num_aleat[] = new int[elementos];
		System.out.println("Numeros generados aleatoriamente:");
		for (int i = 0; i < num_aleat.length;i++) {
			num_aleat[i] = (int)( Math.random()* elementos * 100);
		}
		for (int elem : num_aleat) {
			System.out.println(elem);
		}
	}
}