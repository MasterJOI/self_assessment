package com.ipze.self_assessment.repo;

import com.ipze.self_assessment.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("from User u where u.email=:email and u.isActive=true")
	Optional<User> findByEmail(String email);
}
