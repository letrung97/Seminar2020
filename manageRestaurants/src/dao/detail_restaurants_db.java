package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.main_info;

public class detail_restaurants_db {
	Connection conn;
	PreparedStatement statement = null;
	ResultSet result = null;
	public detail_restaurants_db() {
		conn = DBconnect.connect();
	}
	public void insert(main_info user){
		try {
			String insertQuery = "insert into main_info"
					+ "(ma_nha_hang, ID_quan, ID_phuong)"
					+ " values(" + user.getMa_nha_hang()
					+ "," + user.getID_quan()
					+ "," + user.getID_phuong()
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
	public void update(main_info user){
		try {
			String updateQuery = "update main_info set "
					+ "ma_nha_hang = " + user.getMa_nha_hang()
					+ "ID_quan = " + user.getID_quan()
					+ "ID_phuong = " + user.getID_phuong()
					+ "where ID = " + user.getID();
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
			String query= "delete from main_info where ID = " + id;
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
			String query= "select * from main_info";
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
	public ResultSet getById(int id) {
		try {
			String query= "select ID from main_info where ma_nha_hang = " + id;
			statement = conn.prepareStatement(query);
			result = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}