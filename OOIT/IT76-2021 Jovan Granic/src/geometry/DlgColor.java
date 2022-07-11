package geometry;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgColor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRed;
	public JTextField getTxtRed() {
		return txtRed;
	}

	public void setTxtRed(JTextField txtRed) {
		this.txtRed = txtRed;
	}

	public JTextField getTxtGreen() {
		return txtGreen;
	}

	public void setTxtGreen(JTextField txtGreen) {
		this.txtGreen = txtGreen;
	}

	public JTextField getTxtBlue() {
		return txtBlue;
	}

	public void setTxtBlue(JTextField txtBlue) {
		this.txtBlue = txtBlue;
	}

	private JTextField txtGreen;
	private JTextField txtBlue;
	private boolean ok = false;

	public boolean isOk() {
		return ok;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgColor dialog = new DlgColor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgColor() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblRed = new JLabel("Red");
			GridBagConstraints gbc_lblRed = new GridBagConstraints();
			gbc_lblRed.insets = new Insets(0, 0, 5, 5);
			gbc_lblRed.gridx = 0;
			gbc_lblRed.gridy = 0;
			contentPanel.add(lblRed, gbc_lblRed);
		}
		{
			txtRed = new JTextField();
			GridBagConstraints gbc_txtRed = new GridBagConstraints();
			gbc_txtRed.insets = new Insets(0, 0, 5, 0);
			gbc_txtRed.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRed.gridx = 2;
			gbc_txtRed.gridy = 0;
			contentPanel.add(txtRed, gbc_txtRed);
			txtRed.setColumns(10);
		}
		{
			JLabel lblGreen = new JLabel("Green");
			GridBagConstraints gbc_lblGreen = new GridBagConstraints();
			gbc_lblGreen.insets = new Insets(0, 0, 5, 5);
			gbc_lblGreen.gridx = 0;
			gbc_lblGreen.gridy = 1;
			contentPanel.add(lblGreen, gbc_lblGreen);
		}
		{
			txtGreen = new JTextField();
			GridBagConstraints gbc_txtGreen = new GridBagConstraints();
			gbc_txtGreen.insets = new Insets(0, 0, 5, 0);
			gbc_txtGreen.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtGreen.gridx = 2;
			gbc_txtGreen.gridy = 1;
			contentPanel.add(txtGreen, gbc_txtGreen);
			txtGreen.setColumns(10);
		}
		{
			JLabel lblBlue = new JLabel("Blue");
			GridBagConstraints gbc_lblBlue = new GridBagConstraints();
			gbc_lblBlue.insets = new Insets(0, 0, 0, 5);
			gbc_lblBlue.gridx = 0;
			gbc_lblBlue.gridy = 2;
			contentPanel.add(lblBlue, gbc_lblBlue);
		}
		{
			txtBlue = new JTextField();
			GridBagConstraints gbc_txtBlue = new GridBagConstraints();
			gbc_txtBlue.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBlue.gridx = 2;
			gbc_txtBlue.gridy = 2;
			contentPanel.add(txtBlue, gbc_txtBlue);
			txtBlue.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int red = Integer.parseInt(txtRed.getText());
							int green = Integer.parseInt(txtGreen.getText());
							int blue = Integer.parseInt(txtBlue.getText());
							if(red >= 0 && red <= 255 && green >= 0 && green <= 255 && blue >= 0 && blue <= 255) {
								ok = true;
								setVisible(false);
							}else {
								JOptionPane.showMessageDialog(null, "Vrednosti moraju da budu izmedju 0 i 255");
							}
						}catch(NumberFormatException ex) {
							JOptionPane.showMessageDialog(null, "Vrednosti moraju biti numericke");
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
