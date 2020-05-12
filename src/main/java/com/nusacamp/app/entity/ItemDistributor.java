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
@Table(name="item_distributor")
public class ItemDistributor {

	@Id
	@Column(name="id_distributor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDistributor;
	@Column(name="nama_distributor")
	private String namaDistributor;
	@Column(name="kode_distributor")
	private String kodeDistributor;
	private int shown;
	
	public ItemDistributor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdDistributor() {
		return idDistributor;
	}

	public void setIdDistributor(int idDistributor) {
		this.idDistributor = idDistributor;
	}

	public String getNamaDistributor() {
		return namaDistributor;
	}

	public void setNamaDistributor(String namaDistributor) {
		this.namaDistributor = namaDistributor;
	}

	public String getKodeDistributor() {
		return kodeDistributor;
	}

	public void setKodeDistributor(String kodeDistributor) {
		this.kodeDistributor = kodeDistributor;
	}

	public int getShown() {
		return shown;
	}

	public void setShown(int shown) {
		this.shown = shown;
	}

	@Override
	public String toString() {
		return "ItemDistributor [idDistributor=" + idDistributor + ", namaDistributor=" + namaDistributor
				+ ", kodeDistributor=" + kodeDistributor + ", shown=" + shown + "]";
	}
	
	
}
