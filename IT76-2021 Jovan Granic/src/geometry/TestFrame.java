package geometry;

import javax.swing.JFrame;
/*
 * Swing API klase obezbedjuju kreiranje grafickog korisnickog interfejsa aplikacije
 * JFrame klasa obezbedjuje osnovne funkcionalnosti prozora
 * JPanel je kontejner koji predstavlja praznu povrsinu na koju mogu da se dodaju 
 * komponente (JLabel, JTextField, JButton); JPanel moze da posluzi za crtanje grafike
 */

public class TestFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		DrawingPanel panel = new DrawingPanel();
		/*
		Punjenje liste iz klase DrawingPanel prilikom pokretanja programa:
		1. koriscenjem set metode 
		2. koriscenjem get metode dobija se lista u koju se ubaciju elementi
		3. u pozivu konstruktora
		4. pozivom metode kao sto je addToShapesList
		//1. 
		ArrayList<Shape> lista = new ArrayList<Shape>();
		lista.add(new Point(30,30));
		panel.setShapesList(lista);
		
		//2.
		ArrayList<Shape> list = panel.getShapesList();
		list.add(new Point(20,20));
		
		//4.
		panel.addToShapesList(new Point(10,10));*/
		
		frame.setBounds(100, 100, 500, 500);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}

}
