package com.atsistemas.dcmacias.repositories;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.atsistemas.dcmacias.domain.Contact;
import com.atsistemas.dcmacias.domain.User;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;

@Repository
public interface UserRepository {
	
	@Executable
	List<Contact> findByCommonContacts(Long user1phone,Long user2phone);
	
	Optional<User> findById(@NotNull Long id);

    int update(@NotNull Long id, @NotBlank String name, @NotBlank String lastname);

	User save(@NotNull Long phone, @NotBlank String name, @NotBlank String lastname);

}