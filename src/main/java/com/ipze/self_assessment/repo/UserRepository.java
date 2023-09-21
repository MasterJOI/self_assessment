package com.ipze.self_assessment.repo;

import com.ipze.self_assessment.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

	@Query("from User u  left join fetch  u.authPermissions as permissions where u.username=:username and u.isActive=true")
	Optional<User> findByUsername(String username);

	boolean existsByEmail(String email);

	boolean existsByUsername(String nickname);
}
