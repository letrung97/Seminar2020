package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class dieuchinh extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public dieuchinh(String arg) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(arg);
		lblNewLabel.setBackground(new Color(245, 222, 179));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setLabelFor(this);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 430, 43);
		add(lblNewLabel);
	}
}
