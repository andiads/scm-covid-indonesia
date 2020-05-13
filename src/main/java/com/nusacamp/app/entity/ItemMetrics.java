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
@Table(name="item_metrics")
public class ItemMetrics {

	@Id
	@Column(name="id_metrics")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMetrics;
	@Column(name="id_sub_cat")
	private int idSUbCat;
	@Column(name="code_sub_cat")
	private String codeSubCat;
	@Column(name="metric_name")
	private String metricName;
	@Column(name="metric_size")
	private float metricSize;
	@Column(name="metric_code")
	private String metricCode;
		
}
