package com.example.multipleDatasource.configs;

import com.example.multipleDatasource.models.primary.User;
import com.example.multipleDatasource.models.secondary.Post;
import com.example.multipleDatasource.repositories.primary.UserRepository;
import com.example.multipleDatasource.repositories.secondary.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DatabaseInitialize implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = List.of(new User(10L, "아무개", 12));
        userRepository.saveAll(users);

        List<Post> posts = List.of(new Post(10L, "제목10", "내용물12"));
        postRepository.saveAll(posts);
    }
}
