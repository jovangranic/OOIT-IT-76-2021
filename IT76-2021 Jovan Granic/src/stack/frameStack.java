package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import geometry.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import stack.addDialogStack;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


public class frameStack extends JFrame{
	private JPanel contentPane;
	private DefaultListModel<Circle> dlm;
	
//	private DefaultListModel<Circle> dlm = new DefaultListModel<Circle>();
//	Circle circle = new Circle(new Point(1, 1), 2);
//	
	private JList listCircle;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameStack frame = new frameStack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public frameStack() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Granic Jovan IT76-2021");
		
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// List of circles - show action
		dlm = new DefaultListModel<Circle>();
//		Circle circle = new Circle(new Point(1, 1), 2);
		listCircle = new JList();
		
		// Additional panel for buttons
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		// Button for adding
		JButton btnAddCircleButton = new JButton("Add");
		btnAddCircleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDialogStack dlg = new addDialogStack(false, null);
				setTitle("Adding circle");
				dlg.setVisible(true);
				System.out.println(dlg.isOk());
				if(dlg.isOk())
				{
					
					String x = dlg.getxField().getText().toString();
					System.out.println("gg");
					int intX = Integer.parseInt(x);
					String y = dlg.getyField().getText().toString();
					int intY = Integer.parseInt(y);
					String radius = dlg.getRadiusField().getText().toString();
					int intRadius = Integer.parseInt(radius);
					
					Circle circle = new Circle(new Point(intX, intY), intRadius);
					dlm.add(0, circle);
				}
			}
		});
		pnlSouth.add(btnAddCircleButton);
		
		// Button for removing
		JButton btnRemoveCircleButton = new JButton("Remove");
		btnRemoveCircleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = listCircle.getFirstVisibleIndex();
					try
					{
						addDialogStack dlg = new addDialogStack(true, dlm.elementAt(i));	
						dlg.setTitle("Removing circle");
						dlg.setVisible(true);

						if(dlg.isOk())
						{
							int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure?",
									"Circle remove", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if(confirmation==0)
								dlm.remove(i);
						}
					}
					catch (ArrayIndexOutOfBoundsException ex)
					{
						JOptionPane.showMessageDialog(null, "The list is empty!");
					}
								
			}
		});
		pnlSouth.add(btnRemoveCircleButton);
		
		JScrollPane scrlPaneRect = new JScrollPane();
		contentPane.add(scrlPaneRect, BorderLayout.CENTER);
		
		//dlm.addElement(circle);
		
		scrlPaneRect.setViewportView(listCircle);
		listCircle.setModel(dlm);
	}

	public DefaultListModel<Circle> getDlm() {
		return dlm;
	}

	public void setDlm(DefaultListModel<Circle> dlm) {
		this.dlm = dlm;
	}
	
	

}
