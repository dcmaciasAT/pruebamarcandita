package com.atsistemas.dcmacias.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class UserDto {

	public UserDto(String name, String lastName, long phone) {
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
	}

	@NotBlank
	@NotNull
	private String name;

	@NotBlank
	@NotNull
	private String lastName;

	@NotNull
	private long phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setSeconds(long phone) {
		this.phone = phone;
	}
}
