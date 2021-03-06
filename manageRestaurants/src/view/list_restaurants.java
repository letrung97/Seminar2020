package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import model.danh_sach_nha_hang;
import dao.list_restaurant_db;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class list_restaurants extends JFrame {
	danh_sach_nha_hang user = new danh_sach_nha_hang();
	list_restaurant_db db = new list_restaurant_db();
	ResultSet result = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_3;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					list_restaurants frame = new list_restaurants();
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
	public list_restaurants() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quản lý chuỗi nhà hàng");
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{222, 0};
		gbl_panel.rowHeights = new int[]{17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblMNhHng = new JLabel("M\u00E3 nh\u00E0 h\u00E0ng");
		lblMNhHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblMNhHng = new GridBagConstraints();
		gbc_lblMNhHng.anchor = GridBagConstraints.SOUTH;
		gbc_lblMNhHng.insets = new Insets(0, 0, 5, 0);
		gbc_lblMNhHng.gridx = 0;
		gbc_lblMNhHng.gridy = 1;
		panel.add(lblMNhHng, gbc_lblMNhHng);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setForeground(Color.BLACK);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblTnNhHng = new JLabel("T\u00EAn nh\u00E0 h\u00E0ng");
		lblTnNhHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblTnNhHng = new GridBagConstraints();
		gbc_lblTnNhHng.insets = new Insets(0, 0, 5, 0);
		gbc_lblTnNhHng.gridx = 0;
		gbc_lblTnNhHng.gridy = 3;
		panel.add(lblTnNhHng, gbc_lblTnNhHng);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 4;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblLoiNhHng = new JLabel("Lo\u1EA1i nh\u00E0 h\u00E0ng");
		lblLoiNhHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblLoiNhHng = new GridBagConstraints();
		gbc_lblLoiNhHng.insets = new Insets(0, 0, 5, 0);
		gbc_lblLoiNhHng.gridx = 0;
		gbc_lblLoiNhHng.gridy = 5;
		panel.add(lblLoiNhHng, gbc_lblLoiNhHng);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Đặt trước", "Trực tiếp"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 6;
		panel.add(comboBox, gbc_comboBox);
		
		JLabel lblSChiNhnh = new JLabel("S\u1ED1 chi nh\u00E1nh");
		lblSChiNhnh.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblSChiNhnh = new GridBagConstraints();
		gbc_lblSChiNhnh.insets = new Insets(0, 0, 5, 0);
		gbc_lblSChiNhnh.gridx = 0;
		gbc_lblSChiNhnh.gridy = 7;
		panel.add(lblSChiNhnh, gbc_lblSChiNhnh);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 8;
		panel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_add();
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 11;
		panel.add(btnAdd, gbc_btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_edit();
			}
		});
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit.gridx = 0;
		gbc_btnEdit.gridy = 12;
		panel.add(btnEdit, gbc_btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_delete();
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 13;
		panel.add(btnDelete, gbc_btnDelete);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblThngTinDanh = new JLabel("Th\u00F4ng tin danh s\u00E1ch chu\u1ED7i nh\u00E0 h\u00E0ng");
		panel_2.add(lblThngTinDanh);
		lblThngTinDanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinDanh.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
			}
		));
		contentPane.add(table, BorderLayout.CENTER);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseClicked(java.awt.event.MouseEvent evt) {
	                tableMouseClicked(evt);
	            }

				private void tableMouseClicked(MouseEvent evt) {                    
				       DefaultTableModel model = (DefaultTableModel)table.getModel();

				       int selectedRowIndex = table.getSelectedRow();
				       
				       textField.setText(model.getValueAt(selectedRowIndex, 0).toString());
				       textField_1.setText(model.getValueAt(selectedRowIndex, 1).toString());
				       textField_3.setText(model.getValueAt(selectedRowIndex, 2).toString());
				       if (model.getValueAt(selectedRowIndex, 3).equals("Trực tiếp"))
				    	   comboBox.setSelectedIndex(1);
				       else
				    	   comboBox.setSelectedIndex(0);
				    }
					
	        });
		tb_refresh();
	}
	private void ObjectCreation(){
		user = new danh_sach_nha_hang();
		if (textField.getText().isEmpty())
			user.setMa_nha_hang(0);
		else
			user.setMa_nha_hang(Integer.parseInt(textField.getText()));
		user.setTen_nha_hang(textField_1.getText());
		user.setSo_chi_nhanh(Integer.parseInt(textField_3.getText()));
		if (comboBox.getSelectedIndex()==0){
			user.setLoai_nha_hang(true);
			user.setType("Đặt trước");
		}
		else{
			user.setLoai_nha_hang(false);
			user.setType("Trực tiếp");
		}
	}
	private void tb_refresh(){
		result = db.get();
		table.setModel(DbUtils.resultSetToTableModel(result));
	}
	private void btn_add(){
		ObjectCreation();
		db.insert(user);
		tb_refresh();
	}
	private void btn_edit(){
		ObjectCreation();
		db.update(user);
		tb_refresh();
	}
	private void btn_delete(){
		ObjectCreation();
		db.delete(user.getMa_nha_hang());
		tb_refresh();
	}
}
