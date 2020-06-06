package model;

import java.io.Serializable;

public class tp_hcm  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID_quan;
	private String ten_quan;
	private int ID_phuong;
	private String ten_phuong;
	public int getID_quan() {
		return ID_quan;
	}
	public void setID_quan(int iD_quan) {
		ID_quan = iD_quan;
	}
	public String getTen_quan() {
		return ten_quan;
	}
	public void setTen_quan(String ten_quan) {
		this.ten_quan = ten_quan;
	}
	public int getID_phuong() {
		return ID_phuong;
	}
	public void setID_phuong(int iD_phuong) {
		ID_phuong = iD_phuong;
	}
	public String getTen_phuong() {
		return ten_phuong;
	}
	public void setTen_phuong(String ten_phuong) {
		this.ten_phuong = ten_phuong;
	}
}
