package com.example.multipleDatasource.repositories.secondary;

import com.example.multipleDatasource.models.secondary.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
