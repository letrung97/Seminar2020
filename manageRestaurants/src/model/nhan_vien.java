package model;

import java.io.Serializable;

public class nhan_vien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ma_nhan_vien;
	private int ID;
	private String ten_nhan_vien;
	private int id_num;
	private String chuc_vu;
	private int so_ngay_nghi_co_phep;
	private int so_ngay_nghi_khong_phep;
	public int getMa_nhan_vien() {
		return ma_nhan_vien;
	}
	public void setMa_nhan_vien(int ma_nhan_vien) {
		this.ma_nhan_vien = ma_nhan_vien;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTen_nhan_vien() {
		return ten_nhan_vien;
	}
	public void setTen_nhan_vien(String ten_nhan_vien) {
		this.ten_nhan_vien = ten_nhan_vien;
	}
	public int getId_num() {
		return id_num;
	}
	public void setId_num(int id_num) {
		this.id_num = id_num;
	}
	public String getChuc_vu() {
		return chuc_vu;
	}
	public void setChuc_vu(String chuc_vu) {
		this.chuc_vu = chuc_vu;
	}
	public int getSo_ngay_nghi_co_phep() {
		return so_ngay_nghi_co_phep;
	}
	public void setSo_ngay_nghi_co_phep(int so_ngay_nghi_co_phep) {
		this.so_ngay_nghi_co_phep = so_ngay_nghi_co_phep;
	}
	public int getSo_ngay_nghi_khong_phep() {
		return so_ngay_nghi_khong_phep;
	}
	public void setSo_ngay_nghi_khong_phep(int so_ngay_nghi_khong_phep) {
		this.so_ngay_nghi_khong_phep = so_ngay_nghi_khong_phep;
	}
}
