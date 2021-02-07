package com.atsistemas.dcmacias.dtos;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class ContactDto {

    private String contactname;
    private Long phone;
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
    
    

}