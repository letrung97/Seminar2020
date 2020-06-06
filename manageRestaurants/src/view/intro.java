package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class intro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String arg="welcome";

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public intro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		setTitle("Chào mừng tới app quản lý nhà hàng");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setForeground(Color.WHITE);
		contentPane.add(panel, BorderLayout.WEST);
		
		JButton btnListrestaurants = new JButton("list restaurants");
		btnListrestaurants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arg="list_restaurants";
				list_restaurants c = new list_restaurants();
				c.setVisible(true);
			}
		});
		btnListrestaurants.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnListrestaurants.setForeground(new Color(0, 0, 0));
		btnListrestaurants.setBackground(new Color(222, 184, 135));
		
		JButton btnListdetails = new JButton("list details");
		btnListdetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arg="list_details";
				detail_restaurants c = new detail_restaurants();
				c.setVisible(true);
			}
		});
		btnListdetails.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnListdetails.setForeground(new Color(0, 0, 0));
		btnListdetails.setBackground(new Color(222, 184, 135));
		
		JButton btnListorder = new JButton("list orders");
		btnListorder.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnListorder.setForeground(new Color(0, 0, 0));
		btnListorder.setBackground(new Color(222, 184, 135));
		btnListorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arg="list_orders";
				place_order c = new place_order();
				c.setVisible(true);
			}
		});
		
		JButton btnBranchinfo = new JButton("branch info");
		btnBranchinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arg="branch_info";
				branch_details c = new branch_details();
				c.setVisible(true);
			}
		});
		btnBranchinfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBranchinfo.setForeground(new Color(0, 0, 0));
		btnBranchinfo.setBackground(new Color(222, 184, 135));
		
		JButton btnEmployeeinfo = new JButton("employee info");
		btnEmployeeinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arg="employee_info";
				employee_details c = new employee_details();
				c.setVisible(true);
			}
		});
		btnEmployeeinfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEmployeeinfo.setForeground(new Color(0, 0, 0));
		btnEmployeeinfo.setBackground(new Color(222, 184, 135));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(106, 90, 205));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnEmployeeinfo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(btnBranchinfo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(btnListorder, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(btnListdetails, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
						.addComponent(btnListrestaurants, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
					.addContainerGap())
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListrestaurants, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListdetails, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnListorder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBranchinfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEmployeeinfo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setIcon(new ImageIcon(intro.class.getResource("/com/sun/java/swing/plaf/motif/icons/DesktopIcon.gif")));
		lblMenu.setBounds(10, 0, 139, 69);
		panel_1.add(lblMenu);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new dieuchinh(arg);
		panel_2.setBackground(new Color(240, 255, 240));
		contentPane.add(panel_2, BorderLayout.CENTER);
		
	}
}
