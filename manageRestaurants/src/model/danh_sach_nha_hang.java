package model;

import java.io.Serializable;

public class danh_sach_nha_hang implements Serializable{
	private static final long serialVersionUID = 1L;
	private int ma_nha_hang;
	private String ten_nha_hang;
	private int so_chi_nhanh;
	private boolean loai_nha_hang;
	public int getMa_nha_hang() {
		return ma_nha_hang;
	}
	public void setMa_nha_hang(int ma_nha_hang) {
		this.ma_nha_hang = ma_nha_hang;
	}
	public String getTen_nha_hang() {
		return ten_nha_hang;
	}
	public void setTen_nha_hang(String ten_nha_hang) {
		this.ten_nha_hang = ten_nha_hang;
	}
	public int getSo_chi_nhanh() {
		return so_chi_nhanh;
	}
	public void setSo_chi_nhanh(int so_chi_nhanh) {
		this.so_chi_nhanh = so_chi_nhanh;
	}
	public boolean isLoai_nha_hang() {
		return loai_nha_hang;
	}
	public void setLoai_nha_hang(boolean loai_nha_hang) {
		this.loai_nha_hang = loai_nha_hang;
	}

}