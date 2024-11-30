package com.example.demo.controller;


import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins="http://localhost:3005/")
//@RequestMapping("/post")
public class PostController

{
    @Autowired
    PostRepository repo;
    @Autowired
    SearchRepository srepo;


//    @RequestMapping(value = "/")
//    public void redirect(HttpServletResponse response) throws IOException {
//       response.sendRedirect("/swagger-ui.html");
//    }
    @GetMapping("/hello")
    public String greet(){
        return "Hello World";
    }



    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPosts()
    {   
        return repo.findAll();
    }

    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text)
    {
        return srepo.findByText(text);
    }


    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post)
    {
         return repo.save(post);
    }




}
