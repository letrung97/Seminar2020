package bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class danhmuc {
	private String kind;
    private JPanel jpn;
    private JLabel jlb;
    
	public danhmuc(String kind, JPanel jpn, JLabel jlb) {
		this.kind = kind;
		this.jpn = jpn;
		this.jlb = jlb;
	}
	public danhmuc() {
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public JPanel getJpn() {
		return jpn;
	}
	public void setJpn(JPanel jpn) {
		this.jpn = jpn;
	}
	public JLabel getJlb() {
		return jlb;
	}
	public void setJlb(JLabel jlb) {
		this.jlb = jlb;
	}
    
}
