package com.pcsoket.book.springboot.sevice.posts;

import com.pcsoket.book.springboot.domain.posts.PostsRepository;
import com.pcsoket.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return  postsRepository.save(requestDto.toEntity()).getId();
    }
}
