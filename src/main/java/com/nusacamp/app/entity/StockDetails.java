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
	
	private int amount;
	
	@Column(name="id_item")
	private int idItem;
	
	@Column(name="created_at")
	private String createdAt;
	@Column(name="updated_at")
	private String updatedAt;
	
	private int shown;
	
	@Column(name="created_by")
	private int createdBy;

	public StockDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdTransaction() {
		return idTransaction;
	}

	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}

	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public int getIdStockRef() {
		return idStockRef;
	}

	public void setIdStockRef(int idStockRef) {
		this.idStockRef = idStockRef;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
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

	public int getShown() {
		return shown;
	}

	public void setShown(int shown) {
		this.shown = shown;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "StockDetails [idTransaction=" + idTransaction + ", idStock=" + idStock + ", idStockRef=" + idStockRef
				+ ", amount=" + amount + ", idItem=" + idItem + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", shown=" + shown + ", createdBy=" + createdBy + "]";
	}
	
	
}
