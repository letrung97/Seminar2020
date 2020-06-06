package model;

import java.io.Serializable;

public class don_dat  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ma_don;
	private String ten_khach_hang;
	private String ngay_dat;
	private int ma_nha_hang;
	private int so_ban_dat;
	private int ID;
	
	public int getMa_don() {
		return ma_don;
	}
	public void setMa_don(int ma_don) {
		this.ma_don = ma_don;
	}
	public String getTen_khach_hang() {
		return ten_khach_hang;
	}
	public void setTen_khach_hang(String ten_khach_hang) {
		this.ten_khach_hang = ten_khach_hang;
	}
	public String getNgay_dat() {
		return ngay_dat;
	}
	public void setNgay_dat(String ngay_dat) {
		this.ngay_dat = ngay_dat;
	}
	public int getMa_nha_hang() {
		return ma_nha_hang;
	}
	public void setMa_nha_hang(int ma_nha_hang) {
		this.ma_nha_hang = ma_nha_hang;
	}
	public int getSo_ban_dat() {
		return so_ban_dat;
	}
	public void setSo_ban_dat(int so_ban_dat) {
		this.so_ban_dat = so_ban_dat;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
}
