package com.atsistemas.dcmacias.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "PHONE", nullable = false, unique = true)
	private Long phone;

	@Column(name = "NAME", nullable = false, unique = false)
	private String username;

	@Column(name = "LASTNAME", nullable = false, unique = false)
	private String userlastname;

	@JoinTable(name = "rel_users_contacts", joinColumns = @JoinColumn(name = "FK_USER", nullable = false), inverseJoinColumns = @JoinColumn(name = "FK_CONTACT", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Contact> contacts;

	public void addAuthor(Contact contact) {
		if (this.contacts == null) {
			this.contacts = new ArrayList<>();
		}

		this.contacts.add(contact);
	}

}