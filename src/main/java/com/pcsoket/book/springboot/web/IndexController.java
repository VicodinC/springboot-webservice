package com.pcsoket.book.springboot.web;

import com.pcsoket.book.springboot.config.auth.LoginUser;
import com.pcsoket.book.springboot.config.auth.dto.SessionUser;
import com.pcsoket.book.springboot.domain.user.User;
import com.pcsoket.book.springboot.sevice.posts.PostsService;
import com.pcsoket.book.springboot.web.dto.PostsListResponseDto;
import com.pcsoket.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        List<PostsListResponseDto> posts = postsService.findAllDesc();
        model.addAttribute("posts", posts);

        if( user != null) {
            model.addAttribute("userName", user.getName());
        }
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
