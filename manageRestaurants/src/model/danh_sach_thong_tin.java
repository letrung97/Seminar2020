package model;

import java.io.Serializable;

public class danh_sach_thong_tin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private String quan_ly;
	private String state;
	private int so_nhan_cong;
	private int so_ban;
	private boolean trang_thai;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getQuan_ly() {
		return quan_ly;
	}
	public void setQuan_ly(String quan_ly) {
		this.quan_ly = quan_ly;
	}
	public int getSo_nhan_cong() {
		return so_nhan_cong;
	}
	public void setSo_nhan_cong(int so_nhan_cong) {
		this.so_nhan_cong = so_nhan_cong;
	}
	public int getSo_ban() {
		return so_ban;
	}
	public void setSo_ban(int so_ban) {
		this.so_ban = so_ban;
	}
	public boolean isTrang_thai() {
		return trang_thai;
	}
	public void setTrang_thai(boolean trang_thai) {
		this.trang_thai = trang_thai;
	}

}
