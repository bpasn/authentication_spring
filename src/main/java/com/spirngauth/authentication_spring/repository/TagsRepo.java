package com.spirngauth.authentication_spring.repository;

import com.spirngauth.authentication_spring.models.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagsRepo extends JpaRepository<Tags,Long> {
}
