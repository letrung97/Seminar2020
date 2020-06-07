package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.don_dat;

public class place_order_db {
	Connection conn;
	PreparedStatement statement = null;
	ResultSet result = null;
	public place_order_db() {
		conn = DBconnect.connect();
	}
	public void insert(don_dat user){
		try {
			String insertQuery = "insert into don_dat"
					+ "(ten_khach_hang, ngay_dat, ma_nha_hang, so_ban_dat, ID)"
					+ " values('" + user.getTen_khach_hang() + "'"
					+ ",'" + user.getNgay_dat() + "'"
					+ "," + user.getMa_nha_hang()
					+ "," + user.getSo_ban_dat()
					+ "," + user.getID()
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
	public void update(don_dat user){
		try {
			String updateQuery = "update don_dat set "
					+ "ten_khach_hang = '" + user.getTen_khach_hang() + "'" + ","
					+ "ngay_dat = " + user.getNgay_dat() + ","
					+ "ma_nha_hang = " + user.getMa_nha_hang() + ","
					+ "so_ban_dat = " + user.getSo_ban_dat() + ","
					+ "ID = " + user.getID()
					+ "where ma_don = " + user.getMa_don();
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
			String query= "delete from don_dat where ma_don = " + id;
			statement = conn.prepareStatement(query);
			statement.execute();
			JOptionPane.showMessageDialog(null, "Deleted");
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	public ResultSet get(){
		try {
			String query= "select ma_don,ten_khach_hang,date_format(ngay_dat,'%d/%m/%Y') ngay_dat,ma_nha_hang,so_ban_dat,ID from don_dat";
			statement = conn.prepareStatement(query);
			result = statement.executeQuery();
		} catch (SQLException ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		return result;
	}
	public void flushAll(){
		try {
			statement.close();
			result.close();
		} catch (SQLException ex) {
			System.err.print(ex.toString() + " >> CLOSING DB");
		}
	}
}
