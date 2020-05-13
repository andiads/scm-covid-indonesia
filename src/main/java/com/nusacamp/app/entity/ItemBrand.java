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
	@Column(name="shown")
	private int shown;
	
}
