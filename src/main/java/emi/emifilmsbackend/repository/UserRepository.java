package emi.emifilmsbackend.repository;

import emi.emifilmsbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
