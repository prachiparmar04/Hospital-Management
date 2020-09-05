package com.cognizant.authenticationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservice.entity.User;

/**
 * @author POD 13
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	/**
	 * @param username
	 * @return
	 */
	Optional<User> findByUsername(String username);

	/**
	 * @param username
	 * @return
	 */
	Boolean existsByUsername(String username);

}
