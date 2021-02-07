package com.atsistemas.dcmacias.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.micronaut.data.annotation.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "CONTACT")
public class Contact {

	public Contact() {
	}

	public Contact(@NotNull Long phone, @NotNull String contactName) {
		this.phone = phone;
		this.contactName = contactName;
	}

	@Id
	@NotNull
	@Column(name = "PHONE", nullable = false, unique = true)
	private Long phone;

	@NotNull
	@Column(name = "NAME", nullable = false, unique = false)
	private String contactName;

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

}
