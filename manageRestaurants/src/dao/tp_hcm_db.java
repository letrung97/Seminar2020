package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class tp_hcm_db {
	Connection conn;
	PreparedStatement statement = null;
	ResultSet result = null;
	public tp_hcm_db() {
		conn = DBconnect.connect();
	}
	public ResultSet get(int id){
		try {
			String query= "select ten_phuong from tp_hcm where ID_quan = " + id;
			statement = conn.prepareStatement(query);
			result = statement.executeQuery();
		} catch (SQLException ex){
			JOptionPane.showMessageDialog(null, ex.toString());
		}
		return result;
	}
}
