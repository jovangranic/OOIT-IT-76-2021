	package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.SystemColor;

public class addDialogStack extends JDialog {
	private JPanel contentPane;
	private JTextField xField = new JTextField();
	private JTextField yField = new JTextField();
	private JTextField radiusField = new JTextField();
	private boolean isOk;
	
	
	public addDialogStack(boolean isRemoving, Circle circle) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 300, 400, 350);
		getContentPane().setLayout(new BorderLayout());
		contentPane = new JPanel(new GridLayout(4, 1));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		setTitle("Circle information:");
		setModal(true);
	
		
		// X coordinate
		JPanel pnlInputX = new JPanel();
		contentPane.add(pnlInputX, BorderLayout.CENTER);
		pnlInputX.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblXLabel = new JLabel("X coordinate");
		pnlInputX.add(lblXLabel);
		
		xField = new JTextField();
		pnlInputX.add(xField);
		xField.setColumns(10);
		
		// Y coordinate
		JPanel pnlInputY = new JPanel();
		contentPane.add(pnlInputY, BorderLayout.CENTER);
		pnlInputY.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblYLabel = new JLabel("Y coordinate");
		pnlInputY.add(lblYLabel);
		
		pnlInputY.add(yField);
		yField.setColumns(10);
		
		// Radius coordinate
		JPanel pnlInputRadius = new JPanel();
		contentPane.add(pnlInputRadius, BorderLayout.CENTER);
		pnlInputRadius.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblRadiusLabel = new JLabel("Radius");
		pnlInputRadius.add(lblRadiusLabel);
		
		pnlInputRadius.add(radiusField);
		radiusField.setColumns(10);
		
		// Submit button
		
		JPanel pnlSubmit = new JPanel();
		pnlSubmit.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		getContentPane().add(pnlSubmit, BorderLayout.SOUTH);
		
		JButton btnSubmitButton = new JButton("Submit");
		btnSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if (xField.getText().trim().isEmpty() ||
							yField.getText().trim().isEmpty() ||
							radiusField.getText().trim().isEmpty()) {
						isOk = false;
						getToolkit().beep();
						setVisible(true);
						JOptionPane.showMessageDialog(null, "You need to enter all values!");
					} else if (Integer.parseInt(xField.getText().toString()) <= 0 || 
							Integer.parseInt(yField.getText().toString()) <= 0 ||
							Integer.parseInt(radiusField.getText().toString()) <= 0) {
						JOptionPane.showMessageDialog(null, "You need to enter values greater than 0!");
					}
					else {
						System.out.println("ok");
						isOk = true;
						dispose();
					}
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "You need to enter numbers!");
				}
			}
		});
		pnlSubmit.add(btnSubmitButton);
		
		if (isRemoving == true) {
			getxField().setText(String.valueOf(circle.getCenter().getX()));
			getyField().setText(String.valueOf(circle.getCenter().getY()));
			getRadiusField().setText(String.valueOf(circle.getRadius()));
			getxField().setEditable(false);
			getyField().setEditable(false);
			getRadiusField().setEditable(false);
		}
	}
	
		
	public addDialogStack() {
		setBackground(Color.LIGHT_GRAY);
		getContentPane().setBackground(Color.WHITE);
	}



	public JTextField getxField() {
		return xField;
	}

	public void setxField(JTextField xField) {
		this.xField = xField;
	}

	public JTextField getyField() {
		return yField;
	}

	public void setyField(JTextField yField) {
		this.yField = yField;
	}

	public JTextField getRadiusField() {
		return radiusField;
	}

	public void setRadiusField(JTextField radiusField) {
		this.radiusField = radiusField;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

}
