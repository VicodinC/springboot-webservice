package com.pcsoket.book.springboot.web;

import com.pcsoket.book.springboot.sevice.posts.PostsService;
import com.pcsoket.book.springboot.web.dto.PostsListResponseDto;
import com.pcsoket.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model) {
        List<PostsListResponseDto> posts = postsService.findAllDesc();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto post = postsService.findById(id);
        model.addAttribute("post", post);
        return "posts-update";
    }
}
