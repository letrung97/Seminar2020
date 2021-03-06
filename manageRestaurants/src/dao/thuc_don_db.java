package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.thuc_don;

public class thuc_don_db {
	Connection conn;
	PreparedStatement statement = null;
	ResultSet result = null;
	public thuc_don_db() {
		conn = DBconnect.connect();
	}
	public void insert(thuc_don user){
		try {
			String insertQuery = "insert into thuc_don"
					+ "(ma_nha_hang, ten_mon, gia)"
					+ " values(" + user.getMa_nha_hang()
					+ ",'" + user.getTen_mon() + "'"
					+ "," + user.getGia()
					+ ")";
			statement = conn.prepareStatement(insertQuery);
			statement.execute();
			JOptionPane.showMessageDialog(null, "Inserted");
		} catch (SQLException ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		} finally {
			flushStatementOnly();
		}
	}
	private void flushStatementOnly() {
		try {
			statement.close();
		}
		catch (SQLException ex)
		{
			System.err.print(ex.toString() + "CLOSING DB");
		}
	}
	public void update(thuc_don user){
		try {
			String updateQuery = "update thuc_don set "
					+ "ten_khach_hang = '" + user.getMa_nha_hang() + "'" + ","
					+ "ten_mon = '" + user.getTen_mon() + "',"
					+ "gia = " + user.getGia()
					+ " where stt = " + user.getStt();
			statement = conn.prepareStatement(updateQuery);
			statement.execute();
			JOptionPane.showMessageDialog(null, "Updated");
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	public void delete(int id){
		try {
			String query= "delete from thuc_don where stt = " + id;
			statement = conn.prepareStatement(query);
			statement.execute();
			JOptionPane.showMessageDialog(null, "Deleted");
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
}
