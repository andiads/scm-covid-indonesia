package com.nusacamp.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nusacamp.app.entity.UserType;
import javax.persistence.JoinColumn;
import lombok.*;
import javax.persistence.Transient;

@Data
@Entity
@Table(name="user")
//@JsonIgnoreProperties(value = {"password"})
public class User {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="mail")
	private String mail;
	@Column(name="fullname")
	private String fullname;
	@Column(name="password")
	private String password;
	@Column(name="user_type")	
	private int userType;
	@Column(name="last_login", nullable=true)
	private String lastLogin;
	@Column(name="last_ip")
	private String lastIp;
	@Column(name="status")
	private int status;	
	@Column(name="created_at")
	private String createdAt;
	@Column(name="updated_at")
	private String updatedAt;
	// not persistent. There is no column on database table.
	@Transient
	private String token;
	
}
