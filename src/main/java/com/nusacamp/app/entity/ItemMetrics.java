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
	
	public ItemMetrics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdMetrics() {
		return idMetrics;
	}

	public void setIdMetrics(int idMetrics) {
		this.idMetrics = idMetrics;
	}

	public int getIdSUbCat() {
		return idSUbCat;
	}

	public void setIdSUbCat(int idSUbCat) {
		this.idSUbCat = idSUbCat;
	}

	public String getCodeSubCat() {
		return codeSubCat;
	}

	public void setCodeSubCat(String codeSubCat) {
		this.codeSubCat = codeSubCat;
	}

	public String getMetricName() {
		return metricName;
	}

	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}

	public float getMetricSize() {
		return metricSize;
	}

	public void setMetricSize(float metricSize) {
		this.metricSize = metricSize;
	}

	public String getMetricCode() {
		return metricCode;
	}

	public void setMetricCode(String metricCode) {
		this.metricCode = metricCode;
	}

	@Override
	public String toString() {
		return "ItemMetrics [idMetrics=" + idMetrics + ", idSUbCat=" + idSUbCat + ", codeSubCat=" + codeSubCat
				+ ", metricName=" + metricName + ", metricSize=" + metricSize + ", metricCode=" + metricCode + "]";
	}
	
	
	
}
