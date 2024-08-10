package com.example.multipleDatasource.repositories.primary;

import com.example.multipleDatasource.models.primary.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
