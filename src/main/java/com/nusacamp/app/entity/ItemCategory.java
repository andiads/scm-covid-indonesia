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
@Table(name="item_category")
public class ItemCategory {

	@Id
	@Column(name="id_category")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCategory;
	@Column(name="nama_category")
	private String namaCategory;
	@Column(name="code_category")
	private String codeCategory;
	private int shown;
	
	public ItemCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getNamaCategory() {
		return namaCategory;
	}

	public void setNamaCategory(String namaCategory) {
		this.namaCategory = namaCategory;
	}

	public String getCodeCategory() {
		return codeCategory;
	}

	public void setCodeCategory(String codeCategory) {
		this.codeCategory = codeCategory;
	}

	public int getShown() {
		return shown;
	}

	public void setShown(int shown) {
		this.shown = shown;
	}

	@Override
	public String toString() {
		return "ItemCategory [idCategory=" + idCategory + ", namaCategory=" + namaCategory + ", codeCategory="
				+ codeCategory + ", shown=" + shown + "]";
	}
	
	
}
