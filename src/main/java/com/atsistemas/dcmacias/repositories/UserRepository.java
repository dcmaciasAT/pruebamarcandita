package com.atsistemas.dcmacias.repositories;

import java.util.List;

import com.atsistemas.dcmacias.domain.Contact;
import com.atsistemas.dcmacias.domain.User;

import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Executable
    List<User> findByCommonContacts(Long user1phone,Long user2phone);

	@Query("FROM User u , Contact c WHERE u.phone = :t ORDER BY b.title")
    List<Contact> findAllContacts(Long userphone);
    
	@Executable
	User findByPhone(Long phone);
    

}