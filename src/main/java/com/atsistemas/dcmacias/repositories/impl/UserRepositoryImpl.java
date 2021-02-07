
package com.atsistemas.dcmacias.repositories.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.atsistemas.dcmacias.domain.Contact;
import com.atsistemas.dcmacias.domain.User;
import com.atsistemas.dcmacias.repositories.UserRepository;

import io.micronaut.transaction.annotation.ReadOnly;

@Singleton
public class UserRepositoryImpl implements UserRepository {

	private final EntityManager em;

	public UserRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	@ReadOnly
	public Optional<User> findById(@NotNull Long phone) {
		return Optional.ofNullable(em.find(User.class, phone));
	}

	@Override
	@Transactional
	public User save(@NotNull Long phone, @NotBlank String name, @NotBlank String lastname) {
		User user = new User(phone, name, lastname);
		em.persist(user);
		return user;
	}

	@Override
	@ReadOnly
	public List<Contact> findByCommonContacts(Long user1phone, Long user2phone) {
		TypedQuery<Contact> query = em.createQuery(
				"SELECT DISTINCT c FROM User u LEFT JOIN u.contacts c " + "WHERE u.id = :user1 OR u.id = :user2",
				Contact.class);
		query.setParameter("user1", user1phone.longValue());
		query.setParameter("user2", user2phone.longValue());
		return query.getResultList();
	}

	@Override
	@Transactional
	public int update(@NotNull Long id, @NotBlank String name, @NotBlank String lastname) {
		return em.createQuery("UPDATE User g SET name = :name , lastname = :lastname where id = :id").setParameter("name", name)
				.setParameter("id", id).executeUpdate();
	}

}
