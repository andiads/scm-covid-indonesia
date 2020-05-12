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
@Table(name="item_sub_cat")
public class ItemSubCat {

	@Id
	@Column(name="id_sub_cat")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSubCat;
	@Column(name="id_cat")
	private int idCat;
	@Column(name="nama_sub_cat")
	private String namaSubCat;
	@Column(name="code_sub_cat")
	private String codeSubCat;
	private int shown;
	
	public ItemSubCat() {
		super();
	}

	public int getIdSubCat() {
		return idSubCat;
	}

	public void setIdSubCat(int idSubCat) {
		this.idSubCat = idSubCat;
	}

	public int getIdCat() {
		return idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public String getNamaSubCat() {
		return namaSubCat;
	}

	public void setNamaSubCat(String namaSubCat) {
		this.namaSubCat = namaSubCat;
	}

	public String getCodeSubCat() {
		return codeSubCat;
	}

	public void setCodeSubCat(String codeSubCat) {
		this.codeSubCat = codeSubCat;
	}

	public int getShown() {
		return shown;
	}

	public void setShown(int shown) {
		this.shown = shown;
	}

	@Override
	public String toString() {
		return "ItemSubCat [idSubCat=" + idSubCat + ", idCat=" + idCat + ", namaSubCat=" + namaSubCat + ", codeSubCat="
				+ codeSubCat + ", shown=" + shown + "]";
	}
	
	
}
