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
	
	private int shown;
	
	@Column(name="delete_reason")
	private String deleteReason;
	@Column(name="sto_source")
	private int stockSource;
	@Column(name="sto_source_desc")
	private String stockSourceDesc;
	@Column(name="id_batch")
	private String idBatch;
	
	private String receipt;
	
	@Column(name="source_point")
	private int sourcePoint;
	
	@Column(name="end_point")
	private int endPoint;
	
	private String description;
	
	private int status;
	
	@Column(name="id_ref")
	private int idRef;

	public StockOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public int getTrxType() {
		return trxType;
	}

	public void setTrxType(int trxType) {
		this.trxType = trxType;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
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

	public String getDeleteReason() {
		return deleteReason;
	}

	public void setDeleteReason(String deleteReason) {
		this.deleteReason = deleteReason;
	}

	public int getStockSource() {
		return stockSource;
	}

	public void setStockSource(int stockSource) {
		this.stockSource = stockSource;
	}

	public String getStockSourceDesc() {
		return stockSourceDesc;
	}

	public void setStockSourceDesc(String stockSourceDesc) {
		this.stockSourceDesc = stockSourceDesc;
	}

	public String getIdBatch() {
		return idBatch;
	}

	public void setIdBatch(String idBatch) {
		this.idBatch = idBatch;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public int getSourcePoint() {
		return sourcePoint;
	}

	public void setSourcePoint(int sourcePoint) {
		this.sourcePoint = sourcePoint;
	}

	public int getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIdRef() {
		return idRef;
	}

	public void setIdRef(int idRef) {
		this.idRef = idRef;
	}

	@Override
	public String toString() {
		return "StockOrder [idStock=" + idStock + ", trxType=" + trxType + ", sendTime=" + sendTime + ", arriveTime="
				+ arriveTime + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", shown=" + shown
				+ ", deleteReason=" + deleteReason + ", stockSource=" + stockSource + ", stockSourceDesc="
				+ stockSourceDesc + ", idBatch=" + idBatch + ", receipt=" + receipt + ", sourcePoint=" + sourcePoint
				+ ", endPoint=" + endPoint + ", description=" + description + ", status=" + status + ", idRef=" + idRef
				+ "]";
	}
	
	
}
