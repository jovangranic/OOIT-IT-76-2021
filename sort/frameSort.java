package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;
import geometry.Rectangle;
import stack.addDialogStack;
import stack.frameStack;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class frameSort extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();
	JList listCircle;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameSort frame = new frameSort();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		//new frame
	public frameSort() {
		setTitle("IT76-2021-Jovan-Granic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		list.setModel(dlm);
		
		final JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnAddCircle = new JButton("Add");
		btnAddCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDialogStack dlg = new addDialogStack(false, null);
				setTitle("Adding circle");
				dlg.setVisible(true);
				
				if(dlg.isOk())
				{
					String x = dlg.getxField().getText().toString();
					int intX = Integer.parseInt(x);
					String y = dlg.getyField().getText().toString();
					int intY = Integer.parseInt(y);
					String radius = dlg.getRadiusField().getText().toString();
					int intRadius = Integer.parseInt(radius);
					
					Circle circle = new Circle(new Point(intX, intY), intRadius); //string->int
					dlm.addElement(circle);
				}
			}
		});
		pnlSouth.add(btnAddCircle);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!dlm.isEmpty())     //petlja koja proverava da li je niz prazan i sortira krugove u niz po povrsini
				{
					Circle[] CircleArray = new Circle[dlm.getSize()];
					for (int i = 0; i < CircleArray.length; i++)
						CircleArray[i] = dlm.getElementAt(i); 
					dlm.clear();  //cisti elemente iz liste kako bi bilo preglednije posle sortiranja
					Arrays.sort(CircleArray);  
					for (int i = 0; i < CircleArray.length; i++)
						dlm.addElement(CircleArray[i]);
					JOptionPane.showMessageDialog(pnlSouth, "Circles have been sorted.", "Sort:", JOptionPane.INFORMATION_MESSAGE);
				} else
					JOptionPane.showMessageDialog(pnlSouth, "The list is empty, input a circle and try again.", "An error has occured.", JOptionPane.ERROR_MESSAGE);
				
			}
		});
		pnlSouth.add(btnSort);
		
		JScrollPane scrollPaneCircle = new JScrollPane();
		contentPane.add(scrollPaneCircle, BorderLayout.CENTER);
		
		JList Circlelist = new JList();
		scrollPaneCircle.setViewportView(Circlelist);
		Circlelist.setModel(dlm);
	}

}
