package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

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

import model.don_dat;
import net.proteanit.sql.DbUtils;
import dao.detail_restaurants_db;
import dao.list_restaurant_db;
import dao.place_order_db;

public class place_order extends JFrame {
	don_dat user = new don_dat();
	place_order_db db = new place_order_db();
	ResultSet result = null;
	list_restaurant_db ls = new list_restaurant_db();
	detail_restaurants_db re = new detail_restaurants_db();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					place_order frame = new place_order();
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
	public place_order() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quản lý đơn đặt");
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
		gbl_panel.rowHeights = new int[]{17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("Mã đơn");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);
		
		textField = new JTextField();
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblTnNhHng = new JLabel("Tên khách hàng");
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
		
		JLabel lblNgyt = new JLabel("Ngày đặt");
		lblNgyt.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNgyt = new GridBagConstraints();
		gbc_lblNgyt.insets = new Insets(0, 0, 5, 0);
		gbc_lblNgyt.gridx = 0;
		gbc_lblNgyt.gridy = 5;
		panel.add(lblNgyt, gbc_lblNgyt);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 0;
		gbc_textField_4.gridy = 6;
		panel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		
		
		JLabel lblMNhHng = new JLabel("Tên nhà hàng");
		lblMNhHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblMNhHng = new GridBagConstraints();
		gbc_lblMNhHng.insets = new Insets(0, 0, 5, 0);
		gbc_lblMNhHng.gridx = 0;
		gbc_lblMNhHng.gridy = 7;
		panel.add(lblMNhHng, gbc_lblMNhHng);
		
		comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 8;
		panel.add(comboBox, gbc_comboBox);
		try {
			update_CB();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		comboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
					try {
						ResultSet rs =ls.getByName(comboBox.getSelectedItem().toString());
						rs.next();
						update_LS(rs.getInt("ma_nha_hang"));
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}});
		
		JLabel lblIdNhHng = new JLabel("ID nhà hàng");
		lblIdNhHng.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblIdNhHng = new GridBagConstraints();
		gbc_lblIdNhHng.insets = new Insets(0, 0, 5, 0);
		gbc_lblIdNhHng.gridx = 0;
		gbc_lblIdNhHng.gridy = 9;
		panel.add(lblIdNhHng, gbc_lblIdNhHng);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 10;
		panel.add(comboBox_1, gbc_comboBox_1);
		try {
			ResultSet rs =ls.getByName(comboBox.getSelectedItem().toString());
			rs.next();
			update_LS(rs.getInt("ma_nha_hang"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JLabel lblSBnt = new JLabel("Số bàn đặt");
		lblSBnt.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblSBnt = new GridBagConstraints();
		gbc_lblSBnt.insets = new Insets(0, 0, 5, 0);
		gbc_lblSBnt.gridx = 0;
		gbc_lblSBnt.gridy = 11;
		panel.add(lblSBnt, gbc_lblSBnt);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 12;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
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
		
		JLabel lblThngTinDanh = new JLabel("Danh sách các đơn đặt");
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
			       
			       textField.setText(model.getValueAt(selectedRowIndex, 0).toString());
			       textField_1.setText(model.getValueAt(selectedRowIndex, 1).toString());
			       textField_4.setText(model.getValueAt(selectedRowIndex, 2).toString());
			       textField_2.setText(model.getValueAt(selectedRowIndex, 5).toString());
			       comboBox.setSelectedItem(model.getValueAt(selectedRowIndex, 3).toString());
			       comboBox_1.setSelectedItem(model.getValueAt(selectedRowIndex, 4).toString());
			    }
				
        });
		tb_refresh();
	}
	private void update_CB() throws SQLException{
		ResultSet rs = ls.get();
		comboBox.removeAllItems();
		while (rs.next()){
			comboBox.addItem(rs.getString("ten_nha_hang"));
		}
	}
	private void update_LS(int id) throws SQLException{
		ResultSet rs = re.getById(id);
		comboBox_1.removeAllItems();
		while (rs.next()){
			comboBox_1.addItem(rs.getString("ID"));
		}
	}
	private void ObjectCreation(){
		user = new don_dat();
		if (textField.getText().isEmpty())
			user.setMa_don(0);
		else
			user.setMa_don(Integer.parseInt(textField.getText()));
		user.setNgay_dat(textField_4.getText());//dd-mm-yyyy
		user.setSo_ban_dat(Integer.parseInt(textField_2.getText()));
		user.setTen_khach_hang(textField_1.getText());
		user.setID(Integer.parseInt(comboBox_1.getSelectedItem().toString()));		
		user.setTen_nha_hang(comboBox.getSelectedItem().toString());
		ResultSet rs =ls.getByName(comboBox.getSelectedItem().toString());
		try {
			rs.next();
			user.setMa_nha_hang(rs.getInt("ma_nha_hang"));
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
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
		db.delete(user.getMa_don());
		tb_refresh();
	}
}
