package com.atsistemas.dcmacias.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CONTACT")
public class Contact  {

	@Id
	@Column(name = "PHONE", nullable = false, unique = true)
	private Long phone;

	@Column(name = "NAME", nullable = false, unique = false)
	private String contactName;


}
