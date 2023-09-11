package com.project.blog.repo;

import com.project.blog.models.About;
import org.springframework.data.repository.CrudRepository;

public interface AboutRepository extends CrudRepository<About, Long> {
}