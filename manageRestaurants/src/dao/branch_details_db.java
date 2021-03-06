package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.danh_sach_thong_tin;

public class branch_details_db {
	Connection conn;
	PreparedStatement statement = null;
	ResultSet result = null;
	public branch_details_db() {
		conn = DBconnect.connect();
	}
	public void insert(danh_sach_thong_tin user){
		try {
			String insertQuery = "insert into danh_sach_thong_tin"
					+ "(quan_ly, so_nhan_cong, so_ban, trang_thai,state,ID)"
					+ " values('" + user.getQuan_ly() + "'"
					+ "," + user.getSo_nhan_cong()
					+ "," + user.getSo_ban()
					+ "," + user.isTrang_thai()
					+ ",'" + user.getState() + "'"
					+ "," + user.getID()
					+ ")";
			statement = conn.prepareStatement(insertQuery);
			statement.execute();
			//JOptionPane.showMessageDialog(null, "Inserted");
		} 
		catch (SQLException ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		} 
		finally {
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
	public void update(danh_sach_thong_tin user){
		try {
			String updateQuery = "update danh_sach_thong_tin set "
					+ "quan_ly = '" + user.getQuan_ly() + "',"
					+ "state = '" + user.getState() + "',"
					+ "so_nhan_cong = " + user.getSo_nhan_cong() + ","
					+ "so_ban = " + user.getSo_ban() + ","
					+ "trang_thai = " + user.isTrang_thai()
					+ " where ID = " + user.getID();
			statement = conn.prepareStatement(updateQuery);
			statement.execute();
			//JOptionPane.showMessageDialog(null, "Updated");
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	public void delete(int id){
		try {
			String query= "delete from danh_sach_thong_tin where ID = " + id;
			statement = conn.prepareStatement(query);
			statement.execute();
			//JOptionPane.showMessageDialog(null, "Deleted");
		}
		catch (SQLException ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	public ResultSet get(){
		try {
			String query= "select ID, quan_ly, so_nhan_cong, so_ban, state from danh_sach_thong_tin";
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
