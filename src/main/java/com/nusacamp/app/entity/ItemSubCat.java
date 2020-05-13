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

import lombok.Data;

@Data
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
	@Column(name="shown")
	private int shown;

}
