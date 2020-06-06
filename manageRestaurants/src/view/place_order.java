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
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{222, 0};
		gbl_panel.rowHeights = new int[]{17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("Mã đơn");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);
		
		textField = new JTextField();
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
		
		
		
		JLabel lblMNhHng = new JLabel("Mã nhà hàng");
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
						update_LS(Integer.parseInt(comboBox.getSelectedItem().toString()));
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}});
		
		JLabel lblSBnt = new JLabel("Số bàn đặt");
		lblSBnt.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblSBnt = new GridBagConstraints();
		gbc_lblSBnt.insets = new Insets(0, 0, 5, 0);
		gbc_lblSBnt.gridx = 0;
		gbc_lblSBnt.gridy = 9;
		panel.add(lblSBnt, gbc_lblSBnt);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 10;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				add();
			}
		});
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"chọn nhà hàng"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 11;
		panel.add(comboBox_1, gbc_comboBox_1);
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 15;
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
		gbc_btnEdit.gridy = 16;
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
		gbc_btnDelete.gridy = 17;
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
	private void update_CB() throws SQLException{
		ResultSet rs = ls.get();
		comboBox.removeAllItems();
		while (rs.next()){
			comboBox.addItem(rs.getString("ma_nha_hang"));
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
		user.setMa_don(Integer.parseInt(textField.getText()));
		user.setNgay_dat(textField_4.getText());//yyyy-mm-dd
		user.setSo_ban_dat(Integer.parseInt(textField_2.getText()));
		user.setTen_khach_hang(textField_1.getText());
		user.setID(Integer.parseInt(comboBox_1.getSelectedItem().toString()));
		user.setMa_nha_hang(Integer.parseInt(comboBox.getSelectedItem().toString()));
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
		db.delete(user.getMa_don());
		tb_refresh();
	}
}