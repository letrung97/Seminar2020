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