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
@Table(name="lab_pcr")
public class LabPcr {

	@Id
	@Column(name="id_pcr")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPcr;
	
	@Column(name="id_lab")
	private int idLab;
	@Column(name="brand")
	private String brand;
	@Column(name="capacity")
	private int capacity;
	@Column(name="created_at")
	private String createdAt;
	@Column(name="updated_at")
	private String updatedAt;
	@Column(name="created_by")
	private int createdBy;
	
}
