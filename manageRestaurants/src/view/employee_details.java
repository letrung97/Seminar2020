package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

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

import model.nhan_vien;
import net.proteanit.sql.DbUtils;
import dao.detail_restaurants_db;
import dao.employee_details_db;
import dao.list_restaurant_db;

import java.awt.SystemColor;

public class employee_details extends JFrame {
	nhan_vien user = new nhan_vien();
	employee_details_db db = new employee_details_db();
	list_restaurant_db ls = new list_restaurant_db();
	detail_restaurants_db in = new detail_restaurants_db();
	ResultSet result = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_2;
	private JComboBox<String> comboBox_3;
	private JTable table;
	private JComboBox<String> comboBox_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee_details frame = new employee_details();
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
	public employee_details() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quản lý nhân viên");
		setBounds(100, 100, 800, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{222, 0};
		gbl_panel.rowHeights = new int[]{17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên");
		lblMNhnVin.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblMNhnVin = new GridBagConstraints();
		gbc_lblMNhnVin.insets = new Insets(0, 0, 5, 0);
		gbc_lblMNhnVin.gridx = 0;
		gbc_lblMNhnVin.gridy = 0;
		panel.add(lblMNhnVin, gbc_lblMNhnVin);
		
		textField = new JTextField();
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tên nhân viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 3;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMNhHng = new JLabel("Tên nhà hàng");
		lblMNhHng.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblMNhHng = new GridBagConstraints();
		gbc_lblMNhHng.insets = new Insets(0, 0, 5, 0);
		gbc_lblMNhHng.gridx = 0;
		gbc_lblMNhHng.gridy = 4;
		panel.add(lblMNhHng, gbc_lblMNhHng);
		
		comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 5;
		panel.add(comboBox, gbc_comboBox);
		try {
			update_cb();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		comboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					try {
						ResultSet rs =ls.getByName(comboBox.getSelectedItem().toString());
						rs.next();
						update_cb4(Integer.parseInt(rs.getString("ma_nha_hang")));
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}});
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 0);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 6;
		panel.add(lblId, gbc_lblId);
		
		comboBox_4 = new JComboBox<String>();
		GridBagConstraints gbc_comboBox_4 = new GridBagConstraints();
		gbc_comboBox_4.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_4.gridx = 0;
		gbc_comboBox_4.gridy = 7;
		panel.add(comboBox_4, gbc_comboBox_4);
		try {
			ResultSet rs =ls.getByName(comboBox.getSelectedItem().toString());
			rs.next();
			update_cb4(Integer.parseInt(rs.getString("ma_nha_hang")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel lblSCmnd = new JLabel("Số CMND");
		lblSCmnd.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblSCmnd = new GridBagConstraints();
		gbc_lblSCmnd.insets = new Insets(0, 0, 5, 0);
		gbc_lblSCmnd.gridx = 0;
		gbc_lblSCmnd.gridy = 8;
		panel.add(lblSCmnd, gbc_lblSCmnd);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 9;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblChcV = new JLabel("Chức vụ");
		lblChcV.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblChcV = new GridBagConstraints();
		gbc_lblChcV.insets = new Insets(0, 0, 5, 0);
		gbc_lblChcV.gridx = 0;
		gbc_lblChcV.gridy = 10;
		panel.add(lblChcV, gbc_lblChcV);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Quản lý", "Thu ngân", "Kế toán", "Phục vụ", "Đầu bếp", "Lao công", "Phụ bếp"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 11;
		panel.add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblSNgyNgh = new JLabel("Số ngày nghỉ có phép");
		lblSNgyNgh.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblSNgyNgh = new GridBagConstraints();
		gbc_lblSNgyNgh.insets = new Insets(0, 0, 5, 0);
		gbc_lblSNgyNgh.gridx = 0;
		gbc_lblSNgyNgh.gridy = 12;
		panel.add(lblSNgyNgh, gbc_lblSNgyNgh);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 0;
		gbc_comboBox_2.gridy = 13;
		panel.add(comboBox_2, gbc_comboBox_2);
		
		JLabel lblSNgyNgh_1 = new JLabel("số ngày nghỉ không phép");
		lblSNgyNgh_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblSNgyNgh_1 = new GridBagConstraints();
		gbc_lblSNgyNgh_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblSNgyNgh_1.gridx = 0;
		gbc_lblSNgyNgh_1.gridy = 14;
		panel.add(lblSNgyNgh_1, gbc_lblSNgyNgh_1);
		
		comboBox_3 = new JComboBox<String>();
		comboBox_3.setModel(new DefaultComboBoxModel<String>(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.gridx = 0;
		gbc_comboBox_3.gridy = 15;
		panel.add(comboBox_3, gbc_comboBox_3);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_add();
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 17;
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
		gbc_btnEdit.gridy = 18;
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
		gbc_btnDelete.gridy = 19;
		panel.add(btnDelete, gbc_btnDelete);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblThngTinDanh = new JLabel("Danh sách nhân viên");
		panel_2.add(lblThngTinDanh);
		lblThngTinDanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngTinDanh.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
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
			       textField_1.setText(model.getValueAt(selectedRowIndex, 2).toString());
			       textField_2.setText(model.getValueAt(selectedRowIndex, 3).toString());
			       comboBox_2.setSelectedItem(model.getValueAt(selectedRowIndex, 5).toString());
			       comboBox_3.setSelectedItem(model.getValueAt(selectedRowIndex, 6).toString());
			       comboBox_1.setSelectedItem(model.getValueAt(selectedRowIndex, 4).toString());
			       ResultSet rs = in.getBy(Integer.parseInt(model.getValueAt(selectedRowIndex, 1).toString()));
			       try {
			    	   rs.next();
			    	   comboBox.setSelectedItem(rs.getString("ten_nha_hang"));
			    	   comboBox_4.setSelectedItem(rs.getString("ID"));
			       } catch (SQLException e) {
			    	   e.printStackTrace();
			       }
			    }
				
        });
		tb_refresh();
	}
	private void update_cb() throws SQLException{
		list_restaurant_db bd = new list_restaurant_db();
		ResultSet rs = bd.get();
		while (rs.next()){
			comboBox.addItem(rs.getString("ten_nha_hang"));
		}
	}
	private void update_cb4(int id) throws SQLException{
		detail_restaurants_db bd = new detail_restaurants_db();
		ResultSet rs = bd.getById(id);
		comboBox_4.removeAllItems();
		while (rs.next()){
			comboBox_4.addItem(rs.getString("ID"));
		}
	}
	private void ObjectCreation(){
		user = new nhan_vien();
		if (textField.getText().isEmpty())
			user.setMa_nhan_vien(0);
		else
			user.setMa_nhan_vien(Integer.parseInt(textField.getText()));
		user.setTen_nhan_vien(textField_1.getText());
		user.setID(Integer.parseInt(comboBox_4.getSelectedItem().toString()));
		user.setId_num(Integer.parseInt(textField_2.getText()));
		user.setChuc_vu(comboBox_1.getSelectedItem().toString());
		user.setSo_ngay_nghi_co_phep(comboBox_2.getSelectedIndex());
		user.setSo_ngay_nghi_khong_phep(comboBox_3.getSelectedIndex());
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
		db.delete(user.getMa_nhan_vien());
		tb_refresh();
	}
}
