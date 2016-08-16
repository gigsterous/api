package com.gigsterous.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gigsterous.auth.domain.User;

/**
 * Access to the user data. JpaRepository grants us convenient access methods here.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	
	/**
	 * Find a user by username
	 *
	 * @param username the user's username
	 * @return user which contains the user with the given username or null.
	 */
	User findOneByUsername(String username);

	/**
	 * Find a user by ID
	 *
	 * @param id the user's ID
	 * @return User returns an {@link User} which contains the user or null.
	 */
	User findById(Long id);
}
