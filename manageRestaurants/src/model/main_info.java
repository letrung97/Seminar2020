package model;

import java.io.Serializable;

public class main_info  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ID;
	private int ma_nha_hang;
	private int ID_quan;
	private int ID_phuong;
	private String ten_quan;
	private String ten_phuong;
	private String ten_nha_hang;
	public String getTen_nha_hang() {
		return ten_nha_hang;
	}
	public void setTen_nha_hang(String ten_nha_hang) {
		this.ten_nha_hang = ten_nha_hang;
	}
	public String getTen_quan() {
		return ten_quan;
	}
	public void setTen_quan(String ten_quan) {
		this.ten_quan = ten_quan;
	}
	public String getTen_phuong() {
		return ten_phuong;
	}
	public void setTen_phuong(String ten_phuong) {
		this.ten_phuong = ten_phuong;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getMa_nha_hang() {
		return ma_nha_hang;
	}
	public void setMa_nha_hang(int ma_ma_hang) {
		this.ma_nha_hang = ma_ma_hang;
	}
	public int getID_quan() {
		return ID_quan;
	}
	public void setID_quan(int iD_quan) {
		ID_quan = iD_quan;
	}
	public int getID_phuong() {
		return ID_phuong;
	}
	public void setID_phuong(int iD_phuong) {
		ID_phuong = iD_phuong;
	}
}
