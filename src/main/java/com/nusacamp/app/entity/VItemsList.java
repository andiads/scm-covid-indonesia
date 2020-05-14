package com.nusacamp.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "v_items_list")
public class VItemsList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_item")
	private int id;
	@Column(name="item_code")
	private String code;
	@Column(name="item_name")
	private String name;
	@Column(name="nama_brand")
	private String brand;
	@Column(name="nama_distributor")
	private String distributor;
	@Column(name="item_kemasan")
	private String packaging;
	@Column(name="item_pieces_kemasan")
	private int packagingPcs;
	@Column(name="metric_name")
	private String metricsName;
	@Column(name="nama_category")
	private String category;
	@Column(name="nama_sub_cat")
	private String subCategory;
	@Column(name="created_at")
	private String createdAt;
	@Column(name="updated_at")
	private String updatedAt;
	@Column(name="shown")
	private int shown;
	@Column(name="fullname")
	private String createdBy;
		
}
