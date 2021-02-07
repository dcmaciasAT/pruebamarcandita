package com.atsistemas.dcmacias.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "USER")
public class User {
	
	public User() {	
	}

	public User(Long phone, String username, String userlastname) {
		this.phone = phone;
		this.username = username;
		this.userlastname = userlastname;		
	}

	@Id
	@Column(name = "PHONE", nullable = false, unique = true)
	private Long phone;

	@Column(name = "NAME", nullable = false, unique = false)
	private String username;

	@Column(name = "LASTNAME", nullable = false, unique = false)
	private String userlastname;

	@JoinTable(name = "rel_users_contacts", joinColumns = @JoinColumn(name = "FK_USER", nullable = false), inverseJoinColumns = @JoinColumn(name = "FK_CONTACT", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Contact> contacts;

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserlastname() {
		return userlastname;
	}

	public void setUserlastname(String userlastname) {
		this.userlastname = userlastname;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	
	public void addContact (Contact contact) {
		if (this.contacts == null) {
			this.contacts = new HashSet<Contact>();
		}

		this.contacts.add(contact);
	}


}