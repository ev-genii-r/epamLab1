package com.epam.lab1.repoSQL;

import com.epam.lab1.SQL.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
