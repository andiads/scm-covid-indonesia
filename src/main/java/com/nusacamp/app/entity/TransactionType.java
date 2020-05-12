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
@Table(name="transaction_type")
public class TransactionType {

	@Id
	@Column(name="id_type")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idType;
	@Column(name="tx_name")
	private String txName;
	
	public TransactionType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public String getTxName() {
		return txName;
	}

	public void setTxName(String txName) {
		this.txName = txName;
	}

	@Override
	public String toString() {
		return "TransactionType [idType=" + idType + ", txName=" + txName + "]";
	}
	
	
}
