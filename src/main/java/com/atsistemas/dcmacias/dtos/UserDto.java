package com.atsistemas.dcmacias.dtos;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class UserDto {

    private String username;
    private String lastname;
    private Long phone;
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}

}