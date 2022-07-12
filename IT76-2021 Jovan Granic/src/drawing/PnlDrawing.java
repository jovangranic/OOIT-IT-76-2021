package drawing;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Point;
import geometry.Shape;
import java.awt.Color;

public class PnlDrawing extends JPanel {

	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	/**
	 * Create the panel.
	 */
	public PnlDrawing() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();

		while (it.hasNext()) {

			it.next().draw(g);
		}
	}

	public void select(Point p) {
		for (int i = shapes.size() - 1; i >= 0; i--) {
			if (shapes.get(i).contains(p.getX(), p.getY())) {
				shapes.get(i).setSelected(true);
				repaint();
				return;
			}
		}
	}

	public void deselectAll() {
		for (int i = shapes.size() - 1; i >= 0; i--) {
			shapes.get(i).setSelected(false);
		}
		repaint();
	}

	public int getSelected() {
		for (int i = shapes.size() - 1; i >= 0; i--) {
			if (shapes.get(i).isSelected()) {
				return i;
			}
		}
		return -1;
	}

	public ArrayList<Shape> getShapes() {
		return this.shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public void addShape(Shape sh) {
		shapes.add(sh);
		repaint();
	}

	public Shape getShape(int index) {
		return shapes.get(index);
	}

	public boolean isEmpty() {
		return shapes.isEmpty();
	}

	public void remove(int index) {
		shapes.remove(index);
		repaint();
	}
}
