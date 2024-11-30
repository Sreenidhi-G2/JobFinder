package com.example.demo.repository;



import com.example.demo.model.Post;

import java.util.List;

public interface SearchRepository {
   List<Post> findByText(String text);
}
