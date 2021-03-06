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

import model.danh_sach_thong_tin;
import net.proteanit.sql.DbUtils;
import dao.branch_details_db;
import dao.detail_restaurants_db;
import dao.list_restaurant_db;

import java.awt.SystemColor;

public class branch_details extends JFrame {
	danh_sach_thong_tin user = new danh_sach_thong_tin();
	branch_details_db db = new branch_details_db();
	list_restaurant_db ls = new list_restaurant_db();
	detail_restaurants_db in = new detail_restaurants_db();
	ResultSet result = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox<String> comboBox;
	private JTable table;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_2;

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
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{222, 0};
		gbl_panel.rowHeights = new int[]{17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_delete();
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_edit();
			}
		});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_add();
			}
		});
		
		JLabel lblMNhHng = new JLabel("Tên nhà hàng");
		lblMNhHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblMNhHng = new GridBagConstraints();
		gbc_lblMNhHng.insets = new Insets(0, 0, 5, 0);
		gbc_lblMNhHng.gridx = 0;
		gbc_lblMNhHng.gridy = 1;
		panel.add(lblMNhHng, gbc_lblMNhHng);
		
		comboBox_1 = new JComboBox<String>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 2;
		panel.add(comboBox_1, gbc_comboBox_1);
		try {
			update_cb();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		comboBox_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					try {
						ResultSet rs =ls.getByName(comboBox_1.getSelectedItem().toString());
						rs.next();
						update_cb4(Integer.parseInt(rs.getString("ma_nha_hang")));
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}});
		JLabel lblIdNhHng = new JLabel("ID nhà hàng");
		lblIdNhHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblIdNhHng = new GridBagConstraints();
		gbc_lblIdNhHng.insets = new Insets(0, 0, 5, 0);
		gbc_lblIdNhHng.gridx = 0;
		gbc_lblIdNhHng.gridy = 3;
		panel.add(lblIdNhHng, gbc_lblIdNhHng);
		
		comboBox_2 = new JComboBox<String>();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 0;
		gbc_comboBox_2.gridy = 4;
		panel.add(comboBox_2, gbc_comboBox_2);
		try {
			ResultSet rs =ls.getByName(comboBox_1.getSelectedItem().toString());
			rs.next();
			update_cb4(Integer.parseInt(rs.getString("ma_nha_hang")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel lblTnNhHng = new JLabel("Tên quản lý");
		lblTnNhHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblTnNhHng = new GridBagConstraints();
		gbc_lblTnNhHng.insets = new Insets(0, 0, 5, 0);
		gbc_lblTnNhHng.gridx = 0;
		gbc_lblTnNhHng.gridy = 5;
		panel.add(lblTnNhHng, gbc_lblTnNhHng);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 6;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Số nhân công");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 7;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 8;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTngSBn = new JLabel("Tổng số bàn");
		lblTngSBn.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblTngSBn = new GridBagConstraints();
		gbc_lblTngSBn.insets = new Insets(0, 0, 5, 0);
		gbc_lblTngSBn.gridx = 0;
		gbc_lblTngSBn.gridy = 9;
		panel.add(lblTngSBn, gbc_lblTngSBn);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 10;
		panel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Trạng thái", "Hoạt động", "Đóng cửa"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 11;
		panel.add(comboBox, gbc_comboBox);
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 13;
		panel.add(btnAdd, gbc_btnAdd);
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 5, 0);
		gbc_btnEdit.gridx = 0;
		gbc_btnEdit.gridy = 14;
		panel.add(btnEdit, gbc_btnEdit);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 15;
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
			       textField_1.setText(model.getValueAt(selectedRowIndex, 1).toString());
			       textField_2.setText(model.getValueAt(selectedRowIndex, 2).toString());
			       textField_3.setText(model.getValueAt(selectedRowIndex, 3).toString());
			       ResultSet rs = in.getBy(Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString()));
			       try {
			    	   rs.next();
			    	   comboBox_1.setSelectedItem(rs.getString("ten_nha_hang"));
			    	   comboBox_2.setSelectedItem(rs.getString("ID"));
			       } catch (SQLException e) {
			    	   e.printStackTrace();
			       }
			       if (model.getValueAt(selectedRowIndex, 4).equals("Hoạt động"))
			    	   comboBox.setSelectedIndex(1);
			       else if (model.getValueAt(selectedRowIndex, 4).equals("Đóng cửa"))
			    	   comboBox.setSelectedIndex(2);
			    }
				
        });
		tb_refresh();
	}
	private void update_cb() throws SQLException{
		list_restaurant_db bd = new list_restaurant_db();
		ResultSet rs = bd.get();
		while (rs.next()){
			comboBox_1.addItem(rs.getString("ten_nha_hang"));
		}
	}
	private void update_cb4(int id) throws SQLException{
		detail_restaurants_db bd = new detail_restaurants_db();
		ResultSet rs = bd.getById(id);
		comboBox_2.removeAllItems();
		while (rs.next()){
			comboBox_2.addItem(rs.getString("ID"));
		}
	}
	private void ObjectCreation(){
		user = new danh_sach_thong_tin();
		user.setID(Integer.parseInt(comboBox_2.getSelectedItem().toString()));
		user.setQuan_ly(textField_1.getText());
		user.setSo_nhan_cong(Integer.parseInt(textField_2.getText()));
		user.setSo_ban(Integer.parseInt(textField_3.getText()));
		if (comboBox.getSelectedIndex()==1){
			user.setTrang_thai(true);
			user.setState("Hoạt động");
		}
		else if (comboBox.getSelectedIndex()==2){
			user.setTrang_thai(false);
			user.setState("Đóng cửa");
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
		db.delete(user.getID());
		tb_refresh();
	}
}
