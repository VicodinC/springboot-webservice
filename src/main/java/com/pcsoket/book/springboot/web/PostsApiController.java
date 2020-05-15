package com.pcsoket.book.springboot.web;

import com.pcsoket.book.springboot.sevice.posts.PostsService;
import com.pcsoket.book.springboot.web.dto.PostsResponseDto;
import com.pcsoket.book.springboot.web.dto.PostsSaveRequestDto;
import com.pcsoket.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto get(@PathVariable Long id) {
        return  postsService.findById(id);
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return  postsService.save(requestDto);
    }

    @PostMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return  postsService.update(id, requestDto);
    }
}
