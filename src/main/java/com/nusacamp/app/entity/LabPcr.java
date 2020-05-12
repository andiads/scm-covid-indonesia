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
@Table(name="lab_pcr")
public class LabPcr {

	@Id
	@Column(name="id_pcr")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPcr;
	
	@Column(name="id_lab")
	private int idLab;
	
	private String brand;
	
	private int capacity;
	
	@Column(name="created_at")
	private String createdAt;
	@Column(name="updated_at")
	private String updatedAt;
	@Column(name="created_by")
	private int createdBy;
	
	public LabPcr() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdPcr() {
		return idPcr;
	}

	public void setIdPcr(int idPcr) {
		this.idPcr = idPcr;
	}

	public int getIdLab() {
		return idLab;
	}

	public void setIdLab(int idLab) {
		this.idLab = idLab;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
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

	@Override
	public String toString() {
		return "LabPcr [idPcr=" + idPcr + ", idLab=" + idLab + ", brand=" + brand + ", capacity=" + capacity
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", createdBy=" + createdBy + "]";
	}
	
	
}
