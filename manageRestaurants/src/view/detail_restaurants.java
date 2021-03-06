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

import model.main_info;
import net.proteanit.sql.DbUtils;
import dao.detail_restaurants_db;
import dao.list_restaurant_db;
import dao.tp_hcm_db;

import java.awt.SystemColor;

public class detail_restaurants extends JFrame {
	main_info user = new main_info();
	tp_hcm_db tp = new tp_hcm_db(); 
	detail_restaurants_db db = new detail_restaurants_db();
	list_restaurant_db ls = new list_restaurant_db();
	ResultSet result = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JTable table;
	private JComboBox<String> comboBox_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					detail_restaurants frame = new detail_restaurants();
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
	public detail_restaurants() {
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
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 0);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		panel.add(lblId, gbc_lblId);
		
		textField = new JTextField();
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblMNhHng = new JLabel("Tên nhà hàng");
		lblMNhHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblMNhHng = new GridBagConstraints();
		gbc_lblMNhHng.anchor = GridBagConstraints.SOUTH;
		gbc_lblMNhHng.insets = new Insets(0, 0, 5, 0);
		gbc_lblMNhHng.gridx = 0;
		gbc_lblMNhHng.gridy = 3;
		panel.add(lblMNhHng, gbc_lblMNhHng);
		
		comboBox_2 = new JComboBox<String>();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 0;
		gbc_comboBox_2.gridy = 4;
		panel.add(comboBox_2, gbc_comboBox_2);
		try {
			update_LS();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		JLabel lblIdQun = new JLabel("Tên quận");
		lblIdQun.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblIdQun = new GridBagConstraints();
		gbc_lblIdQun.insets = new Insets(0, 0, 5, 0);
		gbc_lblIdQun.gridx = 0;
		gbc_lblIdQun.gridy = 5;
		panel.add(lblIdQun, gbc_lblIdQun);
		
		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8", "Quận 9", "Quận 10", "Quận 11", "Quận 12", "Quận Bình Tân", "Quận Bình Thạnh", "Quận Gò Vấp", "Quận Phú Nhuận", "Quận Tân Bình", "Quận Tân Phú", "Quận Thủ Đức", "Huyện Bình Chánh", "Huyện Cần Giờ", "Huyện Củ Chi", "Huyện Hóc Môn", "Huyện Nhà Bè"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 6;
		panel.add(comboBox, gbc_comboBox);
		comboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					try {
						update_CB(comboBox.getSelectedIndex()+1);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}});
		
		JLabel lblTnPhng = new JLabel("Tên phường");
		lblTnPhng.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblTnPhng = new GridBagConstraints();
		gbc_lblTnPhng.insets = new Insets(0, 0, 5, 0);
		gbc_lblTnPhng.gridx = 0;
		gbc_lblTnPhng.gridy = 7;
		panel.add(lblTnPhng, gbc_lblTnPhng);
		
		comboBox_1 = new JComboBox<String>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 8;
		panel.add(comboBox_1, gbc_comboBox_1);
		try {
			update_CB(comboBox.getSelectedIndex()+1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_add();
			}
		});
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 10;
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
		gbc_btnEdit.gridy = 11;
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
		gbc_btnDelete.gridy = 12;
		panel.add(btnDelete, gbc_btnDelete);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblThngTinDanh = new JLabel("Danh sách địa chỉ nhà hàng");
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
			       comboBox_2.setSelectedItem(model.getValueAt(selectedRowIndex, 1).toString());
			       comboBox.setSelectedItem(model.getValueAt(selectedRowIndex, 2).toString());
			       comboBox_1.setSelectedItem(model.getValueAt(selectedRowIndex, 3).toString());
			       
			    }
				
        });
		tb_refresh();
	}
	private void update_CB(int id) throws SQLException{
		ResultSet rs = tp.get(id);
		comboBox_1.removeAllItems();
		while (rs.next()){
			comboBox_1.addItem(rs.getString("ten_phuong"));
		}
	}
	private void update_LS() throws SQLException{
		ResultSet rs = ls.get();
		comboBox_2.removeAllItems();
		while (rs.next()){
			comboBox_2.addItem(rs.getString("ten_nha_hang"));
		}
	}
	private void ObjectCreation(){
		user = new main_info();
		if (textField.getText().isEmpty())
			user.setID(0);
		else
			user.setID(Integer.parseInt(textField.getText()));
		try {
			ResultSet rs =ls.getByName(comboBox_2.getSelectedItem().toString());
			rs.next();
			user.setMa_nha_hang(Integer.parseInt(rs.getString("ma_nha_hang")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		user.setTen_nha_hang(comboBox_2.getSelectedItem().toString());
		user.setID_quan(comboBox.getSelectedIndex()+1);
		user.setID_phuong(comboBox_1.getSelectedIndex()+1);
		user.setTen_quan(comboBox.getSelectedItem().toString());
		user.setTen_phuong(comboBox_1.getSelectedItem().toString());
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
