package com.gigsterous.auth.repository;

import com.gigsterous.auth.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Access to the user data. JpaRepository grants us convenient access methods
 * here.
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Find a user by email.
	 *
	 * @param username
	 *            the user's username
	 * @return user which contains the user with the given username or null.
	 */
	User findOneByEmail(String email);

	/**
	 * Find a user by confirmation token.
	 * 
	 * @param confirmationToken
	 * @return user associated with this confirmation token
	 */
	User findByConfirmationToken(String confirmationToken);

	/**
	 * Find a user by ID.
	 *
	 * @param id
	 *            the user's ID
	 * @return User returns an {@link User} which contains the user or null.
	 */
	User findById(Long id);
}
