package com.waa.lab5.user.controller;

import com.waa.lab5.comment.domain.Comment;
import com.waa.lab5.exception.domain.DataNotFoundException;
import com.waa.lab5.post.domain.Post;
import com.waa.lab5.user.domain.User;
import com.waa.lab5.user.domain.dto.UserDto;
import com.waa.lab5.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id")Long id) throws DataNotFoundException {
        return new ResponseEntity<>(userService.getById(id),HttpStatus.OK);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<Post>> findAllPostsByUserId(@PathVariable("id") Long id){
        return new ResponseEntity<>(userService.findAllPostsByUserId(id),HttpStatus.OK);
    }

    // Optional
    @GetMapping("/posts")
    public ResponseEntity<List<UserDto>> findAllUsersHavingPostsGreaterThan(@RequestParam(name = "count") int count){
        return new ResponseEntity<>(userService.findAllUsersHavingPostsGreaterThan(count),HttpStatus.OK);
    }

    @GetMapping("/{userId}/posts/{postId}/comments/{commentId}")
    public ResponseEntity<Comment> getComment(@PathVariable(name = "userId") Long userId,
                                              @PathVariable(name = "postId") Long postId,
                                              @PathVariable(name = "commentId") Long commentId
    ){
        return new ResponseEntity<>(userService.findByUserIdAndPostIdAndCommentId(userId,postId,commentId),HttpStatus.OK);
    }
}
