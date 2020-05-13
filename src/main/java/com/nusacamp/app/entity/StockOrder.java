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
@Table(name="stock_order")
public class StockOrder {

	@Id
	@Column(name="id_sto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStock;
	
	@Column(name="transaction_type")
	private int trxType;
	
	@Column(name="sto_send_time")
	private String sendTime;
	
	@Column(name="sto_arrive_time")
	private String arriveTime;
	
	@Column(name="created_at")
	private String createdAt;
	
	@Column(name="updated_at")
	private String updatedAt;
	
	@Column(name="shown")
	private int shown;
	
	@Column(name="delete_reason")
	private String deleteReason;
	@Column(name="sto_source")
	private int stockSource;
	@Column(name="sto_source_desc")
	private String stockSourceDesc;
	@Column(name="id_batch")
	private String idBatch;
	@Column(name="receipt")
	private String receipt;
	
	@Column(name="source_point")
	private int sourcePoint;
	
	@Column(name="end_point")
	private int endPoint;
	@Column(name="description")
	private String description;
	@Column(name="status")
	private int status;
	
	@Column(name="id_ref")
	private int idRef;

}
