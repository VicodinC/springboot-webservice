package com.pcsoket.book.springboot.domain.posts;

import com.pcsoket.book.springboot.web.dto.PostsUpdateRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    void update(Long id, PostsUpdateRequestDto requestDto);
}
