package com.waa.lab3.user.repository;

import com.waa.lab3.comment.domain.Comment;
import com.waa.lab3.user.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
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

    @Query(value = "SELECT c from Comment  c " +
            " JOIN c.post p " +
            " JOIN p.user u " +
            " WHERE c.id=:commentId " +
            " AND p.id=:postId " +
            " AND u.id=:userId ")
    Comment findByUserIdAndPostIdAndCommentId(Long userId, Long postId, Long commentId);

}
