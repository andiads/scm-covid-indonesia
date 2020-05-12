package com.nusacamp.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Entity
@Table(name="labs")
public class Labs {

	@Id
	@Column(name="id_lab")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLab;
	
	@Column(name="code_lab")
	private String codeLab;
	
	@Column(name="nama_lab")
	private String namaLab;
	@Column(name="alamat_lab")
	private String alamatLab;
	@Column(name="pic_lab")
	private String picLab;
	@Column(name="mail_lab")
	private String mailLab;
	@Column(name="created_at")
	private String createdAt;
	@Column(name="updated_at")
	private String updatedAt;
	@Column(name="created_by")
	private int createdBy;
	
	private int shown;
	
	@Column(name="contact_lab")
	private String contactLab;

	public Labs() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdLab() {
		return idLab;
	}

	public void setIdLab(int idLab) {
		this.idLab = idLab;
	}

	public String getCodeLab() {
		return codeLab;
	}

	public void setCodeLab(String codeLab) {
		this.codeLab = codeLab;
	}

	public String getNamaLab() {
		return namaLab;
	}

	public void setNamaLab(String namaLab) {
		this.namaLab = namaLab;
	}

	public String getAlamatLab() {
		return alamatLab;
	}

	public void setAlamatLab(String alamatLab) {
		this.alamatLab = alamatLab;
	}

	public String getPicLab() {
		return picLab;
	}

	public void setPicLab(String picLab) {
		this.picLab = picLab;
	}

	public String getMailLab() {
		return mailLab;
	}

	public void setMailLab(String mailLab) {
		this.mailLab = mailLab;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getShown() {
		return shown;
	}

	public void setShown(int shown) {
		this.shown = shown;
	}

	public String getContactLab() {
		return contactLab;
	}

	public void setContactLab(String contactLab) {
		this.contactLab = contactLab;
	}

	@Override
	public String toString() {
		return "Labs [idLab=" + idLab + ", codeLab=" + codeLab + ", namaLab=" + namaLab + ", alamatLab=" + alamatLab
				+ ", picLab=" + picLab + ", mailLab=" + mailLab + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", createdBy=" + createdBy + ", shown=" + shown + ", contactLab=" + contactLab + "]";
	}
	
	
}
