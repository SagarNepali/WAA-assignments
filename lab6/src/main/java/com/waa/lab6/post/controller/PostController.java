package com.waa.lab6.post.controller;

import com.waa.lab6.post.domain.Post;
import com.waa.lab6.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin
public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<?>> findAll(@RequestHeader(name = "X-API-VERSION-2",required = false,defaultValue = "false") Boolean header){
        if(header){
            System.out.println("Providing data from DTO");
            return new ResponseEntity<>(postService.fetchAllDto(),HttpStatus.OK);
        }
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/filter/author")
    public ResponseEntity<List<?>> filterByAuthor(@RequestHeader(name = "X-API-VERSION-2",required = false,
            defaultValue = "false") Boolean header,@RequestParam(name = "query") String query){
        if(header){
            System.out.println("Providing data from DTO");
            return new ResponseEntity<>(postService.filterByAuthorDto(query),HttpStatus.OK);
        }
        return new ResponseEntity<>(postService.filterByAuthor(query), HttpStatus.OK);
    }

    @GetMapping("/filter/title")
    public ResponseEntity<List<?>> filterByTitle(@RequestHeader(name = "X-API-VERSION-2",required = false,
            defaultValue = "false") Boolean header,@RequestParam(name = "query") String query){
        if(header){
            System.out.println("Providing data from DTO");
            return new ResponseEntity<>(postService.filterByTitleDto(query),HttpStatus.OK);
        }
        return new ResponseEntity<>(postService.filterByTitle(query), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@RequestBody Post p, Principal principal){
        postService.save(p, (principal!=null) ? principal.getName() : "user");
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable long id, @RequestBody Post p){
        postService.update(id,p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id){
        postService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable long id){
        return new ResponseEntity<>(postService.getById(id),HttpStatus.OK);
    }


}
