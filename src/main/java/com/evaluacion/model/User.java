package com.evaluacion.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name ="USERS")
public class User {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id")
	private UUID id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "created")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date created;

	@Column(name = "modified")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date modified;

	@Column(name = "last_login")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date lastLogin;

	@Column(name = "access_token")
	private String token;

	@Column(name = "is_active")
	private Boolean isActive;

	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private List<Phone> phones = new ArrayList<>();

	public UUID getId() {
		return id;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}


	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean active) {
		isActive = active;
	}


}