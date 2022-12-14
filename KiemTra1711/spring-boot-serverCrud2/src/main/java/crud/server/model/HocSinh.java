package crud.server.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hocsinh")
public class HocSinh {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long mahs_syanh;
	
	@Column(name = "lophoc")
	private String lophoc;
	
	@Column(name = "quequan")
	private String quequan;
	
	@Column(name = "diemtoan")
	private float diemtoan;
	
	@Column(name = "diemvan")
	private float diemvan;
	
	@Column(name = "ngayvaotruong")
	private String ngayvaotruong;
	
	public HocSinh() {
		
	}
	

	public HocSinh(String lophoc, String quequan, float diemtoan, float diemvan, String ngayvaotruong) {
		this.lophoc = lophoc;
		this.quequan = quequan;
		this.diemtoan = diemtoan;
		this.diemvan = diemvan;
		this.ngayvaotruong = ngayvaotruong;
	}


	public long getMahs_syanh() {
		return mahs_syanh;
	}


	public void setMahs_syanh(long mahs_syanh) {
		this.mahs_syanh = mahs_syanh;
	}


	public String getLophoc() {
		return lophoc;
	}


	public void setLophoc(String lophoc) {
		this.lophoc = lophoc;
	}


	public String getQuequan() {
		return quequan;
	}


	public void setQuequan(String quequan) {
		this.quequan = quequan;
	}


	public float getDiemtoan() {
		return diemtoan;
	}


	public void setDiemtoan(float diemtoan) {
		this.diemtoan = diemtoan;
	}


	public float getDiemvan() {
		return diemvan;
	}


	public void setDiemvan(float diemvan) {
		this.diemvan = diemvan;
	}


	public String getNgayvaotruong() {
		return ngayvaotruong;
	}


	public void setNgayvaotruong(String ngayvaotruong) {
		this.ngayvaotruong = ngayvaotruong;
	}


	@Override
	public String toString() {
		return "Student [mahs_syanh=" + mahs_syanh + ", lophoc=" + lophoc + ", quequan=" + quequan + ", diemtoan="
				+ diemtoan + ", diemvan=" + diemvan + ", ngayvaotruong=" + ngayvaotruong + "]";
	}
	
	
	
	


	

	

}

