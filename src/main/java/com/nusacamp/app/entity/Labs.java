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
	@Column(name="shown")
	private int shown;
	@Column(name="contact_lab")
	private String contactLab;
	
}
