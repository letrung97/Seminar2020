package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.danh_sach_nha_hang;

public class list_restaurant_db {
	Connection conn;
	PreparedStatement statement = null;
	ResultSet result = null;
	public list_restaurant_db() {
		conn = DBconnect.connect();
	}
	public void insert(danh_sach_nha_hang user){
		try {
			String insertQuery = "insert into danh_sach_nha_hang"
					+ "(ten_nha_hang, so_chi_nhanh,loai_nha_hang,loai_nha_hang_str)"
					+ " values('" + user.getTen_nha_hang() + "'"
					+ "," + user.getSo_chi_nhanh()
					+ "," + user.isLoai_nha_hang()
					+ ",'" + user.getType() + "'"
					+ ")";
			statement = conn.prepareStatement(insertQuery);
			statement.execute();
			//JOptionPane.showMessageDialog(null, "Inserted");
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
	public void update(danh_sach_nha_hang user){
		try {
			detail_restaurants_db dr = new detail_restaurants_db();
			dr.updateLink(user.getTen_nha_hang(),user.getMa_nha_hang());
			String updateQuery = "update danh_sach_nha_hang set "
					+ "ten_nha_hang = '" + user.getTen_nha_hang() + "'" + ","
					+ "so_chi_nhanh = " + user.getSo_chi_nhanh() + ","
					+ "loai_nha_hang = " + user.isLoai_nha_hang() + ","
					+ "loai_nha_hang_str = '" + user.getType()  + "' "
					+ "where ma_nha_hang = " + user.getMa_nha_hang();
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
			detail_restaurants_db dr = new detail_restaurants_db();
			dr.deleteByID(id);
			String query= "delete from danh_sach_nha_hang where ma_nha_hang = " + id;
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
			String query= "select ma_nha_hang,ten_nha_hang,so_chi_nhanh,loai_nha_hang_str from danh_sach_nha_hang";
			statement = conn.prepareStatement(query);
			result = statement.executeQuery();
		} catch (SQLException ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		return result;
	}
	public ResultSet getByName(String str){
		try {
			String query= "select * from danh_sach_nha_hang where ten_nha_hang = '" + str + "'";
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
