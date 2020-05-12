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
@Table(name="items")
public class Items {

	@Id 
	@Column(name="id_item")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idItem;
	
	@Column(name="item_code")
	private String itemCode;
	@Column(name="item_name")
	private String itemName;
	@Column(name="item_brand")
	private String itemBrand;
	@Column(name="item_kemasan")
	private String itemKemasan;
	@Column(name="item_pieces_kemasan")
	private int itemPcsKemasan;
	@Column(name="item_metrics_pieces")
	private String itemMetricsPcs;
	@Column(name="id_category")
	private int idCategory;
	@Column(name="created_at")
	private String createdAt;
	@Column(name="updated_at")
	private String updatedAt;
	
	private int shown;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="id_brand")
	private int idBrand;
	@Column(name="id_sub_cat")
	private int idSubCat;
	@Column(name="id_distributor")
	private int idDistributor;
	@Column(name="id_metrics")
	private int idMetrics;
	
	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public String getItemKemasan() {
		return itemKemasan;
	}

	public void setItemKemasan(String itemKemasan) {
		this.itemKemasan = itemKemasan;
	}

	public int getItemPcsKemasan() {
		return itemPcsKemasan;
	}

	public void setItemPcsKemasan(int itemPcsKemasan) {
		this.itemPcsKemasan = itemPcsKemasan;
	}

	public String getItemMetricsPcs() {
		return itemMetricsPcs;
	}

	public void setItemMetricsPcs(String itemMetricsPcs) {
		this.itemMetricsPcs = itemMetricsPcs;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
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

	public int getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(int idBrand) {
		this.idBrand = idBrand;
	}

	public int getIdSubCat() {
		return idSubCat;
	}

	public void setIdSubCat(int idSubCat) {
		this.idSubCat = idSubCat;
	}

	public int getIdDistributor() {
		return idDistributor;
	}

	public void setIdDistributor(int idDistributor) {
		this.idDistributor = idDistributor;
	}

	public int getIdMetrics() {
		return idMetrics;
	}

	public void setIdMetrics(int idMetrics) {
		this.idMetrics = idMetrics;
	}

	@Override
	public String toString() {
		return "Items [idItem=" + idItem + ", itemCode=" + itemCode + ", itemName=" + itemName + ", itemBrand="
				+ itemBrand + ", itemKemasan=" + itemKemasan + ", itemPcsKemasan=" + itemPcsKemasan
				+ ", itemMetricsPcs=" + itemMetricsPcs + ", idCategory=" + idCategory + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", shown=" + shown + ", createdBy=" + createdBy + ", idBrand=" + idBrand
				+ ", idSubCat=" + idSubCat + ", idDistributor=" + idDistributor + ", idMetrics=" + idMetrics + "]";
	}

	
	
}
