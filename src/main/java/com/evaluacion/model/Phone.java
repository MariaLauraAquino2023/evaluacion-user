package com.evaluacion.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="PHONES")
public class Phone {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id")
	private UUID id;
	@Column(name = "city_code")
	private String cityCode;

	@Column(name = "country_code")
	private String countryCode;

	@Column(name = "number")
	private String number;

	@Column(name = "user_id")
	private String userId;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getNumber(){ return number;}

	public void setNumber(String number){this.number = number;}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}

