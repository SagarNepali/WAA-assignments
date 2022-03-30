package com.waa.lab1.repository;

import com.waa.lab1.domain.Post;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private static List<Post> posts;
    private static long id=10000;

    static {
        posts = new ArrayList<>(){{
            add(new Post(id++,"Spring","It's a framework","Rod Johnson"));
            add(new Post(id++,"Spring Boot","Eliminates the configurations","Rod Johnson"));
            add(new Post(id++,"Controller","It's a framework","John Doe"));
        }};
    }

    @Override
    public void save(Post p) {
        p.setId(id);
        posts.add(p);
        id++;
    }

    @Override
    public void update(Post p) {
        Post old = getById(p.getId());
        old.setAuthor(p.getAuthor());
        old.setContent(p.getContent());
        old.setTitle(p.getTitle());

    }

    @Override
    public void delete(long id) {
        posts.remove(getById(id));
    }

    @Override
    public Post getById(long id) {
        return posts
                .stream()
                .filter(post -> post.getId()==id)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return posts;
    }
}
