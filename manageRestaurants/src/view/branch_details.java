package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import model.danh_sach_thong_tin;
import net.proteanit.sql.DbUtils;
import dao.branch_details_db;

public class branch_details extends JFrame {
	danh_sach_thong_tin user = new danh_sach_thong_tin();
	branch_details_db db = new branch_details_db();
	ResultSet result = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox<String> comboBox;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					branch_details frame = new branch_details();
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
	public branch_details() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quản lý chi nhánh");
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{222, 0};
		gbl_panel.rowHeights = new int[]{17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 0);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel.add(lblId, gbc_lblId);
		
		JLabel lblIdNhHng = new JLabel("ID nhà hàng");
		lblIdNhHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblIdNhHng = new GridBagConstraints();
		gbc_lblIdNhHng.insets = new Insets(0, 0, 5, 0);
		gbc_lblIdNhHng.gridx = 0;
		gbc_lblIdNhHng.gridy = 2;
		panel.add(lblIdNhHng, gbc_lblIdNhHng);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 3;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblTnNhHng = new JLabel("Tên quản lý");
		lblTnNhHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblTnNhHng = new GridBagConstraints();
		gbc_lblTnNhHng.insets = new Insets(0, 0, 5, 0);
		gbc_lblTnNhHng.gridx = 0;
		gbc_lblTnNhHng.gridy = 4;
		panel.add(lblTnNhHng, gbc_lblTnNhHng);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 5;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Số nhân công");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 6;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 7;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTngSBn = new JLabel("Tổng số bàn");
		lblTngSBn.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblTngSBn = new GridBagConstraints();
		gbc_lblTngSBn.insets = new Insets(0, 0, 5, 0);
		gbc_lblTngSBn.gridx = 0;
		gbc_lblTngSBn.gridy = 8;
		panel.add(lblTngSBn, gbc_lblTngSBn);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 9;
		panel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Trạng thái", "hoạt động", "đóng cửa"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 10;
		panel.add(comboBox, gbc_comboBox);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add();
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 12;
		panel.add(btnAdd, gbc_btnAdd);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				edit();
			}
		});
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit.gridx = 0;
		gbc_btnEdit.gridy = 13;
		panel.add(btnEdit, gbc_btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delete();
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 14;
		panel.add(btnDelete, gbc_btnDelete);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblThngTinDanh = new JLabel("Thông tin chi nhánh");
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
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 nh\u00E0 h\u00E0ng", "T\u00EAn nh\u00E0 h\u00E0ng", "S\u1ED1 chi nh\u00E1nh", "Lo\u1EA1i nh\u00E0 h\u00E0ng"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(76);
		table.getColumnModel().getColumn(1).setPreferredWidth(108);
		table.getColumnModel().getColumn(2).setPreferredWidth(72);
		table.getColumnModel().getColumn(3).setPreferredWidth(79);
		contentPane.add(table, BorderLayout.CENTER);
		tb_refresh();
	}
	private void ObjectCreation(){
		user = new danh_sach_thong_tin();
		user.setID(Integer.parseInt(textField.getText()));
		user.setQuan_ly(textField_1.getText());
		user.setSo_nhan_cong(Integer.parseInt(textField_2.getText()));
		user.setSo_ban(Integer.parseInt(textField_3.getText()));
		if (comboBox.getSelectedIndex()==1)
			user.setTrang_thai(true);
		else if (comboBox.getSelectedIndex()==2)
			user.setTrang_thai(false);
	}
	private void tb_refresh(){
		result = db.get();
		table.setModel(DbUtils.resultSetToTableModel(result));
	}
	private void add(){
		ObjectCreation();
		db.insert(user);
		tb_refresh();
	}
	private void edit(){
		ObjectCreation();
		db.update(user);
		tb_refresh();
	}
	private void delete(){
		ObjectCreation();
		db.delete(user.getID());
		tb_refresh();
	}
}