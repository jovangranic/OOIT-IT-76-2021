package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.SystemColor;

public class PaintDrawingApp extends JFrame {

	private JPanel contentPane;
	private Point startPoint = null;

	private Color edgeColor = Color.black;
	private Color fillColor = Color.white;

	private ButtonGroup Shapesbtngroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaintDrawingApp frame = new PaintDrawingApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaintDrawingApp() {
		setTitle("Jovan Granic IT-76/2021");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		final PnlDrawing pnlDrawing = new PnlDrawing();

		pnlDrawing.setBackground(Color.WHITE);
		contentPane.add(pnlDrawing, BorderLayout.CENTER);

		JPanel ShapeButtonPanel = new JPanel();
		ShapeButtonPanel.setBackground(SystemColor.control);
		contentPane.add(ShapeButtonPanel, BorderLayout.NORTH);
		ShapeButtonPanel.setLayout(new GridLayout(0, 5, 0, 0));

		final JToggleButton togglePoint = new JToggleButton("Point");
		togglePoint.setBackground(SystemColor.control);
		ShapeButtonPanel.add(togglePoint);
		Shapesbtngroup.add(togglePoint);

		final JToggleButton toggleLine = new JToggleButton("Line");
		toggleLine.setBackground(SystemColor.control);
		ShapeButtonPanel.add(toggleLine);
		Shapesbtngroup.add(toggleLine);

		final JToggleButton toggleRectangle = new JToggleButton("Rectangle");
		toggleRectangle.setBackground(SystemColor.control);
		ShapeButtonPanel.add(toggleRectangle);
		Shapesbtngroup.add(toggleRectangle);

		final JToggleButton toggleCircle = new JToggleButton("Circle");
		toggleCircle.setBackground(SystemColor.control);
		ShapeButtonPanel.add(toggleCircle);
		Shapesbtngroup.add(toggleCircle);

		final JToggleButton toggleDonut = new JToggleButton("Donut");
		toggleDonut.setBackground(SystemColor.control);
		ShapeButtonPanel.add(toggleDonut);
		Shapesbtngroup.add(toggleDonut);
				
				JPanel ModifyButtonspanel = new JPanel();
				ModifyButtonspanel.setBackground(SystemColor.control);
				contentPane.add(ModifyButtonspanel, BorderLayout.EAST);
						ModifyButtonspanel.setLayout(new GridLayout(3, 1, 0, 0));
				
						final JToggleButton toggleSelect = new JToggleButton("Select");
						toggleSelect.setBackground(SystemColor.control);
						ModifyButtonspanel.add(toggleSelect);
						Shapesbtngroup.add(toggleSelect);
						
								JButton buttonDelete = new JButton("Delete");
								buttonDelete.setBackground(SystemColor.control);
								ModifyButtonspanel.add(buttonDelete);
								
										// Modifying
								
										JButton buttonModify = new JButton("Modify");
										buttonModify.setBackground(SystemColor.control);
										ModifyButtonspanel.add(buttonModify);
										buttonModify.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												int i = pnlDrawing.getSelected();
												if (i == -1) {
													JOptionPane.showMessageDialog(null, "Select an object to modify first!", "Error!", JOptionPane.ERROR_MESSAGE);
													return;
												}

												Shape shape = pnlDrawing.getShape(i);

												if (shape instanceof Point) {
													DlgPoint dlgPoint = new DlgPoint();
													dlgPoint.setPoint((Point) shape);
													dlgPoint.setVisible(true);

													if (dlgPoint.getPoint() != null) {
														((Point) shape).setX(dlgPoint.getPoint().getX());
														((Point) shape).setY(dlgPoint.getPoint().getY());
														shape.moveTo(dlgPoint.getPoint().getX(), dlgPoint.getPoint().getY());							}
												}

												else if (shape instanceof Line) {
													DlgLine dlgLine = new DlgLine();
													dlgLine.setLine(((Line) shape).getStartPoint(), ((Line) shape).getEndPoint());
													dlgLine.setVisible(true);
													Line line = dlgLine.getLine();

													if (line != null) {
														((Line) shape).setStartPoint(line.getStartPoint());
														((Line) shape).setEndPoint(line.getEndPoint());
														shape.setColor(line.getColor());
													}
												}

												else if (shape instanceof Rectangle) {
													DlgRectangle dlgRectangle = new DlgRectangle();
													dlgRectangle.setRectangle((Rectangle) shape);
													dlgRectangle.setVisible(true);
													Rectangle rect = dlgRectangle.getRectangle();

													if (rect != null) {
														((Rectangle) shape).setUpperLeftPoint(rect.getUpperLeftPoint());
														((Rectangle) shape).setWidth(rect.getWidth());
														((Rectangle) shape).setHeight(rect.getHeight());
														shape.setColor(rect.getColor());
														((Rectangle) shape).setFillColor(rect.getFillColor());
													}
												}

												else if (shape instanceof Donut) {
													DlgDonut dlgDonut = new DlgDonut();
													dlgDonut.setDonut((Donut) shape);
													dlgDonut.setVisible(true);
													Donut donut = dlgDonut.getDonut();

													if (donut != null) {
														((Donut) shape).setCenter(donut.getCenter());
														((Donut) shape).setRadius(donut.getRadius());
														((Donut) shape).setInnerRadius(donut.getInnerRadius());
														shape.setColor(donut.getColor());
														((Donut) shape).setFillColor(donut.getFillColor());
													}
												}

												else if (shape instanceof Circle) {
													DlgCircle dlgCircle = new DlgCircle();
													dlgCircle.setCircle((Circle) shape);
													dlgCircle.setVisible(true);
													Circle circle = dlgCircle.getCircle();

													if (circle != null) {
														((Circle) shape).setCenter(circle.getCenter());
														((Circle) shape).setRadius(circle.getRadius());
														//shape.moveTo(dlgCircle.getCircle().getCenter().getX(), dlgCircle.getCircle().getCenter().getY());
														shape.setColor(circle.getColor());
														((Circle) shape).setFillColor(circle.getFillColor());
													}
												}

												pnlDrawing.repaint();
											}
										});
								buttonDelete.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										if (!pnlDrawing.isEmpty()) 
											if (JOptionPane.showConfirmDialog(null, "Do you really want to delete selected object?", "Deleting selected object",
													JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
												pnlDrawing.remove(pnlDrawing.getSelected());
											}
											else {
												int i = pnlDrawing.getSelected();
												if (i>1 || i<-1) {
													throw new IndexOutOfBoundsException("Index " + i + " is out of bounds!");
												}
											}
										}
									}
								);

		pnlDrawing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Point clickPosition = new Point(e.getX(), e.getY());

				pnlDrawing.deselectAll();

				if (toggleSelect.isSelected()) {
					pnlDrawing.select(clickPosition);
					return;
				}

				if (toggleCircle.isSelected()) {
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.setPoint(clickPosition);
					dlgCircle.setColors(edgeColor, fillColor);
					dlgCircle.setVisible(true);

					if (dlgCircle.getCircle() != null) {
						pnlDrawing.addShape(dlgCircle.getCircle());
					}

					return;
				}

				if (toggleDonut.isSelected()) {
					DlgDonut dlgDonut = new DlgDonut(); // a new instance of the rectangle dialog class
					dlgDonut.setPoint(clickPosition);
					dlgDonut.setColors(edgeColor, fillColor);
					dlgDonut.setVisible(true);

					if (dlgDonut.getDonut() != null) {
						pnlDrawing.addShape(dlgDonut.getDonut());
					}
					return;
				}

				if (toggleRectangle.isSelected()) {
					DlgRectangle dlgRectangle = new DlgRectangle(); //a new instance of the rectangle dialog class
					dlgRectangle.setPoint(clickPosition);
					dlgRectangle.setColors(edgeColor, fillColor);
					dlgRectangle.setVisible(true);

					if (dlgRectangle.getRectangle() != null) {
						pnlDrawing.addShape(dlgRectangle.getRectangle());
					}
					return;
				}

				if (togglePoint.isSelected()) {
					DlgPoint dlgPoint = new DlgPoint(); // a new instance of the rectangle dialog class
					dlgPoint.setPoint(clickPosition);
					dlgPoint.setColor(edgeColor);
					dlgPoint.setVisible(true);

					if (dlgPoint.getPoint() != null) {
						pnlDrawing.addShape(dlgPoint.getPoint());
					}
					return;
				}

				if (toggleLine.isSelected()) {
					if (startPoint != null) {
						DlgLine dlgLine = new DlgLine();
						dlgLine.setLine(startPoint, clickPosition);
						dlgLine.setColor(edgeColor);
						dlgLine.setVisible(true);

						if (dlgLine.getLine() != null) {
							pnlDrawing.addShape(dlgLine.getLine());
						}
						startPoint = null;
						return;
					} else {
						startPoint = clickPosition;
						return;
					}
				}
			}

		});
	}

}
