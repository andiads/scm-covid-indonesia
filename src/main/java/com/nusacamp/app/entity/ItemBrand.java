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
@Table(name="item_brand")
public class ItemBrand {

	@Id
	@Column(name="id_brand")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBrand;
	@Column(name="code_brand")
	private String codeBrand;
	@Column(name="nama_brand")
	private String namaBrand;
	private int shown;
	
	public ItemBrand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(int idBrand) {
		this.idBrand = idBrand;
	}

	public String getCodeBrand() {
		return codeBrand;
	}

	public void setCodeBrand(String codeBrand) {
		this.codeBrand = codeBrand;
	}

	public String getNamaBrand() {
		return namaBrand;
	}

	public void setNamaBrand(String namaBrand) {
		this.namaBrand = namaBrand;
	}

	public int getShown() {
		return shown;
	}

	public void setShown(int shown) {
		this.shown = shown;
	}

	@Override
	public String toString() {
		return "ItemBrand [idBrand=" + idBrand + ", codeBrand=" + codeBrand + ", namaBrand=" + namaBrand + ", shown="
				+ shown + "]";
	}
	
	
}
