package com.pcsoket.book.springboot.web;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @Test
    public void 메인페이지_로딩() {
        //when
        String body = this.template.getForObject("/", String.class);

        //then
        assertThat(body).contains("스프링");
    }

    @Test
    public void posts_등록_로딩() {
        //when
        String body = this.template.getForObject("/posts/save", String.class);

        //then
        assertThat(body).contains("게시물 등록");
    }
}