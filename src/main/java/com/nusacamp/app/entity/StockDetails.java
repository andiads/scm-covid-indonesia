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
@Table(name="stock_details")
public class StockDetails {

	@Id
	@Column(name="id_transaction")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTransaction;
	
	@Column(name="id_sto")
	private int idStock;
	@Column(name="id_sto_ref")
	private int idStockRef;
	@Column(name="amount")
	private int amount;
	
	@Column(name="id_item")
	private int idItem;
	
	@Column(name="created_at")
	private String createdAt;
	@Column(name="updated_at")
	private String updatedAt;
	@Column(name="shown")
	private int shown;
	
	@Column(name="created_by")
	private int createdBy;

}
