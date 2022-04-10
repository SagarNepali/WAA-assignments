package com.waa.lab6.user.repository;

import com.waa.lab6.comment.domain.Comment;
import com.waa.lab6.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    void deleteById(Long id);
    @Query(value = "SELECT u from User u where u.posts.size > :count")
    List<User> findAllUsersHavingPostsGreaterThan(int count);

    @Query(value = "SELECT c from Comment c " +
            "JOIN c.post p " +
            "JOIN p.user u " +
            "where c.id=:commentId " +
            "AND u.id=:userId " +
            "AND p.id =:postId")
    Comment findByUserIdAndPostIdAndCommentId(Long userId, Long postId, Long commentId);

    @Query("Select u from User u where u.userName=:userName")
    User findByUserName(@Param("userName") String userName);
}
