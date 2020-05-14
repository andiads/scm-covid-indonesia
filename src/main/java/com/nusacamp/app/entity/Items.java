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
@Table(name="items")
public class Items {

	@Id 
	@Column(name="id_item")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	@Column(name="item_code")
	private String code;
	@Column(name="item_name")
	private String name;
	@Column(name="item_brand")
	private String brand;
	@Column(name="item_kemasan")
	private String packaging;
	@Column(name="item_pieces_kemasan")
	private int packagingPcs;
	@Column(name="item_metrics_pieces")
	private String metricsName;
	@Column(name="id_category")
	private int idCategory;
	@Column(name="created_at")
	private String createdAt;
	@Column(name="updated_at")
	private String updatedAt;
	@Column(name="shown")
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
		
}
